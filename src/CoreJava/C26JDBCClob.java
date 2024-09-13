package CoreJava;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.*;

public class C26JDBCClob {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement stObj = null;
        PreparedStatement pstObj = null;
        try {
            con = JDBCUtil.getJdbcConnection();
            System.out.println("CONNECTION ESTABLISHED SUCCESSFULLY");
            System.out.println("Conncetion Object: "+con);

            /*
            stObj = con.createStatement();
            stObj.execute("CREATE TABLE bdatatemp(pname VARCHAR(100), pdoc LONGTEXT)");
            System.out.println("TABLE CREATED SUCCESSFULLY");
*/

            String query = "INSERT INTO bdatatemp VALUES(?, ?)";
            pstObj = con.prepareStatement(query);

            pstObj.setString(1, "kyle");

            File fObj = new File("kyle.txt");
            FileReader frObj = new FileReader(fObj);
            pstObj.setCharacterStream(2, frObj);

            int res = pstObj.executeUpdate();
            System.out.println("INSERTED SUCCESSFULLY.");

            pstObj = con.prepareStatement("SELECT * FROM bdatatemp");
            ResultSet rs = pstObj.executeQuery();
            while(rs.next()){
                String ename = rs.getString(1);
                Reader rObj = rs.getCharacterStream(2);
                fObj = new File("new_kyle.txt");
                FileWriter fwObj = new FileWriter(fObj);

                // copying from inputstream to outputstream
                IOUtils.copy(rObj, fwObj);
                //you need to download common io jar and set path for this
                fwObj.flush();

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