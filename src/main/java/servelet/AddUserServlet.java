package servelet;


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

import static usermanage.UserInteract.insertUser;


public class AddUserServlet  extends HttpServlet {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(AddUserServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        LOG.info("Obtain attribute name set from user add form");

        String f_name = request.getParameter("form-first-name");
        String l_name = request.getParameter("form-last-name");
        String date = request.getParameter("date");
        String country = request.getParameter("country");
        String email = request.getParameter("form-email");
        String mobile = request.getParameter("form-mobile");
        String u_name = request.getParameter("username");
        String pw = request.getParameter("password");

        LOG.info("Date read from form! : {}", date);
       /* LOG.info("Calling date Validation method");
        String date2=UserValidate.isValidDate(date);*/

        try {
            LOG.info("Calling dataValidation method");
//            boolean dateValid= UserValidate.isValidDate(date);


                LOG.info("Calling userInsert method");
                boolean success = UserInteract.insertUser(u_name, pw, f_name, l_name, date, country, email, mobile);

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
                        JOptionPane.ERROR_MESSAGE);

                RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
                rd.include(request, response);

        } catch (Exception e) {
            LOG.error("Got an exception! : {}", e.getMessage());
        }


    }


}
