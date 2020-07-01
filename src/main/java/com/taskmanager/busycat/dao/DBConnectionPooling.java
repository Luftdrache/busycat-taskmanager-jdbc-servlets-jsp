package com.taskmanager.busycat.dao;


import org.apache.commons.dbcp.BasicDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DBConnectionPooling {

    private static Properties properties;
    private static BasicDataSource dataSource;

    private static final String DB_PROPERTIES = "/database.properties";
    private static final String DB_DRIVER_CLASS = "jdbc.driverClassName";
    private static final String DB_URL = "jdbc.url";
    private static final String DB_USERNAME = "jdbc.username";
    private static final String DB_PASSWORD = "jdbc.password";


    static {
        properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream propertiesStream = classLoader.getResourceAsStream(DB_PROPERTIES)) {
            if (propertiesStream != null) {
                properties.load(propertiesStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(properties.getProperty(DB_DRIVER_CLASS));
        dataSource.setUrl(properties.getProperty(DB_URL));
        dataSource.setUsername(properties.getProperty(DB_USERNAME));
        dataSource.setPassword(properties.getProperty(DB_PASSWORD));
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}
