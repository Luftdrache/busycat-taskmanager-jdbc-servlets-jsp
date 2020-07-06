package com.taskmanager.busycat.dao;

import com.taskmanager.busycat.model.Goal;
import com.taskmanager.busycat.model.Task;
import com.taskmanager.busycat.util.DBConnectionPooling;
import com.taskmanager.busycat.util.TaskStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoalDAOImpl implements GoalDAO {

    @Override
    public void createGoal(Goal goal) {
        String sql = "INSERT INTO taskmanager.goal VALUES (null, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, goal.getGoal_title());
            preparedStatement.setString(2, goal.getGoal_description());
            preparedStatement.setInt(3, goal.getGoal_status().ordinal());
            preparedStatement.setNull(4, java.sql.Types.NULL);
            preparedStatement.setNull(5, java.sql.Types.NULL);
            preparedStatement.setInt(6, goal.getUser_id());
            preparedStatement.executeUpdate();

        } catch (
                SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Goal> showAllGoals(int user_id) {
        List<Goal> listOfGoals= new ArrayList<>();
        String sql = "SELECT * FROM taskmanager.goal WHERE user_id = ?";

        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, user_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int goal_id = resultSet.getInt("goal_id");
                    String goal_title = resultSet.getString("goal_title");
                    String goal_description = resultSet.getString("goal_description");
//                    TaskStatus task_status = TaskStatus.values()[resultSet.getInt("task_status")];
//                    int goal_id = resultSet.getInt("goal_id");
                    Goal goal = new Goal(goal_id, goal_title, goal_description, user_id);
                    listOfGoals.add(goal);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return listOfGoals;
    }
}
