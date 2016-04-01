package listener;

import property.App;


import database.DBConnectionManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;


public class AppContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent servletContextEvent) {

        /** create a hashmap object and call the getProperties method from App Class*/
        Map<Integer, String> main =App.getProperties();

        /**take each element of the hash map to variables by their keyvalues */
        String u= main.get(1);
        String p= main.get(2);
        String url= main.get(3);


        ServletContext ctx = servletContextEvent.getServletContext();


        //create database connection from init parameters and set it to context
        DBConnectionManager dbManager = new DBConnectionManager(url, u, p);
        ctx.setAttribute("DBManager", dbManager);

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("DBManager");
        dbManager.closeConnection();


    }

}
