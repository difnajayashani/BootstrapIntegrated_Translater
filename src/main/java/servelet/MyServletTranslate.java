package servelet;

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
                e.printStackTrace();
            }


            ArrayList<String> list = new ArrayList<String>();
            try {
                list = getReply.getLangs();
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("language_list", list);


            request.setAttribute("selected_ol", ol);
            request.setAttribute("selected_tl", tl);
            request.setAttribute("original", textInput);
            request.setAttribute("translated", textOutput);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/translater.jsp");
            rd.forward(request, response);





    }
}


