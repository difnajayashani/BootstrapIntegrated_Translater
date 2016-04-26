package servelet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import translater.YandexIntegrater;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;

/**
 * servelet which recieves the data entered to the rtanslater form
 */
public class MyServletTranslate extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(YandexIntegrater.class);

    YandexIntegrater getReply = new YandexIntegrater();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{


        YandexIntegrater translate=new YandexIntegrater();
        String textOutput=null;



            // get the parameters entered in translater.jsp form and send it to the language translate function
            String ol = request.getParameter("original-lang");
            String tl = request.getParameter("translate-lang");
            String textInput = request.getParameter("original-text");
            request.setAttribute("original", textInput);


            //call the language translate function and catch the translated text
            try {
                textOutput = translate.translateText(ol, tl, textInput);
            } catch (Exception e) {
                LOG.fatal("Exception occurred in translateText method");
            }


            ArrayList<String> list = new ArrayList<String>();
            try {
                list = getReply.getLangs();
            } catch (Exception e) {
                LOG.error("Exception occurred in obtaining language list method");
            }
            request.setAttribute("language_list", list);


            request.setAttribute("selected_ol", ol);
            request.setAttribute("selected_tl", tl);
            request.setAttribute("original", textInput);
            request.setAttribute("translated", textOutput);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
            rd.forward(request, response);





    }
}


