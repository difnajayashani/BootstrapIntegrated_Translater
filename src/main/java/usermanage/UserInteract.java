package usermanage;

import c3p0.sample.DatabaseUtility;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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


    /** The method will enter the user to the database table after validating **/

    public static boolean insertUser(Connection connection,String a,String b,String c,String d,String f,String g,String h,String i,String j)throws Exception{

        LOG.info("Inside the userInsert method");
        LOG.info("value of i1 : {}",i);


        try {

            String insertQuery ="INSERT INTO user_data (`user_name`,`password`,`f_name` ,`l_name`,`birth_date`,`country` ,`city_id` ,`e_mail`,`mobile`)" +" VALUES (\"" + a + "\",MD5(\"" + b + "\"), \"" +c + "\",\"" + d + "\", STR_TO_DATE(\"" + f + "\",'%m/%d/%Y'),\"" + g  + "\",\"" +h + "\" ,\"" +i + "\",\""+ j+ "\")";

            if(connection != null) {
                LOG.debug("Connection not null");


                /** create a statement*/
                stmt = connection.prepareStatement(insertQuery);
                // insert the data
                stmt.executeUpdate();

                return true;

            }else
                LOG.error("Connection NULL");


        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return false;
    }


    /**
     *  The method will update the user from the database table*
     *  */

    public static boolean updateUser(Connection connection,String a,String b,String c,String d,String f,String g,String h,String i,String j)throws Exception{

        LOG.info("Inside the userUpdate method");
        LOG.info("value of i1 : {}",i);


        try {

            String insertQuery ="UPDATE user_data SET  password = \"" +b + "\",f_name =\"" +c + "\" ,l_name =\"" + d + "\",birth_date =STR_TO_DATE(\"" + f + "\",'%m/%d/%Y'),country = \"" + g+ "\" ,city_id = \"" +h+ "\" ,e_mail= \"" +i+ "\",mobile = \"" +j+ "\" WHERE user_name= \"" +a+ "\"";
            if(connection != null) {
                LOG.debug("Connection not null");


                /** create a statement*/
                stmt = connection.prepareStatement(insertQuery);
                LOG.debug("Statement created");
                // insert the data
                stmt.executeUpdate();
                LOG.debug("Queary executed");

                return true;

            }else
                LOG.error("Connection NULL");


        } finally {
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

    public static int deletetUser(Connection con,String userExist) throws Exception{

        //search in database if the user exists

        String deleteQuery ="DELETE FROM user_data WHERE user_name=\"" + userExist+ "\";";

        try {
            stmt=con.prepareStatement(deleteQuery);

            //execute the statement

            return stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null) {
                stmt.close();
            }if(con!= null){
                con.close();

            }

        }


       return 0;
    }


/* public static void main(String args[]) throws SQLException {


     DatabaseUtility dbPool = new DatabaseUtility();
     Connection con = null;
     try {
         con = dbPool.getConnection();
     } catch (SQLException e) {
         e.printStackTrace();
     }
     try {

         int test=UserInteract.deletetUser(con,"nayana");
         System.out.print(test);

     } catch (SQLException e) {
         e.printStackTrace();
     } catch (Exception e) {
         e.printStackTrace();
     }finally{
         assert con != null;
         con.close();
     }


 }*/
}


/** method to edit the user details**/