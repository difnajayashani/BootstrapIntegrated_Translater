package database;


import property.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/** class to make the connection with the database*/
public class DBConnectionManager {


    public static Connection con;

    /** create a hashmap object and call the getProperties method from App Class*/
    Map<Integer, String> driver = App.getProperties();

    //constructor
    public DBConnectionManager(String url, String u, String ps_wd) {

        try {
            Class.forName(driver.get(5));


            con = DriverManager.getConnection(url, u, ps_wd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /** method to return the database connection*/
    public static Connection getConnection() {

        return con;
    }

    /**method to close the connection */
    public void closeConnection() {
        //close DB connection here

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
