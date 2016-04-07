package translater;

import junit.framework.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;


/** test class to test the obtaining the language list from Yandex API */
public class YandexIntegraterTest {

    YandexIntegrater translateTest=new YandexIntegrater();
    String expected = "مرحبا";

    @Test
    public void translate_textTest()  {

        String olTest = "english";
        String tlTest = "arabic";
        String textTest = "Hello";

        String output1 = null;
        try {
            output1 =translateTest.translateText(olTest, tlTest, textTest);
        } catch (IOException e1) {
            //e.printStackTrace();
            Assert.fail("IO Exceptopn");
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(output1);

        Assert.assertEquals(expected, output1);

    }



}



