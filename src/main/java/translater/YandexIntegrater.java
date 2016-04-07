package translater;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import property.PropertyRead;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;


public class YandexIntegrater {

    /**create the logger object for logging */
    private static final Logger log = LogManager.getLogger(YandexIntegrater.class);

    /** create a hashmap object and call the getProperties method from App Class*/
    Map<Integer, String> urls = PropertyRead.getProperties();

    /** URL to send the request to the API to obtain the language list*/
     final String postUrl = urls.get(4);



    public static void main(String... args)  {

        YandexIntegrater y=new YandexIntegrater();

        //** for testing purpose of this class*//*
        String  ex2 = null;
        ArrayList<String> ex1;
        try {
            log.info("Calling text translate function");
            ex2 = y.translateText("english", "arabic", "Hello");
            log.debug("Successfully executed the text translate method");
        } catch (IOException e) {
            log.error("IOException occurred ", e);
        } catch (ParserConfigurationException e) {
            log.error("ParserConfigurationException occurred ", e);
        } catch (SAXException e) {
            log.error("SAXException occurred ", e);
        } catch (URISyntaxException e) {
            log.error("URISyntaxException occurred ", e);
        }

        log.info("translated text is: {}.", ex2);

        try {
            ex1=y.getLangs();
            log.info("translated text is: {}.", ex1);
        } catch (Exception e) {
            log.error("Exception occurred in getting language list", e);
        }
    }


    /** function to get the language list */
    public  ArrayList<String> getLangs() throws Exception {

        org.apache.http.client.HttpClient httpClient = new DefaultHttpClient();

        /** send the request to the Yandex API */
        log.info("Sending API request to Yandex to get language list");
        HttpGet request = new HttpGet(postUrl);

        /** get the response*/
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity1= response.getEntity();
        if(entity1 == null)  {
            log.error("Response of getting language list is NUll");
        }

        /** Get the response */
        InputStream input = response.getEntity().getContent();


        /**creating DOM object to parse the XML returned in response*/
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();

        Document doc = builder.parse(input);

        /** get the elements in the Item TAG*/
        NodeList nameNodesList = doc.getElementsByTagName("Item");

        /**create a new array list */
        ArrayList<String> listValues = new ArrayList<String>();

        /** get the value of the attribute "value" in the Item TAG and put it in to the above created arraylist*/
        for (int i = 0; i < nameNodesList.getLength(); i++) {

            listValues.add(nameNodesList.item(i).getAttributes().getNamedItem("value").getNodeValue());

        }

        return listValues;

    }

    /** function to translate a input string to the given language
     * o_lan => language of the original string to be translated
     * t_lan => language for the string to be translated
     * text_input => input string
     * */

    public  String translateText(String o_lan, String t_lan, String text_input) throws IOException, ParserConfigurationException, SAXException, URISyntaxException {


        String output;
        /** URL sent to the API to get the string translated*/
        log.info("Sending API request to Yandex to get the language translated");
        String transUrl=urls.get(5)+o_lan+"-"+t_lan+"&text="+text_input;

        /**send the request to the server thorough YandexIntegrater*/
        org.apache.http.client.HttpClient httpClient_translate = new DefaultHttpClient();
        HttpGet request = new HttpGet(transUrl);

        HttpResponse response2 ;
        try {

            response2 = httpClient_translate.execute(request);
            HttpEntity entity2= response2.getEntity();
            if(entity2 == null){
                log.error("Response of translating a text is NUll");

            }
        } catch (IOException e1) {
            throw e1;
        }


        /**Get the response*/
        InputStream input2 = response2.getEntity().getContent();

        /**creating DOM object*/
        DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = null;
        try {
            builder2 = dbf2.newDocumentBuilder();
        } catch (ParserConfigurationException e2) {
            throw e2;
        }
        Document doc = null;
        try {
            doc = builder2.parse(input2);
        } catch (SAXException e3) {
            throw e3;
        }

        NodeList textTag = doc.getElementsByTagName("text");

        /** get the string value of the content in the text TAG*/
        output = String.valueOf(textTag.item(0).getTextContent());



        return output;
    }

}