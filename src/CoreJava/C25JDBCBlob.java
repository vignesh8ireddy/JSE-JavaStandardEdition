package CoreJava;

import java.io.*;
import java.sql.*;

/*

Working with Large Objects (BLOB And CLOB)
==========================================

Sometimes as the part of programming requirement, we have to insert and retrieve
large files like images, video files, audio files, resume etc w.r.t database.

To store and retrieve large information we should go for Large Objects(LOBs).
There are 2 types of Large Objects.
1. Binary Large Object (BLOB)
2. Character Large Object (CLOB)

1) Binary Large Object (BLOB)
A BLOB is a collection of binary data stored as a single entity in the database.
BLOB type objects can be images,video files,audio files etc..
BLOB datatype can store maximum of "4GB" binary data.

2) CLOB (Character Large Objects):
A CLOB is a collection of Character data stored as a single entity in the
database.
CLOB can be used to store large text documents(may plain text or xml documents)
CLOB Type can store maximum of 4GB data.

eg: resume.txt

Steps to insert BLOB type into database:

 1. create a table in the database which can accept BLOB type data.
        create table persons(name varchar2(10),image BLOB);
 2. Represent image file in the form of Java File object.
        File f = new File("brendan.jpg");
 3. Create FileInputStream to read binary data represented by image file
        FileInputStream fis = new FileInputStream(f)
 4. Create PreparedStatement with insert query.
 		PreparedStatement pst = con.prepareStatement("insert into persons
		values(?,?)");
 5. Set values to positional parameters.
 		pst.setString(1,"brendan");

 To set values to BLOB datatype, we can use the following method: setBinaryStream()
 public void setBinaryStream(int index,InputStream is)
 public void setBinaryStream(int index,InputStream is,int length)
 public void setBinaryStream(int index,InputStream is,long length)

 6. execute sql query
 		pst.executeUpdate();

Ensure the BLOB column can store large enough data:
In MySQL, there are different types of BLOBs, each capable of storing different sizes of data:

TINYBLOB: Up to 255 bytes
BLOB: Up to 65,535 bytes (64 KB)
MEDIUMBLOB: Up to 16,777,215 bytes (16 MB)
LONGBLOB: Up to 4,294,967,295 bytes (4 GB)
 */

public class C25JDBCBlob {
    public static void main(String[] args) throws SQLException{
        Connection con = null;
        Statement stObj = null;
        PreparedStatement pstObj = null;
        try {
            con = JDBCUtil.getJdbcConnection();
            System.out.println("CONNECTION ESTABLISHED SUCCESSFULLY");
            System.out.println("Conncetion Object: "+con);

            /*
            stObj = con.createStatement();
            stObj.execute("CREATE TABLE persontemp(empname VARCHAR(100), img LONGBLOB)");
            System.out.println("TABLE CREATED SUCCESSFULLY");
            */

            String query = "INSERT INTO persontemp VALUES(?, ?)";
            pstObj = con.prepareStatement(query);

            pstObj.setString(1, "brendan");

            File fObj = new File("brendan.jpg");
            FileInputStream fisObj = new FileInputStream(fObj);
            pstObj.setBlob(2, fisObj);

            int res = pstObj.executeUpdate();
            System.out.println("INSERTED SUCCESSFULLY.");

            /*
             Steps to Retrieve BLOB type from Database

             1. Prepare ResultSet object with BLOB type
                    ResultSet rs = st.executeQuery("select * from persontemp");
             2. Read Normal data from ResultSet
                    String name=rs.getString(1);
             3. Get InputStream to read binary data from ResultSet
                    InputStream is = rs.getBinaryStream(2);
             4. Prepare target resource to hold BLOB data by using FileOutputStream
                    FileOutputStream fos = new FOS("new_brendan.jpg");
             5. Read Binary Data from InputStream and write that Binary data to output Stream.
                    int i=is.read();
                    while(i!=-1){
                        fos.write(i);
                        is.read();
                    }
                        or

                    byte[] b= new byte[2048];
                    while(is.read(b) > 0){
                        fos.write(b);
                    }

             */


            pstObj = con.prepareStatement("SELECT * FROM persontemp");
            ResultSet rs = pstObj.executeQuery();
            while(rs.next()){
                String ename = rs.getString(1);
                InputStream isObj = rs.getBinaryStream(2);
                fObj = new File("new_brendan.png");
                FileOutputStream fosObj = new FileOutputStream(fObj);

                byte[] buffer = new byte[2048];
                while(isObj.read(buffer)!=-1){//read from isObj to buffer, if nothing has read returns -1
                    fosObj.write(buffer);//write to fosObj(i.e new_brendan.png) from buffer
                }

                // or alternatively you can use following style

                /* copying from inputstream to outputstream
                IOUtils.copy(is, fos);//this is java to file
                you need to download common io jar and set path for this
                */

                System.out.println(ename);
                System.out.println("File is saved to the location:: " + fObj.getAbsolutePath());
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        JDBCUtil.closeConnection(null,pstObj,con);
    }
}
