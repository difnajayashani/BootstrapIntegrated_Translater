package translater;

import junit.framework.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;



public class HttpClientClassTest {

    String expected = "مرحبا";

    @Test
    public void translate_textTest()  {

        String o_test = "english";
        String t_test = "arabic";
        String text_test = "Hello";

        String output1 = null;
        try {
            output1 = HttpClientClass.translate_text(o_test, t_test, text_test);
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



