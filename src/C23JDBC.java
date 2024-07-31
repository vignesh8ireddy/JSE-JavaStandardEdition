import java.sql.*;

/*
The following are some of the databases which are widely used:
	1. MySql
	2. Oracle
	3. PostGreSql

Java : WORA - Write Once, Run Anywhere

Java is a Sun Micro System product

API = Collection of Interfaces and Classes which makes a useful
framework

JDBC API (Interfaces and Classes :: Rules) is developed by SunMicro Systems to facilitate communication between java code and different
types of databases.
JDBC API is present in JDK/java.sql/rt.jar file
rt.jar => runtime.jar file
jar means set of .class files i.e Java ARchive files

Each database has different type of working code. So they give their own implementation of Interfaces in JDBC API in the form
of jar files called (DRIVER SOFTWARE) which our code is going to use to communicate with those databases.
For example, mysql-conn.jar is provided by MySql database in it's driver (you have to download it from mysql website) in which the classes implement Interfaces from JDBC API, using this
classes we can connect to the database.

developer's java code (java.sql.*;) <----java---> MySql Driver (mysql.conn.jar) <----SQL---> mysql database

To communicate with database there four generations of drivers. We are going to use 4th generation(latest) driver.

PATH contains environmental variables of operating system which provides .exe file location of software/apps (to operating systems) which has to be
executed from the command prompt    [set PATH = ..../bin]  //bin has .exe files
CLASSPATH contains environmental variables which provides .class files location to JDK so that they can be executed from the command prompt
		[set CLASSPATH = ..../.jar] //.jar files has .class files


A JDBC Application:

Standard Steps followed for developing JDBC(JDBC4.X) Application
----------------------------------------------------------------

1. CREATE(LOAD) and REGISTER the JDBC Driver Object
2. ESTABLISH the Connection between java application and database
3. CREATE a statement object
4. SEND and EXECUTE the Statement
5. PROCESS result
6. CLOSE connection


	Step1:

	1. Load and register the Driver

	A third party db vendor class which implements java.sql.Driver interface is called as "Driver".
	This class Object we need to create and register it with JRE to set up JDBC environment
	to run jdbc applications.

		command prompt commands
 		set PATH = '..../jdk/bin' => you can run java files in command prompt
   		set CLASSPATH = '..../mysql-connector-driver.jar' => jdk can access .class files provided by mysql which implemented JDBC API

	Note:

	public class com.mysql.cj.jdbc.Driver extends
	com.mysql.cj.jdbc.NonRegisteringDriver implements java.sql.Driver {
		public com.mysql.cj.jdbc.Driver() throws java.sql.SQLException;
		static {};
	}

	In MySQL Jar, Driver class is implementing java.sql.Driver, so Driver class Object
	should be created and it should be registered to set up the JDBC environment inside JRE.

		 Driver driverObj = new Driver(); DriverManager.registerDriver(driverObj);
		 System.out.println("Driver instantiated successfully");


	2. Establish the Connection b/w java application and database

	public static Connection getConnection(String url, String username,String
	password) throws SQLException;

	public static Connection getConnection(String url, Properties) throws
	SQLException;

	public static Connection getConnection(String url) throws SQLException;

	The below creates the Object of Connection interface.
	Connection connection = DriverManager.getConnection(url,username,password);
	|
	getConnection(url,username,password) creates an object of class which implements Connection(I)
	that class object is collected by Connection(I).
	This feature in java refers to polymorphism(making code run in 1:M forms)

	Can we create an Object for Interface?
	Answer. no
	Can we create an Object for a class which implements interface?
	Answer : yes

	3. Create a Statement Object
	public abstract Statement createStatement() throws SQLException;
	public abstract Statement createStatement(int,int) throws SQLException;
	public abstract Statement createStatement(int,int,int) throws SQLException;
	Statement statement = connection.createStatement();

	4. Send and execute the Query


	Query
	-----
	From DB administrator perspective queries are classified into 5 types
	1. DDL (Create table,alter table,drop table,..)
	2. DML(Insert,update,delete)
	3. DQL(select)
	4. DCL(alter password,grant access)
	5. TCL(commit,rollback,savepoint)

	According to java developer perspective, we categorise queries into 2 types
	a. Select Query
	b. NonSelect Query

	Methods for executing the Query are
	a. executeQuery() => for select query we use this method; returns ResultSet object
 	b. executeUpdate() => for insert,update and delete query we use this method; returns no. of rows affected
	c. execute() => for both select and non-select query we use this method

	public abstract ResultSet executeQuery(String sqlSelectQuery) throws SQLException;
	String sqlSelectQuery ="select sid,sname,sage,saddr from Student";
	ResultSet resultSet = statement.executeQuery(sqlSelectQuery);

	5. Process the result from ResultSet
	public abstract boolean next() throws java.sql.SQLException;
							|=> To check whether next Record is available or not
	returns true if available
	otherwise returns false.
	System.out.println("SID\tSNAME\tSAGE\tSADDR");
	while(resultSet.next()){
	Integer id = resultSet.getInt(1);
	String name = resultSet.getString(2);
	Integer age = resultSet.getInt(3);
	String team = resultSet.getString(4);
	System.out.println(id+"\t"+name+"\t"+age+"\t"+team);
	}

	6. Close the Connection

 */


public class C23JDBC {

    public static void main(String[] args) throws SQLException {


        /*
         * Driver driverObj = new Driver(); DriverManager.registerDriver(driverObj);
         * System.out.println("Driver instantiated successfully");
         */

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

			/*

			 The above line executes the same code as below:

			 Driver driverObj = new Driver();
			 DriverManager.registerDriver(driverObj);

			 but these lines are put in static block of Driver class.
			 so these lines are executed implicitly

			 */


            System.out.print("Driver LOADED and REGISTERED Successfully");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connectObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_schema","root","root");
        System.out.println();
        System.out.println(connectObj);
        System.out.println(connectObj.getClass().getName());//com.mysql.cj.jdbc.ConnectionImpl ***
        Statement statementObj = connectObj.createStatement();
        /*
        statementObj.execute("CREATE TABLE StudentTemp(studentid INT NOT NULL, studentname VARCHAR(100), PRIMARY KEY(studentid))");
        System.out.println("TABLE CREATED SUCCESSFULLY");
         */

        /*
        statementObj.executeUpdate("INSERT INTO StudentTemp(studentid,studentname) VALUES(506,'Kranthi')");
        System.out.println("Inserted Successfully");
         */

        ResultSet rs = statementObj.executeQuery("SELECT * FROM StudentTemp");
        System.out.println("studentid\tstudentname");
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            System.out.println("     "+id+"\t"+name);
        }
        statementObj.close();
        System.out.println("Statement closed successfully");
        connectObj.close();
        System.out.println("Connection closed successfully");

    }

}


/*

	 1. Load and register the Driver

	 In earlier version of JDBC 3.X we were loading and registering the driver using the following approach

	 Driver driver = new Driver();
	 DriverManager.registerDriver(driver);

	 Alternate to this we can also load the driver as shown below

	 Class.forName("com.mysql.cj.jdbc.Driver");

	 class Driver{
		 static{
			 Driver driver = new Driver();
			 DriverManager.registerDriver(driver);
		 }
	 }

	 Note: We say a class represents a Driver, iff the class has implemented an interface called "java.sql.Driver(I)".
	 MySQL       => Driver(c) implements Driver(I)
	 Oracle      => OracleDriver(c) implements Driver(I)
	 Postgresql  => PostgreSqlDriver(c) implements Driver(I)

	From JDBC4.X onwards loading and registering would happen automatically depending upon the jar added in the classpath
	 location of the project.

	 Note:
	 1. JVM will search for the jar in the classpath
	 2. It will open the jar,move to META-INF folder
	 3. It will open services folder
	 4. It will search for java.sql.Driver file
	 5. Whatever value which is present inside Driver file that would be loaded automatically using
	        Class.forName(value)

	 The above feature of JDBC4.X is called as "AutoLoading".


	 Formatting the String query to accept the dynamic inputs
	 --------------------------------------------------------
	 int sage = scanner.nextInt();
	 String sname = scanner.next();
	 String saddr = scanner.next();
	 sname = " ' " + sname + " ' ";
	 saddr  =  " ' " + saddr + " ' ";

	 In DB specific query
	   String =>  Varchar ===> ' '
	   int    =>  int     ===> direct values

	 String query = "insert into student(`sname`,`sage`,`saddr`) values ("  +sname+  ","  +sage+  ","  +saddr+  ")";

	 System.out.println(query);

	 To resolve the problem of the above approach we use a inbuilt class called "String".

	 int sage = scanner.nextInt();
	 String sname = scanner.next();
	 String saddr = scanner.next();
	 public static String format(String format, Object... args) {
	        return new Formatter().format(format, args).toString();
	 }

	 Note:
	 String use format specifier as '%s'
	 int	use format specifier as %d
	 flaot  use format specifier as %f

	 String query =String.format( "insert into student(`sname`,`sage`,`saddr`) values ('%s',%d,'%s')",sname,sage,saddr );

	 Through JDBC we have performed CRUD opeartion along with dynamic inputs from the user
	 Insert    =>  Create
	 Select    =>  Read
	 Update    =>  Update
	 Delete    =>  Delete


	 Assignment
	 ----------------------
	 Give the menu to the user as the operation listed below on student table
	 1. Create   2. Read    3. Update   4. Delete




*/
