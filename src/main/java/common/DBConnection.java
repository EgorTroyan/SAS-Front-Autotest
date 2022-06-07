package common;

import config.TestsConfig;
import db.entity.Enrollment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.Property;

import java.util.Properties;

public class DBConnection {

    private final SessionFactory factory;
    private static final String DB_CONFIG = "config.properties";

    public DBConnection(){
        Properties properties = new Properties();
        TestsConfig config = TestsConfig.getConfig();
        properties.put(Environment.DRIVER, config.getProperty("hibernate.connection.driver_class"));
        properties.put(Environment.URL, config.getProperty("hibernate.connection.url"));
        properties.put(Environment.USER, config.getProperty("hibernate.connection.username"));
        properties.put(Environment.PASS, config.getProperty("hibernate.connection.password"));
        properties.put(Environment.SHOW_SQL, config.getProperty("hibernate.show_sql"));
        properties.put(Environment.DIALECT, config.getProperty("hibernate.dialect"));
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, config.getProperty("hibernate.current_session_context_class"));
        properties.put(Environment.HBM2DDL_AUTO, config.getProperty("hibernate.hbm2ddl"));
        factory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Enrollment.class)
                .buildSessionFactory();
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void closeFactory(){
        factory.close();
    }
}
