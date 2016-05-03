package servelet;

import c3p0.sample.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import usermanage.UserPopulate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.SQLException;



/**
 * Created by hsenid on 5/2/16.
 */
public class SearchUserServlet extends HttpServlet {

    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(AddUserServlet.class);

    UserPopulate u1=new UserPopulate();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        Connection connection=null;
        LOG.info("JSON object initialized");
        JSONArray allUsers=new JSONArray();


        String userSearched = request.getParameter("user-search-name");

        try {

            /** connect to the database pool**/
            DatabaseUtility dbPool = (DatabaseUtility) getServletContext().getAttribute("DBManager");
            connection = dbPool.getConnection();
            LOG.info("Database connection obtained for user search");

            LOG.trace("method to poplulate the user_list is called");
            allUsers= u1.populateUsers(userSearched,connection);
            out.print(allUsers);

            LOG.info("Set the obtained list of users as a JSON array");
            /** set the attribute values**/
            request.setAttribute("users_list",allUsers);





        } catch (SQLException e) {
            LOG.error("SQLException in searching user");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } finally{

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("exception in creating the user search connection");
                }
            }



        }

    }


}
