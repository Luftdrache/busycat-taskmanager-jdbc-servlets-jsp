package com.taskmanager.busycat.dao;

import com.taskmanager.busycat.model.Goal;

import java.util.List;

public interface GoalDAO {
    void createGoal(Goal goal);
    List<Goal> showAllGoalsAndTasks(int user_id);
    void changeGoalStatus(int goal_id, String status);
}
