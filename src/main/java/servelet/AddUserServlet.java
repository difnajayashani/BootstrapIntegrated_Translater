package servelet;


import c3p0.sample.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import usermanage.UserInteract;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class AddUserServlet  extends HttpServlet {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(AddUserServlet.class);


    /**
     * @param request servlet instance we create to transport data to the servlet
     * @param response servlet instance we use to obtain data from the servlet
     * @throws ServletException
     * @throws IOException
     *
     * **/
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        LOG.info("Obtain attribute name set from user add form");

        String f_name = request.getParameter("form-first-name");
        String l_name = request.getParameter("form-last-name");
        String date = request.getParameter("date");
        String country = request.getParameter("country");
        String city = request.getParameter("form-city");
        String email = request.getParameter("form-email");
        String mobile = request.getParameter("form-mobile");
        String u_name = request.getParameter("username");
        String pw = request.getParameter("password");



        /**set the logged in user's name */
        request.setAttribute("f_name", f_name);
        request.setAttribute(" l_name",  l_name);
        request.setAttribute("date", date);
        request.setAttribute("country", country);
        request.setAttribute("city", city);
        request.setAttribute("email", email);
        request.setAttribute("mobile", mobile);
        request.setAttribute("u_name",u_name);
        request.setAttribute("pw", pw);
        LOG.info("Date read from form! : {}", date);

        /** connect to the database pool**/
        DatabaseUtility dbPool=(DatabaseUtility)getServletContext().getAttribute("DBManager");

        try {
            LOG.info("Calling dataValidation method");
//            boolean dateValid= UserValidate.isValidDate(date);


                LOG.info("Calling userInsert method");
                boolean success = UserInteract.insertUser(dbPool.getConnection(),u_name, pw, f_name, l_name,
                        date, country,city, email, mobile);

                if (success) {
                    LOG.info("The user is inserted successfully");

                    RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
                    rd.forward(request, response);
                }
                else{
                    LOG.error("Error in inserting the user to database successfully");
                    //give user sign up success message
                }



       /*     else{
                LOG.warn("User is not valid");
                // error pop up message for invalid user credentials
*/
                JOptionPane.showMessageDialog(new JFrame()," Successfully added a user", "Congrates !",
                        JOptionPane.INFORMATION_MESSAGE);

            /** reloadd the same page **/
            request.getRequestDispatcher("navbar.jsp").forward(request, response);;

        } catch (Exception e) {
            LOG.error("Got an exception! : {}", e.getMessage());
        }


    }


}
