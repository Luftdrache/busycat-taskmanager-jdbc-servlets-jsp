package com.taskmanager.busycat.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCreation {

    private static final String SQL_CREATE_TABLE_USER =
            "CREATE TABLE IF NOT EXISTS taskmanager.user_data (\n" +
            "user_id int (11) NOT NULL AUTO_INCREMENT,\n" +
            "user_nickname varchar (30) NOT NULL,\n" +
            "user_email varchar (70) NOT NULL,\n" +
            "user_password varchar (30) NOT NULL, \n" +
            "PRIMARY KEY user_id_PK (user_id), \n" +
            "UNIQUE KEY email_UK (user_email)\n" +
            ");";


    public static void createTables() {
        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.executeUpdate(SQL_CREATE_TABLE_USER);
            }
        } catch (SQLException exception) {
            System.out.println("createTables() Error");
            Logger.getLogger(DBCreation.class.getName()).log(Level.SEVERE, null, exception);
            exception.getMessage();
        }
    }
}


