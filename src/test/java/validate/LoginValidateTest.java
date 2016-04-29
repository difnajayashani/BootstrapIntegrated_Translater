package validate;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.testng.Assert;

import property.PropertyReader;

import javax.servlet.http.HttpServlet;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import static org.testng.Assert.fail;

/**test class to test the user authentication  */
public class LoginValidateTest extends HttpServlet {


    /**create the logger object for logging */
    private static final Logger LOG = LogManager.getLogger(LoginValidateTest.class);

    ComboPooledDataSource cpds;

    /** define the connection variable**/
    Connection conn;

    /**  run only once before all tests in this suite have run.*/
    @BeforeSuite
    public void connectDatatbase() {





        LOG.info("load the properties like database url,password and username");
        PropertyReader properties=new PropertyReader();


        try {
            cpds=new ComboPooledDataSource();
            cpds.setDriverClass(properties.getproperty("database.driver","system.properties"));
            cpds.setJdbcUrl(properties.getproperty("database.url", "system.properties"));
            cpds.setUser(properties.getproperty("database.user", "system.properties"));
            cpds.setPassword(properties.getproperty("database.pw", "system.properties"));

            LOG.info("Database Connection created");

            //Setting pooling configurations
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);

        } catch (PropertyVetoException e) {
            LOG.error("Exception related to making database connection pool");
        }

    }

    /** run only once before the first test method in the current class is invoked.*/
    @BeforeClass
    public void insertUser() throws SQLException {


        PreparedStatement statement1 = null;
        String insertQuery ="INSERT INTO user_data (`user_name`, `password`)" +" VALUES ('right', MD5('right'))";

        try {
            conn = cpds.getConnection();
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
            if(conn != null){
                conn.close();

            }

        }
    }

    /** test case with valid user name and password*/
    @Test
    public void validUserPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate("right", "right",conn);
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
            res = LoginValidate.validate("right2", "right2",conn);
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
            res = LoginValidate.validate("right2", "right",conn);
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
            res = LoginValidate.validate(" ", " ",conn);
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
            res = LoginValidate.validate(" ", "right ",conn);
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
            res = LoginValidate.validate("right ", " ",conn);
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
            conn = cpds.getConnection();

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
            if(conn != null){
                conn.close();
            }

        }


    }

    /** run only once after all tests in this suite have run.*/
    @AfterSuite
    public void ConnectionClose(){
        try {
            cpds.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOG.info("After Suite");

    }

}
