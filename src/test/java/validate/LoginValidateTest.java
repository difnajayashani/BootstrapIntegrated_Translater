package validate;

import database.DBConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import org.testng.Assert;
import property.PropertyRead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import static org.testng.Assert.fail;

/**test class to test the user authentication  */
public class LoginValidateTest {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(LoginValidateTest.class);

    DBConnectionManager dbManager;
    Connection conn =null;

    /**  run only once before all tests in this suite have run.*/
    @BeforeSuite
    public void connectDatatbase() {


        /** create a hashmap object and call the getProperties method from App Class*/
        Map<Integer, String> databaseConnect = PropertyRead.getProperties();

        /**take each element of the hash map to variables by their keyvalues */
        String un= databaseConnect.get(1);
        String pw= databaseConnect.get(2);
        String url= databaseConnect.get(3);

        dbManager = new DBConnectionManager(url,un,pw);

    }

    /** run only once before the first test method in the current class is invoked.*/
    @BeforeClass
    public void insertUser() throws SQLException {

        PreparedStatement statement1 = null;
        String insertQuery ="INSERT INTO user_data (`user_name`, `password`, `f_name`)" +" VALUES ('right', MD5('right'), 'Right')";
        try {
            conn = dbManager.getConnection();
            // create a Statement from the connection

            statement1=conn.prepareStatement(insertQuery);
            // insert the data
            statement1.executeUpdate();
            // INSERT INTO `user_data` (`user_name`, `password`, `f_name`) VALUES ('new', MD5('new'), 'New');
            LOG.info("in beforeClass");


        } catch (Exception e)
        {
            LOG.error("Got an exception! : {}", e.getMessage());

        }finally{
            if(statement1 != null) {
                statement1.close();
            }

        }
    }

    /** test case with valid user name and password*/
    @Test
    public void validUserPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate("right", "right");
        } catch (Exception e) {
            fail();
        }

        Assert.assertEquals(res,true,"checking the correct username and password");


    }

    /** test case with invalid user name and  password*/
    @Test
    public void invalidUserPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate("right2", "right2");
        } catch (Exception e) {
            LOG.error("Exception occured");
            fail();

        }

        Assert.assertEquals(res,false,"checking the invalid username and password");
    }


    /** test case with valid user name and valid password*/
    @Test
    public void invalidUser_validPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate("right2", "right");
        } catch (Exception e) {
            LOG.error("Exception occured");
            fail();
        }

        Assert.assertEquals(res,false,"checking invalid username with correct password");

    }


    /** test case with the user name and password empty */
    @Test
    public void emptyUserPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate(" ", " ");
        } catch (Exception e) {
            LOG.error("Exception occured");
            fail();
        }

        Assert.assertEquals(res, false, "checking empty username and password");

    }

    /** test case with empty user name and the valid password*/
    @Test
    public void emptyUser_Pass() {

        boolean res= false;
        try {
            res = LoginValidate.validate(" ", "right ");
        } catch (Exception e) {
            LOG.error("Exception occured");
            fail();
        }

        Assert.assertFalse(res, "checking the empty username with the valid password");

    }

    /** test case with valid user name and an empty password*/
    @Test
    public void User_emptyPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate("right ", " ");
        } catch (Exception e) {
            LOG.error("Exception occured");
            fail();
        }

        Assert.assertFalse(res,"checking valid username with the empty password");

    }

    @AfterClass
    public void destroyUser() throws SQLException {
        PreparedStatement statement2 = null;
        String deleteQuery ="DELETE  FROM user_data" + " WHERE  user_name = 'right'";
        try {
            conn = dbManager.getConnection();

            statement2=conn.prepareStatement(deleteQuery);

            // insert the data
            statement2.executeUpdate();

            LOG.info("in afterClass");
            //conn.close();

        } catch (Exception e)
        {
            LOG.error("Got an exception! : {}", e.getMessage());
        }finally{
            if(statement2 != null){
                statement2.close();
            }

        }


    }

    /** run only once after all tests in this suite have run.*/
    @AfterSuite
    public void ConnectionClose(){
        dbManager.closeConnection();
        LOG.info("After Suite");

    }

}
