/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pos_project.classes;

/**
 * SQLConnection Class
 * Gets the Connection from the Database
 * @author Queenie
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;

public class SQLConnection {
    /**
     * Gets Database Connection
     * @return connection
     */
    private static Connection currConnection = getSQLConnectionNow();

    public static Connection getSQLConnectionNow(){
        Connection connection = null;
        Properties prop = new Properties();
        String dbHostAddress = "";
        String dbNameProperty = "";
        System.out.println("SQL CONNECTION!");

    	try {
               //load a properties file
    		prop.load(new FileInputStream("pos_config.properties"));
                dbHostAddress = prop.getProperty("dbHostAddress");
                dbNameProperty = prop.getProperty("dbName");

    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
          String url = "jdbc:mysql://"+dbHostAddress+"/";
          String dbName = dbNameProperty;
          String driver = "com.mysql.jdbc.Driver";
          String userName = "root";
//          String password = "root";
          String password = "";
        try {
            
         Class.forName(driver).newInstance();
         connection = DriverManager.getConnection(url+dbName,userName,password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    
//    public static Connection getSQLConnection() {
//        //Mimimum acceptable free memory you think your app needs
//        long minRunningMemory = (1024*1024);
//        Runtime runtime = Runtime.getRuntime();
//        if(runtime.freeMemory()<minRunningMemory)
//        {
//            System.gc();
//            currConnection = getSQLConnectionNow();
//        }
//
//        if(currConnection == null){
//            currConnection = getSQLConnectionNow();
//        }
//        
//        return currConnection;
//    }
    
    public static Connection getSQLConnection() {
        //Mimimum acceptable free memory you think your app needs
        currConnection = getSQLConnectionNow();
       
        return currConnection;
    }
}
