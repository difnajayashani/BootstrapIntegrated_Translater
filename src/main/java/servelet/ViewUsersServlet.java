package servelet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import translater.YandexIntegrater;
import usermanage.UserPopulate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * servlet which provides the user list to the view
 */
public class ViewUsersServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(YandexIntegrater.class);


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


            ArrayList list;
        try {

            list= UserPopulate.populateUsers();
            //set the obtained array list of users
            request.setAttribute("language_list", list);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }


    }
}
