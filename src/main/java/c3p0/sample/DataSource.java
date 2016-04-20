/*
package c3p0.sample;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;

*/
/**
 * In this class we instantiate an instance of com.mchange.v2.c3p0.ComboPooledDataSource
 * most straightforward way to create a c3p0 pooling DataSource
 *
 * *//*

public class DataSource {

    */
/**create the logger object for logging *//*

    private static final Logger LOG = LogManager.getLogger(DataSource.class);

    private static DataSource datasource;
    private ComboPooledDataSource cpds;


    */
/** to configure the DataSource and to make a usable pooled DataSource*//*

    private DataSource() throws IOException, SQLException, PropertyVetoException {

        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql://localhost/c3p0_test");
        cpds.setUser("root");
        cpds.setPassword("root");

        */
/**set the maximum, minimum of the Pool size and the connection increments *//*

        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);

    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

    public static void main (String... args) {

        try {
            DataSource c1=new DataSource();
            getInstance();
            LOG.info("Instance Created");

            c1.getConnection();
            LOG.info("Connection Created");

        } catch (IOException e) {
            LOG.error("IOException Occured");;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }



    }


}*/
