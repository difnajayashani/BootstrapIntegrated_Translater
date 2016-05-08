package servelet;

import c3p0.sample.DatabaseUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.JsonArray;
import javax.json.JsonObject;
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
 * Created by ASUS on 2016-05-09.
 */
public class LoadCityServlet extends HttpServlet {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(AddUserServlet.class);



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOG.info("Inside the Load city Servlet");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String countryId = request.getParameter("country");

        String sql = "select city_name from city_table where country_name=\'" + countryId + "\';";


        LOG.info("JSON array initialized");

        JSONArray cityList=new JSONArray();


        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;


        try {

            /** connect to the database pool**/
            DatabaseUtility dbPool = (DatabaseUtility) getServletContext().getAttribute("DBManager");
            con = dbPool.getConnection();
            LOG.info("Database connection obtained for loading city");


            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                /**create a JSON objecty */
                JSONObject jsonObj = new JSONObject();
                jsonObj.append("cityName", rs.getString("city_name"));
                 cityList.put(jsonObj);
            }

            out.println(cityList);

        } catch (SQLException e) {
           LOG.error("Error in loading the city list");
        }finally{
            if(con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                   LOG.error("Exception in closing the city loading connection");
                }

            if(rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    LOG.error("Exception in closing the city loading resultset");
                }
            if(st!= null)
                try {
                    st.close();
                } catch (SQLException e) {
                    LOG.error("Exception in closing the city loading statement");
                }

        }


    }


}
