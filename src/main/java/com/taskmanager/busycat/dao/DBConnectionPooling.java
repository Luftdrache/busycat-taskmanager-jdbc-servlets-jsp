package com.taskmanager.busycat.dao;


import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DBConnectionPooling {

    private static final String DB_DRIVER_CLASS_NAME="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL ="jdbc:mysql://localhost:3306/taskmanager?serverTimezone=UTC&useSSL=false";
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="trd76wr1778";

//    private static final String DB_DRIVER_CLASS="jdbc.driverClassName";
//    private static final String DB_URL ="jdbc.url";
//    private static final String DB_USERNAME="jdbc.username";
//    private static final String DB_PASSWORD="jdbc.password";

    private static Properties properties = null;
    private static BasicDataSource dataSource;

    static {

        try {
//            properties = new Properties();
//            properties.load(new FileInputStream("database.properties"));
//            dataSource = new BasicDataSource();
//            dataSource.setDriverClassName(properties.getProperty(DB_DRIVER_CLASS));
//            dataSource.setUrl(properties.getProperty(DB_URL));
//            dataSource.setUsername(properties.getProperty(DB_USERNAME));
//            dataSource.setPassword(properties.getProperty(DB_PASSWORD));


            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(DB_DRIVER_CLASS_NAME);
            dataSource.setUrl(DB_URL);
            dataSource.setUsername(DB_USERNAME);
            dataSource.setPassword(DB_PASSWORD);

            dataSource.setMaxActive(50);
            dataSource.setMinIdle(100);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}
