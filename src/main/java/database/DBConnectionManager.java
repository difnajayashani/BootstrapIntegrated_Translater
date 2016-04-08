package database;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import property.PropertyRead;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/** class to make the connection with the database*/
public class DBConnectionManager {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(DBConnectionManager.class);

    public static Connection con;

    /** create a hashmap object and call the getProperties method from App Class*/
    Map<Integer, String> driver = PropertyRead.getProperties();

    //constructor
    public DBConnectionManager(String url, String u, String ps_wd) {

        try {

            Class.forName(driver.get(6));
            LOG.info("Going to obtain a database Connection obiect");
            LOG.warn("SQL Exception can occure");

            con = DriverManager.getConnection(url, u, ps_wd);

        } catch (SQLException e) {
            LOG.error("SQL Exception occured");
        } catch (ClassNotFoundException e) {
            LOG.error("Class NOt Found Exception occured");        }

    }

    /** method to return the database connection*/
    public static Connection getConnection() {

        LOG.info("return Database connection");
        return con;
    }

    /**method to close the connection */
    public void closeConnection() {
        //close DB connection here

        try {
            con.close();
            LOG.info("Database connection closed");

        } catch (SQLException e) {
            LOG.error("Exception in Database Connection ");
        }

    }

}
