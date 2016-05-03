package usermanage;



import c3p0.sample.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


import javax.json.JsonObject;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;


public class UserPopulate {


    /**
     * create the logger object for logging
     */
    private static final Logger LOG = LogManager.getLogger(UserInteract.class);



    public JSONArray populateUsers(String user, Connection con) throws SQLException, PropertyVetoException {

        /**create a JSON array */
        JSONArray userList = new JSONArray();




        Statement st = null;
        ResultSet rs = null;

        LOG.trace("Inside the populate users method");

        try {


            st = con.createStatement();
           // rs = st.executeQuery("SELECT * , DATE_FORMAT(birth_date,'%m/%d/%Y') AS niceDate FROM user_data WHERE f_name= \"" + user + "\"  ORDER BY ID ASC;");

            rs = st.executeQuery("SELECT * , DATE_FORMAT(birth_date,'%m/%d/%Y') AS niceDate FROM user_data  ORDER BY ID ASC;");
            LOG.trace("Query to search user executed ");


            LOG.trace("Loop through the resultset ");
            int size = 1;
            while (rs.next()) {

                /**create a JSON objecty */
                JSONObject a1= new JSONObject();

                //System.out.println(rs.getString("ID") + "," + rs.getString("user_name") + "," + rs.getString("f_name") + "," + rs.getString("l_name") + "," + rs.getString("niceDate") + "," + rs.getString("country") + "," + rs.getString("e_mail") + "," + rs.getString("mobile"));//or getString(1) for coloumn 1 etc

                LOG.info("Size of loop is:", size);

                a1.append("ID", rs.getString("ID"));
                a1.append("user_name",rs.getString("user_name"));
                a1.append("f_name",rs.getString("f_name"));
                a1.append("l_name",rs.getString("l_name"));
                a1.append("niceDate",rs.getString("niceDate"));
                a1.append("country",rs.getString("country"));
                a1.append("city_id",rs.getString("city_id"));
                a1.append("e_mail",rs.getString("e_mail"));
                a1.append("mobile",rs.getString("mobile"));


                size++;
                System.out.println("al :: " + a1);
                userList.put(a1);

            }


            System.out.println(size);

        } finally {
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


    public static void main(String args[]) throws SQLException {

        JSONArray ex1;
        DatabaseUtility d = new DatabaseUtility();
        UserPopulate u = new UserPopulate();
        Connection con = null;

        try {
            con = d.getConnection();

            ex1 = u.populateUsers("Difna", con);
            LOG.info("Language list is: {}.", ex1);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }finally{

            if (con != null) {
                con.close();
            }
        }
    }
}
