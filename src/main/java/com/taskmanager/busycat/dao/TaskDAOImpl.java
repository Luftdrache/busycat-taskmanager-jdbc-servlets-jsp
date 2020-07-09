package com.taskmanager.busycat.dao;

import com.taskmanager.busycat.model.Task;
import com.taskmanager.busycat.util.DBConnectionPooling;
import com.taskmanager.busycat.util.TaskStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    @Override
    public void deleteTask(int task_id) {
        String sql = "DELETE FROM taskmanager.task WHERE task_id=?;";
        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) { ;
            preparedStatement.setInt(1, task_id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void changeTaskStatus(int task_id, String task_status) {
        String sql = "UPDATE taskmanager.task SET task_status=? WHERE task_id=?;";
        int newStatus = task_status.equals("IN_PROGRESS")? 1:0;

        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, newStatus);
            preparedStatement.setInt(2, task_id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void createTask(Task task) {
        String sql = "INSERT INTO taskmanager.task VALUES (null, ?, ?, ?, ?, ?);";
        int goal_id = task.getGoal_id();

        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, task.getTask_title());
            preparedStatement.setString(2, task.getTask_description());
            preparedStatement.setInt(3, task.getTask_status().ordinal());
            if (goal_id == 0) {
                preparedStatement.setNull(4, java.sql.Types.NULL);
            } else {
                preparedStatement.setInt(4, goal_id);
            }
            preparedStatement.setInt(5, task.getUser_id());
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Task> showAllTasks(int user_id) {
        List<Task> listOfTasks = new ArrayList<>();
        String sql = "SELECT * FROM taskmanager.task WHERE user_id = ? ORDER BY task_status;";

        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, user_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int task_id = resultSet.getInt("task_id");
                    String title = resultSet.getString("task_title");
                    String task_description = resultSet.getString("task_description");
                    TaskStatus task_status = TaskStatus.values()[resultSet.getInt("task_status")];
                    int goal_id = resultSet.getInt("goal_id");
                    Task task = new Task(task_id, title, task_description, task_status, goal_id, user_id);
                    listOfTasks.add(task);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return listOfTasks;
    }


}
