package authorTest; /**
 * Created by Oleg on 18.04.2015.
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;

public abstract class DBUnitConfig extends DBTestCase {

    public DBUnitConfig(String name) {
        super(name);
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("META-INF/db.config.properties");
        try {
            properties.load(inputStream);
            System.setProperty(
                    PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
                    properties.getProperty("db.driver"));
            System.setProperty(
                    PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
                    properties.getProperty("db.url"));
            System.setProperty(
                    PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
                    properties.getProperty("db.username"));
            System.setProperty(
                    PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
                    properties.getProperty("db.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}