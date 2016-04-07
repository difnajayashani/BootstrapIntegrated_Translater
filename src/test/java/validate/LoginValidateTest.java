package validate;

import database.DBConnectionManager;
import org.testng.annotations.*;

import org.testng.Assert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.testng.Assert.fail;


public class LoginValidateTest {


    DBConnectionManager dbManager;
    Connection conn =null;

    /**  run only once before all tests in this suite have run.*/
    @BeforeSuite
    public void connectDatatbase() {
        dbManager = new DBConnectionManager("jdbc:mysql://localhost/login_db", "root", "root");

    }

    /** run only once before the first test method in the current class is invoked.*/
    @BeforeClass
    public void insertUser() throws SQLException {
        PreparedStatement statement1 = null;
        String insertQuery ="INSERT INTO user_data (`user_name`, `password`, `f_name`)" +" VALUES ('right', MD5('right'), 'Right')";
        try {
            conn = DBConnectionManager.getConnection();
            // create a Statement from the connection

            statement1=conn.prepareStatement(insertQuery);
            // insert the data
            statement1.executeUpdate();
            // INSERT INTO `user_data` (`user_name`, `password`, `f_name`) VALUES ('new', MD5('new'), 'New');
            System.out.println("in beforeClass");


        } catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }finally{
            if(statement1 != null) {
                statement1.close();
            }

        }
    }


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
    @Test
    public void invalidUserPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate("right2", "right2");
        } catch (Exception e) {
            e.printStackTrace();

        }

        Assert.assertEquals(res,false,"checking the invalid username and password");
    }

    @Test
    public void invalidUser_validPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate("right2", "right");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        Assert.assertEquals(res,false,"checking invalid username with correct password");

    }


    @Test
    public void emptyUserPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate(" ", " ");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        Assert.assertEquals(res, false, "checking empty username and password");

    }

    @Test
    public void emptyUser_Pass() {

        boolean res= false;
        try {
            res = LoginValidate.validate(" ", "right ");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        Assert.assertFalse(res, "checking the empty username with the valid password");

    }

    @Test
    public void User_emptyPass() {

        boolean res= false;
        try {
            res = LoginValidate.validate("right ", " ");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        Assert.assertFalse(res,"checking valid username with the empty password");

    }

    @AfterClass
    public void destroyUser() throws SQLException {
        PreparedStatement statement2 = null;
        String deleteQuery ="DELETE  FROM user_data" + " WHERE  user_name = 'right'";
        try {
            conn = DBConnectionManager.getConnection();

            statement2=conn.prepareStatement(deleteQuery);

            // insert the data
            statement2.executeUpdate();

            System.out.println("in afterClass");
            //conn.close();

        } catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }finally{
            if(statement2 != null){
                statement2.close();
            }

        }


    }

    /** run only once after all tests in this suite have run.*/
    @AfterSuite
    public void closeConnection(){
        dbManager.closeConnection();
        System.out.println("After Suite");

    }

}
