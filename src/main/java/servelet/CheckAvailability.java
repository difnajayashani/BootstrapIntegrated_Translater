package servelet;

import c3p0.sample.DatabaseUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by hsenid on 4/29/16.
 */
public class CheckAvailability extends HttpServlet {

    private static final long serialVersionUID = -734503860925086969L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String uname = request.getParameter("username");

            /** connect to the database pool**/
            DatabaseUtility dbPool=(DatabaseUtility)getServletContext().getAttribute("DBManager");
            Connection connection=dbPool.getConnection();


            PreparedStatement ps = connection.prepareStatement("select user_name from user_data where user_name=?");
            ps.setString(1,uname);
            ResultSet rs = ps.executeQuery();

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
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
