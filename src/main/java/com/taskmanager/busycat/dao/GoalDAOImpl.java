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
    public List<Goal> showAllGoalsAndTasks(int user_id) {

        String sql = "SELECT * FROM (" +
                "SELECT goal.goal_id 'goal id', goal.goal_title 'goal title', goal.goal_description 'goal description', " +
                "goal.goal_status 'goal status', goal.parent_goal_id 'parent id',  " +
                "task.task_id 'task id', task.task_title 'task title', task.task_description 'task description', " +
                " task.task_status 'task status', task.goal_id 'task goal id' " +
                "FROM taskmanager.goal goal RIGHT JOIN taskmanager.task task " +
                "ON taskmanager.goal.goal_id = taskmanager.task.goal_id " +
                "UNION " +
                "SELECT goal.goal_id 'goal id', goal.goal_title 'goal title', goal.goal_description 'goal description', " +
                "goal.goal_status 'goal status', goal.parent_goal_id 'parent id',  " +
                "task.task_id 'task id', task.task_title 'task title', task.task_description 'task description', " +
                " task.task_status 'task status', task.goal_id 'task goal id' " +
                "FROM taskmanager.goal LEFT JOIN taskmanager.task " +
                "ON taskmanager.goal.goal_id = taskmanager.task.goal_id) full_tab " +
                "order by 1, 4;";

        List<Goal> listOfAll = new ArrayList<>();

        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, user_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                int parent = 0;
                int task_id = 0;
                int goal_id = 0;
                String goal_title = "";
                String goal_description = "";
                TaskStatus goal_status = TaskStatus.IN_PROGRESS;

                Task task = null;
                List<Task> tasks = new ArrayList<>();
                List<Goal> subgoals = new ArrayList<>();
                while (resultSet.next()) {
                    //For a goal with/without tasks:
                    if (goal_id != resultSet.getInt(1) && resultSet.getInt(1) > 0) {
                        Goal goal_without_task = new Goal(goal_id, goal_title, goal_description, goal_status, tasks);
                        listOfAll.add(goal_without_task);
                        goal_id = resultSet.getInt(1);
                    }
                    if (goal_id != 0) { //not NULL
                        goal_title = resultSet.getString(2);
                        goal_description = resultSet.getString(3);
                        goal_status = TaskStatus.values()[resultSet.getInt(4)];
                        parent = resultSet.getInt(5);
                        if (parent == 0) { //*****if doesn't have subgoals
                            task_id = resultSet.getInt(6);
                            String task_title = resultSet.getString(8);
                            String task_description = resultSet.getString(9);
                            TaskStatus task_status = TaskStatus.values()[resultSet.getInt(10)];
                            int task_goal_id = resultSet.getInt(11);
                            int task_user_id = resultSet.getInt(12);
                            task = new Task(task_id, task_title, task_description, task_status, task_goal_id, task_user_id);
                            tasks.add(task);
                        } else { //For tasks without goal
                            task_id = resultSet.getInt(7);
                            String task_title = resultSet.getString(8);
                            String task_description = resultSet.getString(9);
                            TaskStatus task_status = TaskStatus.values()[resultSet.getInt(10)];
                            int task_goal_id = resultSet.getInt(11);
                            int task_user_id = resultSet.getInt(12);
                            task = new Task(task_id, task_title, task_description, task_status, task_goal_id, task_user_id);
                            tasks.add(task);
                            Goal goal_without_task = new Goal(tasks);
                            listOfAll.add(goal_without_task);
                        }
                    }
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return listOfAll;
    }


    @Override
    public void changeGoalStatus(int goal_id, String goal_status) {
        String sql = "UPDATE taskmanager.goal SET goal_status=? WHERE goal_id=?;";
        int newStatus = goal_status.equals("IN_PROGRESS") ? 1 : 0;

        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, newStatus);
            preparedStatement.setInt(2, goal_id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

//    @Override
//    public List<Goal> showAllGoalsAndTasks(int user_id) {
//        List<Goal> listOfGoals = new ArrayList<>();
//        String sql = "SELECT * FROM taskmanager.goal WHERE user_id = ? ORDER BY goal_status;";
//
//        try (Connection connection = DBConnectionPooling.getDataSource().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
//
//            preparedStatement.setInt(1, user_id);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    int goal_id = resultSet.getInt("goal_id");
//                    String goal_title = resultSet.getString("goal_title");
//                    String goal_description = resultSet.getString("goal_description");
//                    TaskStatus goal_status = TaskStatus.values()[resultSet.getInt("goal_status")];
//                    Goal goal = new Goal(goal_id, goal_title, goal_description, goal_status, user_id);
//                    listOfGoals.add(goal);
//                }
//            }
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return listOfGoals;
//    }

