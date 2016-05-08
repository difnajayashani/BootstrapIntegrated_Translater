package servelet;

import c3p0.sample.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by ASUS on 2016-05-08.
 */
public class SearchUserServlet extends HttpServlet {

    /**
     * create the logger object for logging
     */
    private static final Logger LOG = LogManager.getLogger(UpdateUserServlet.class);


    /**
     * @param request  servlet instance we create to transport data to the servlet
     * @param response servlet instance we use to obtain data from the servlet
     * @throws ServletException
     * @throws IOException      *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        String userSearched = request.getParameter("snamef");
        LOG.trace("searched user name is set", userSearched);

        /**create a JSON array */
        JSONArray userList = new JSONArray();
        LOG.info("JSON object initialized");


        try {

            /** connect to the database pool**/
            DatabaseUtility dbPool = (DatabaseUtility) getServletContext().getAttribute("DBManager");
            connection = dbPool.getConnection();
            LOG.info("Database connection obtained for user Search");

            st = connection.createStatement();
            String sql ="SELECT * , DATE_FORMAT(birth_date,'%m/%d/%Y') AS niceDate FROM user_data WHERE user_name REGEXP '^[\"" +userSearched + "\"].*$' ;";
            rs = st.executeQuery(sql);

            //rs = st.executeQuery("SELECT * , DATE_FORMAT(birth_date,'%m/%d/%Y') AS niceDate FROM user_data WHERE user_name = \"" + userSearched + "\" ;");
            LOG.trace("Query to search user executed ");


            LOG.trace("Loop through the resultset ");
            int size = 1;
            while (rs.next()) {

                /**create a JSON objecty */
                JSONObject a1 = new JSONObject();

                //System.out.println(rs.getString("ID") + "," + rs.getString("user_name") + "," + rs.getString("f_name") + "," + rs.getString("l_name") + "," + rs.getString("niceDate") + "," + rs.getString("country") + "," + rs.getString("e_mail") + "," + rs.getString("mobile"));//or getString(1) for coloumn 1 etc

                LOG.info("Size of loop is:", size);

                a1.append("id", rs.getString("ID"));
                a1.append("user_name", rs.getString("user_name"));
                a1.append("f_name", rs.getString("f_name"));
                a1.append("l_name", rs.getString("l_name"));
                a1.append("niceDate", rs.getString("niceDate"));
                a1.append("country", rs.getString("country"));
                a1.append("city_id", rs.getString("city_id"));
                a1.append("e_mail", rs.getString("e_mail"));
                a1.append("mobile", rs.getString("mobile"));


                size++;
                //System.out.println("al :: " + a1);
                userList.put(a1);

            }




        } catch (SQLException e) {
            LOG.error("SQL Exception error in searching a user");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                LOG.error("SQL Error in closing the connections, statements in user Search");
            }


        }
        LOG.info("Search user output given:", userList);
        out.print(userList);
    }
}
