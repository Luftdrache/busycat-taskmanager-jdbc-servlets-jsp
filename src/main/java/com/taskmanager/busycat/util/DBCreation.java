package com.taskmanager.busycat.util;

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


    private static final String SQL_CREATE_TABLE_GOAL =
            "CREATE TABLE IF NOT EXISTS taskmanager.goal (\n" +
                    "goal_id int (11) NOT NULL AUTO_INCREMENT,\n" +
                    "goal_title varchar (50) NOT NULL,\n" +
                    "goal_description varchar (150),\n" +
                    "subgoal_id int (11),\n" +
                    "task_id int (11),\n" +
                    "user_id int (11) NOT NULL,\n" +
                    "PRIMARY KEY goal_id_PK (goal_id),\n" +
                    "FOREIGN KEY goal_user_id_FK (user_id) REFERENCES taskmanager.user_data(user_id)\n" +
                    ");";


    private static final String SQL_CREATE_TABLE_TASK =
            "CREATE TABLE IF NOT EXISTS taskmanager.task (\n" +
        "task_id int (11) NOT NULL AUTO_INCREMENT, \n" +
        "task_title varchar (50) NOT NULL,\n" +
        "task_description varchar (150),\n" +
        "task_status int (1),\n" +
        "goal_id int (11),\n" +
        "user_id int (11) NOT NULL, \n" +
        "PRIMARY KEY task_id_PK (task_id), \n" +
        "FOREIGN KEY task_user_id_FK (user_id) REFERENCES taskmanager.user_data(user_id), \n" +
        "FOREIGN KEY task_goal_id_FK (goal_id) REFERENCES taskmanager.goal(goal_id)\n" +
        ");";


    public static void createTables() {
        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.executeUpdate(SQL_CREATE_TABLE_USER);
                statement.executeUpdate(SQL_CREATE_TABLE_GOAL);
                statement.executeUpdate(SQL_CREATE_TABLE_TASK);
            }
        } catch (SQLException exception) {
            System.out.println("createTables() Error");
            Logger.getLogger(DBCreation.class.getName()).log(Level.SEVERE, null, exception);
            exception.getMessage();
        }
    }
}


