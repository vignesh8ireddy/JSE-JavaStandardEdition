package JDBCStandaloneApplication.jutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    private JDBCUtil() {

    }

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException, IOException {
        FileInputStream fisObj = new FileInputStream("src\\JDBCStandaloneApplication\\properties\\db.properties");
        Properties properties = new Properties();
        properties.load(fisObj);

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Connection conObj = DriverManager.getConnection(url,user,password);
        return conObj;
    }

}
