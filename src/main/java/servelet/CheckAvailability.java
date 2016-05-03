package servelet;

import c3p0.sample.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hsenid on 4/29/16.
 */
public class CheckAvailability extends HttpServlet {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(AddUserServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection connection=null;
        ResultSet rs=null;
        try {

            String uname = request.getParameter("username");

            /** connect to the database pool**/
            DatabaseUtility dbPool=(DatabaseUtility)getServletContext().getAttribute("DBManager");
           connection=dbPool.getConnection();


            PreparedStatement ps = connection.prepareStatement("select user_name from user_data where user_name=?");
            ps.setString(1,uname);
            rs = ps.executeQuery();

            if (!rs.next()) {
                out.println("<font color='green'><b>"+uname+"</b> is avaliable</font>");
            }
            else{
                out.println("<font color='red'><b>"+uname+"</b> is already in use</font>");
            }
            out.println();

        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("exception in creating the connection");
                }

            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    LOG.error("exception in the resultset");
                }

            }
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
