package usermanage;

import c3p0.sample.DatabaseUtility;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class involves methods to interact with the user
 *           Inserting a new user to the database
 *           Deleting an existant user from the database
 */
public class UserInteract {

    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(UserInteract.class);

    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    private static Connection connection= null;


    /** The method will enter the user to the database table after validating **/

    public static boolean insertUser(String a,String b,String c,String d,String f,String g,String h,String i)throws Exception{

        LOG.info("Inside the userInsert method");



        try {
            LOG.info("Calling the database connection object");
            ComboPooledDataSource dataSource = DatabaseUtility.getDataSource();
            connection = dataSource.getConnection();

            String insertQuery ="INSERT INTO user_data (`user_name`,`password`,`f_name` ,`l_name`,`birth_date`,`country` ,`e_mail`)" +" VALUES (\"" + a + "\",\"" + b + "\", \"" +c + "\",\"" + d + "\", \"" + f + "\",\"" + g  + "\",\"" +h + "\" )";

            if(connection != null) {
                LOG.debug("Connection not null");


                /** create a statement*/
                stmt = connection.prepareStatement(insertQuery);
                // insert the data
                stmt.executeUpdate();

                return true;

            }else
                LOG.error("Connection NULL");


        } catch (PropertyVetoException e) {
            LOG.error("Got an exception! : {}", e.getMessage());

        }finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return false;
    }


    /** The method will delete the user from the database table after confirming it exists**/

    public static boolean deletetUser(String userExist) throws Exception{

        //search in database if the user exists

        String deleteQuery ="DELETE  FROM user_data" + " WHERE  user_name = \"" + userExist+ "\" ";

        try {
            stmt=connection.prepareStatement(deleteQuery);

            //execute the statement
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null) {
                stmt.close();
            }

        }


     return true;
    }
}
