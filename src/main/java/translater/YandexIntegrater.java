package translater;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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

    /** create a hashmap object and call the getProperties method from App Class*/
    Map<Integer, String> urls = PropertyRead.getProperties();

    /** URL to send the request to the API to obtain the language list*/
     final String postUrl = urls.get(4);


    public static void main(String[] args) throws Exception {

        YandexIntegrater y=new YandexIntegrater();

        //** for testing purpose of this class*//*
        String  ex2 = y.translateText("english", "arabic", "Hello");
        System.out.println(ex2);
        System.out.println("TRANS DONE");
    }


    /** function to get the language list */
    public  ArrayList<String> getLangs() throws Exception {

        org.apache.http.client.HttpClient httpClient = new DefaultHttpClient();
        HttpGet request = new HttpGet(postUrl);
        HttpResponse response = httpClient.execute(request);

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
        String transUrl=urls.get(5)+o_lan+"-"+t_lan+"&text="+text_input;

        /**send the request to the server thorough YandexIntegrater*/
        org.apache.http.client.HttpClient httpClient_translate = new DefaultHttpClient();
        HttpGet request = new HttpGet(transUrl);

        HttpResponse response2 = null;
        try {
            response2 = httpClient_translate.execute(request);
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