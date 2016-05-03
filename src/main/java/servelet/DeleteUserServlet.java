package servelet;

import c3p0.sample.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import usermanage.UserInteract;

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
 * Created by hsenid on 5/3/16.
 */
public class DeleteUserServlet  extends HttpServlet {


    /**
     * create the logger object for logging
     */
    private static final Logger LOG = LogManager.getLogger(AddUserServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String deleteID= request.getParameter("user-search-name");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection connection=null;



        try {

            LOG.info("Database connection obtained for user deletion");
            /** connect to the database pool**/
            DatabaseUtility dbPool = (DatabaseUtility) getServletContext().getAttribute("DBManager");
            connection = dbPool.getConnection();

            LOG.trace("method to poplulate the user_list is called");
           UserInteract.deletetUser(connection,deleteID);


        } catch (SQLException e) {
            LOG.error("SQLException in searching user");
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}
