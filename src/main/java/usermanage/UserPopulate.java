package usermanage;



import c3p0.sample.DatabaseUtility;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;


public class UserPopulate {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(UserInteract.class);

    static Connection con = null;
    static Statement st = null;
    static ResultSet rs = null;


    /**create the logger object for logging */

    public static ArrayList populateUsers() throws SQLException, PropertyVetoException {

        /**create a new array list */
        ArrayList userList = new ArrayList();

        try {


            st = con.createStatement();
            rs = st.executeQuery("SELECT * , DATE_FORMAT(birth_date,'%m/%d/%Y') AS niceDate FROM user_data ORDER BY ID ASC;");

            ArrayList a1=null;
            int size=1;
            while(rs.next())
            {
                a1= new ArrayList();

                System.out.println(rs.getString("ID") + "," + rs.getString("user_name") + "," + rs.getString("f_name") +","+ rs.getString("l_name") + "," +rs.getString("niceDate")+ "," +rs.getString("country")+ "," +rs.getString("e_mail")+ "," +rs.getString("mobile"));//or getString(1) for coloumn 1 etc

                 System.out.printf("Size is: %s ", size);

               a1.add(rs.getString("ID"));
                a1.add(rs.getString("f_name"));
                a1.add(rs.getString("l_name"));
                a1.add(rs.getString("niceDate"));
                a1.add(rs.getString("country"));
                a1.add(rs.getString("e_mail"));
                a1.add(rs.getString("mobile"));
                a1.add(rs.getString("user_name"));

                size++;
                System.out.println("al :: " + a1);
                userList.add(a1);

            }


            System.out.println(size);

        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                LOG.error("Got an exception in populating users! : {}", ex.getMessage());
            }
        }
        return userList;
    }


    public static void main(String args[]){

        ArrayList ex1;

        try {
           ex1= populateUsers();
            LOG.info("Language list is: {}.", ex1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}
