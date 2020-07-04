package com.taskmanager.busycat.dao;

import com.taskmanager.busycat.util.DBConnectionPooling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO{

    @Override
    public int findUserId(String email, String password) {

        String sql = "SELECT user_id FROM taskmanager.user_data " +
                "WHERE user_email = ? AND user_password = ?;";
        int user_id = 0;

        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2,password);
            try(ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    user_id = resultSet.getInt(1);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user_id;
    }


    @Override
    public int createNewUser(String nickname, String email, String password) {
        String sql = "INSERT INTO taskmanager.user_data VALUES (null, ?, ?, ?);";
        int row = 0;
        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,nickname);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            row = preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return row;
    }


    @Override
    public String getNickname(int user_id) {
        String nickname = "";
        String sql = "SELECT user_nickname FROM taskmanager.user_data " +
                "WHERE user_id = ?;";
        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, user_id);
            try( ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    nickname = resultSet.getString("user_nickname");
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return nickname;
    }
}
