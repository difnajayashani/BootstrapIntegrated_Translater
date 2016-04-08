package property;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/** this class will read the system.properties file to obtain any value of a property*/
public class PropertyRead {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(PropertyRead.class);

    public static Map<Integer, String> result = null;

    /**method returns a hashmap containing the property values of the application*/
    public static Map<Integer,String> getProperties() {

        Properties prop = new Properties();
        InputStream input = null;


        try {

            String filename = "system.properties";

            /**read the property file and put it into a Input Stream */
            input = PropertyRead.class.getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                LOG.error("Sorry, unable to find : {} " , filename);

            }

            //load a system.properties file from class path, inside static method
            prop.load(input);

            //map each of the property value to a string variable
            String x = prop.getProperty("database.user");
            String y = prop.getProperty("database.pw");
            String z = prop.getProperty("database.url");

            String p = prop.getProperty("languagelist.url");
            String q = prop.getProperty("translate.url");
            String r = prop.getProperty("database.driver");



            /** create a hash map and put each loaded property with a unique key value*/
            result = new HashMap<Integer, String>();

            result.put(1, x);
            result.put(2, y);
            result.put(3, z);

            result.put(4, p);
            result.put(5, q);
            result.put(6, r);


            // The HashMap is currently empty.
            if (result.isEmpty()) {
                System.out.println("It is empty");
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /** return the hash map containing the property values*/
        return result;

    }



}
