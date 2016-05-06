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
import java.sql.SQLException;

public class UpdateUserServlet extends HttpServlet {


    /**
     * create the logger object for logging
     */
    private static final Logger LOG = LogManager.getLogger(UpdateUserServlet.class);



    /**
     * @param request  servlet instance we create to transport data to the servlet
     * @param response servlet instance we use to obtain data from the servlet
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException            *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection connection=null;
        PreparedStatement stmt = null;

        LOG.info("Obtain attribute name set from user add form");

        String uu_name = request.getParameter("uu_name");

        String uf_name = request.getParameter("uf_name");
        String ul_name = request.getParameter("ul_name");
        String udate = request.getParameter("udate");
        String ucountry = request.getParameter("ucountry");
        String ucity = request.getParameter("ucity");
        String uemail = request.getParameter("uemail");
        String umobile = request.getParameter("umobile");
        String upw = request.getParameter("upw");


        LOG.info("Date read from form! : {}", udate);

        /** connect to the database pool**/
        DatabaseUtility dbPool = (DatabaseUtility) getServletContext().getAttribute("DBManager");


        try {
            String insertQuery = "UPDATE user_data SET  password = \"" + upw + "\",f_name =\"" + uf_name + "\" ,l_name =\"" + ul_name + "\",birth_date =STR_TO_DATE(\"" + udate + "\",'%m/%d/%Y'),country = \"" + ucountry + "\" ,city_id = \"" + ucity + "\" ,e_mail= \"" + uemail + "\",mobile = \"" + umobile + "\" WHERE user_name= \"" + uu_name + "\"";

            connection = dbPool.getConnection();
            if (connection != null) {
                LOG.info("Connection not null");


                /** create a statement*/
                stmt = connection.prepareStatement(insertQuery);
                LOG.trace("Statement created");

                // insert the data
                LOG.trace("Queary executed 1");
                int updateSuccess= stmt.executeUpdate();
                LOG.trace("Queary executed 2");

                if (updateSuccess ==1) {
                    LOG.info("Output the user update result");
                    out.println(1);
                }
                else
                    out.println(0);





            }


        } catch (SQLException e) {
            LOG.error("exception in user update");
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("exception in creating the connection");
                }

            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    LOG.error("exception in the resultset");
                }

            }

        }

    }
}