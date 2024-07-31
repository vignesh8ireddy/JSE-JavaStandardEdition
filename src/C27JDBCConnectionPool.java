import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C27JDBCConnectionPool {
    /*
    Connection Pooling
    ==================
    > If we required to communicate with database multiple times then it is not
    recommended to create separate Connection object every time, b'z creating and
    destroying Connection object every time creates performance problems.
    > To overcome this problem, we should go for Connection Pool.
    > Connection Pool is a pool of already created Connection objects which are ready
    to use.
    > If we want to communicate with database then we request Connection pool to
    provide Connection.
    Once we got the Connection, by using that we can communicate with database and after
    completing our work, we can return Connection to the pool instead of destroying.
    Hence, the main advantage of Connection Pool is we can reuse same Connection
    object multiple times, so that overall performance of application will be improved.

    Process to implement Connection Pooling:

    1. Creation of DataSource object
    DataSource is responsible to manage connections in Connection Pool.
    DataSource is an interface present in javax.sql package.
    Driver Software vendor is responsible to provide implementation.
    Oracle people provided implementation class name is: OracleConnectionPoolDataSource.
    This class present inside oracle.jdbc.pool package and it is the part of ojdbc6.jar.
    OracleConnectionPoolDataSource ds= new OracleConnectionPoolDataSource();
    MySqlConnectionPoolDataSource ds= new MySqlConnectionPoolDataSource();

    2. Set required JDBC Properties to the DataSource object:
    ds.setURL("jdbc:oracle:thin:@localhost:1521:XE");
    ds.setUser("scott");
    ds.setPassword("tiger");

    3. Get Connection from DataSource object:
    Connection con = ds.getConnection();
    Once we got Connection object then remaining process is as usual.

    Note:
    This way of implementing Connection Pool is useful for Standalone applications. In
    the case of web and enterprise applications, we have to use server level connection pooling.
    Every web and application server can provide support for Connection Pooling.

    Q. What is the difference Between getting Connection object by using DriverManager
    and DataSource object?
    > In the case of DriverManager.getConnection(), always a new Connection object
    will be created and returned.
    > But in the case of DataSourceObject.getConnection(), a new Connection object
    won't be created
    and existing Connection object will be returned from Connection Pool.
    */

    public static void main(String[] args) throws SQLException {

        // Creating a pooled connection object
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();

        dataSource.setURL("jdbc:mysql://localhost:3306/student_schema");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        // logical connection brought from connection pool
        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM studenttemp");

        while (resultSet.next()) {
            int sid = resultSet.getInt(1);
            String sname = resultSet.getString(2);
            System.out.println(sid + "\t" + sname);
        }

        // sending the connection object back to connection pool
        connection.close();

    }

}


/*
 * Stored Procedure
   ================

 In our program, if we have any code which is repeatedly required, then we write that
 code inside function and we call that function multiple times as per our needs.
 so we say functions are reusability component.

 similarly in database requirement, if we want set of sql queries which are repeatedly
 used, then we write those set of statements in single group and we call that group based on our requirement.
 This group of sql statements only we call as "StoredProcedure".
 This stored procedure is stored inside dbengine permanently and we need to just make
 a call to it.

 */


    /*  DELIMITER $$
        CREATE
            [DEFINER = { user | CURRENT_USER }]
            PROCEDURE `enterprisejavabatch`.`getStudents`( IN id INT )

            BEGIN
                SELECT sid,sname,saddr
                FROM student
                WHERE sid = id;
            END$$

        DELIMITER ;
    */

    /*


    import java.sql.CallableStatement;
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    import in.ineuron.jdbcUtil.JdbcUtil;



    public class RetrieveStudentRecordApp {

        public static void main(String[] args) {
            Connection connection = null;
            CallableStatement cstmt = null;
            ResultSet resultSet = null;
            Integer id = 7;

            //CallableStatement extends PreparedStatement extends Statement

            try {
                // Getting the database connection using utility code
                connection = JdbcUtil.getJdbcConnection();

                // Syntax for stroed procedure => {call procedure_name(?,?,?,....)}
                String storedProcedure = "{call getStudents(?)}";

                if (connection != null)
                    cstmt = connection.prepareCall(storedProcedure);

                if (cstmt != null) {
                    // before calling set the input value to StoredProcedure
                    cstmt.setInt(1, id);

                    // execute the stored procedure
                    cstmt.execute();//executeQuery() doesn't work here

                    // fetching the resultSet from StoredProcedure
                    resultSet = cstmt.getResultSet();
                }
                if (resultSet != null) {

                    if (resultSet.next()) {
                        int sid = resultSet.getInt(1);
                        String sname = resultSet.getString(2);
                        String saddr = resultSet.getString(3);
                        System.out.println("SID\tSNAME\tSADDR");
                        System.out.println(sid + "\t" + sname + "\t" + saddr);
                    } else {
                        System.out.println("Record not found for the id :: " + id);
                    }
                }

            } catch (SQLException e) {
                // handling logic of exception related to SQLException
                e.printStackTrace();
            } catch (Exception e) {
                // hanlding logic of exception related to common problem
                e.printStackTrace();
            } finally {

                // closing the resource
                try {
                    JdbcUtil.closeConnection(resultSet, cstmt, connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    */


 /*
    DELIMITER $$

    CREATE
        [DEFINER = { user | CURRENT_USER }]
        PROCEDURE `enterprisejavabatch`.`getStudentsById`(IN id INT,OUT stdName VARCHAR(20),OUT stdAddr VARCHAR(20))

    	BEGIN
	    	SELECT sname,saddr INTO stdName,stdAddr
		    FROM student
		    WHERE sid = id;
	    END$$

    DELIMITER ;
   */




/*

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;


public class RetrieveRecordsApp {

	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cstmt = null;
		Integer id = 7;

		try {
			// Getting the database connection using utility code
			connection = JdbcUtil.getJdbcConnection();

			// Syntax for stroed procedure => {call procedure_name(?,?,?,....)}
			String storedProcedure = "{call getStudentsById(?,?,?)}";

			if (connection != null)
				cstmt = connection.prepareCall(storedProcedure);

			if (cstmt != null) {
				// before calling set the input value to StoredProcedure
				cstmt.setInt(1, id);

				//register the Outputparameter with the specific data for conversion
				//use JDBCTypes to map all java datatypes to dbspecific datatypes
				cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter(3, Types.VARCHAR);
				//informing the driver to convert varchar output to java.lang.String

				//execute the query
				cstmt.execute();

				//Retreiving the value
				System.out.println("Name   of the student is :: "+cstmt.getString(2));
				System.out.println("Addres of the student is :: "+cstmt.getString(3));

			}

		} catch (SQLException e) {
			// handling logic of exception related to SQLException
			e.printStackTrace();
		} catch (Exception e) {
			// hanlding logic of exception related to common problem
			e.printStackTrace();
		} finally {

			// closing the resource
			try {
				JdbcUtil.closeConnection(null, cstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}



 */