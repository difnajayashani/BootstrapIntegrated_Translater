/*
package c3p0.sample;



import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DatabaseUtility {

    public  static ComboPooledDataSource getDataSource() throws PropertyVetoException {

        ComboPooledDataSource cpds= new ComboPooledDataSource();

        cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql://localhost/c3p0_test");
        cpds.setUser("root");
        cpds.setPassword("root");

        */
/**set the maximum, minimum of the Pool size and the connection increments
         * this is optional *//*

        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);


        return cpds;

    }


    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            ComboPooledDataSource dataSource = DatabaseUtility.getDataSource();
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM table_test");

            System.out.println("The Connection Object is of Class: " + connection.getClass());

            resultSet = pstmt.executeQuery();

            while (resultSet.next()){


                System.out.println(resultSet.getString(1) + "," + resultSet.getString(2) + "," + resultSet.getString(3));


            }

        } catch (Exception e) {
            assert connection != null;
            connection.rollback();
            e.printStackTrace();
        }

    }
}
*/
