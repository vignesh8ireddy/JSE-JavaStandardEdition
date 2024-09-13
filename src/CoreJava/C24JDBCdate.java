package CoreJava;

import java.sql.*;

public class C24JDBCdate {

    /*
    Handling Date Values For Database Operations
    --------------------------------------------
    > Sometimes as the part of programing requirement, we have to insert and retrieve Date like
    DOB,DOJ,DOM,DOP...wrt database.
    > It is not recommended to maintain date values in the form of String, b'z comparisons will become difficult.

    In Java we have two Date classes
     1. java.util.Date
     2. java.sql.Date
    > java.sql.Date is the child class of java.util.Date.
    > java.sql.Date is specially designed class for handling Date values w.r.t database.
    Other than database operations, if we want to represent Date in our java program
    then we should go for java.util.Date.
    > java.util.Date can represent both Date and Time where as java.sql.Date
    represents only Date but not time.

    java.util.Date udate = new java.util.Date();
    System.out.println("util Date:"+udate);
    long l=udate.getTime();//current time in millisecs since Jan 1, 1970, 00:00:00 GMT (also known as the Unix timestamp).
    java.sql.Date sdate= new java.sql.Date(l);
    System.out.println("sql Date:"+sdate);
    -------------------------------------------
    util Date:Mon Mar 20 19:07:29 IST 2017
    sql Date:2017-03-20

    Differences between java.util.Date and java.sql.Date
    java.util.Date
     1) It is general Utility Class to handle Dates in our Java Program.
     2) It represents both Data and Time.
    java.sql.Date
     1) It is specially designed Class to handle Dates w.r.t DB Operations.
     2) It represents only Date but not Time.

    Note:
    > In sql package Time class is available to represent Time values
    > In sql package TimeStamp class is available to represent both Date and Time.

    Inserting Date Values into Database:
    Various databases follow various styles to represent Date.
    Eg:
    Oracle: dd-mm-yyyy  eg: 28-May-90
    MySQL : yyyy-mm-dd eg: 1990-05-28
    java.sql.Date : information is stored as "yyyy-mm-dd"
    > If we use simple Statement object to insert Date values then we should provide
    Date value in the database supported format, which is difficult to the programmer.
    > If we use PreparedStatement, then we are not required to worry about database
    supported form, just we have to call pst.setDate (2, java.sql.Date);
    This method internally converts date value into the database supported format.
    Hence, it is highly recommended to use PreparedStatement to insert Date values into
    database.

    Steps to insert Date value into Database:
     > DB: create table users(name varchar2(10),dop date);
     1. Read Date from the end user(in String form)
     System.out.println("Enter DOP(dd-mm-yyyy):");
    String dop=sc.next();
     2. Convert date from String form to java.util.Date form by using SimpleDateFormat
    object.
    SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
    java.util.Date udate=sdf.parse(dop);
     3. convert date from java.util.Date to java.sql.Date
    long l = udate.getTime();
    java.sql.Date sdate=new java.sql.Date(l);
     4. set sdate to query
           pst.setDate(2,sdate);
     5. int rowAffected= pst.executeUpdate();//Execute the query.

    UserInput => SimpleDateFormat====> java.util.Date => java.sql.Date => ps.setDate(1,date) =>DB
          |-> parse()

    Program To Demonstrate Inserting Date Values Into Database:
    DB: create table users(name varchar2(10),dop date);

    Note: If end user provides Date in the form of "yyyy-MM-dd" then we can convert directly
    that String into java.sql.Date form as follows...
    eg:
    String s = "1980-05-27";
    java.sql.Date sdate=java.sql.Date.valueOf(s);

    Assignment1:
    perform insertion operation and also perform retrieval operation on the following data
    name    =>
    address=>
    gender  =>
    DOB      => dd-MM-yyyy
    DOJ       => MM-dd-yyyy
    DOM    => yyyy-MM-dd


    Retrieving Date value from the database
     ---------------------------------------
> For this we can use either simple Statement or PreparedStatement.
> The retrieved Date values are Stored in ResultSet in the form of "java.sql.Date"
  and we can get this value by using getDate() method.
> Once we got java.sql.Date object,we can format into our required form by using
  SimpleDateFormat object.

    Sequence
     --------
     1. Database
            (java.sql.Date)sqldate = rs.getDate(2);
     2. Our required String Form
            String s = sdf.format(sqldate);
     3. String s holds the date.

     */

    public static void main(String args[]) throws SQLException {
        Connection con = null;
        //Statement stObj = null;
        PreparedStatement pstObj = null;
        try {
            con = JDBCUtil.getJdbcConnection();
            System.out.println("CONNECTION ESTABLISHED SUCCESSFULLY");
            System.out.println("Conncetion Object: "+con);
            /*
            stObj = con.createStatement();
            stObj.execute("CREATE TABLE employeetemp(empid INT NOT NULL, empname VARCHAR(100), dob DATE, PRIMARY KEY(empid))");
            System.out.println("TABLE CREATED SUCCESSFULLY");
            */

            /*
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
            String query = "INSERT INTO employeetemp VALUES(?, ?, ?)";
            pstObj = con.prepareStatement(query);
            pstObj.setInt(1,504);
            pstObj.setString(2, "Kyle Simpsons");
            pstObj.setDate(3, date);
            int res = pstObj.executeUpdate();
            System.out.println("INSERTED SUCCESSFULLY.");
             */

            String query = "SELECT * FROM employeetemp";
            pstObj = con.prepareStatement(query);
            ResultSet rs = pstObj.executeQuery();
            while(rs.next()){
                int eid = rs.getInt(1);
                String ename = rs.getString(2);
                java.sql.Date edob = rs.getDate(3);
                System.out.println(eid+"\t"+ename+"\t"+edob);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

        JDBCUtil.closeConnection(null,pstObj,con);
    }


}
