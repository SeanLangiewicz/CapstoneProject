package DAO;

import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Class connects to MysQL Database on AWS. */
public class DBConnection {
    //JDBC URL PARTS
    private static final String protocal = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String hostName = "capstoneproject.csbokfylihwe.us-west-1.rds.amazonaws.com";
    private static final String disableSSL = "?useSSL=false";
    private static final String dbName = "HWOrderingDB";
//mysql




    //Driver and connect Interface reference
    private static final String mySQLJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;

    private static final String userName = "admin";
    private static final String password = "DRVdefSkfqnd";
    private static final String port = "3306";

    //JDBC URL
    private static final String jdbcURL =
            "jdbc:mysql://" + hostName + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;


    public static Connection getConnection()
    {
        try
        {
            Class.forName(mySQLJDBCDriver);


            conn = DriverManager.getConnection(jdbcURL);


        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

          catch (SQLException e)
        {
            System.out.println("SQL Exception " + e.getMessage());
        }



        return conn;
    }
    public static void closeConnection() throws SQLException {
        if(conn !=null)
        {
            conn.close();
            //System.out.println("DB Connection closed");
        }
    }
}

