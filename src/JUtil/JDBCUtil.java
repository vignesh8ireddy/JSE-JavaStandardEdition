package JUtil;

import java.sql.*;

public class JDBCUtil {

    public static Connection getJdbcConnection() throws SQLException{
        Connection connObj = null;
        String url = "jdbc:mysql://localhost:3306/student_schema";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connObj = DriverManager.getConnection(url,user,password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return connObj;
    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection)
            throws SQLException {

        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();

        }
        if (connection != null) {
            connection.close();
        }

    }
}