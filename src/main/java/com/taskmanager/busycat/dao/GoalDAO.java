package com.taskmanager.busycat.dao;

import com.taskmanager.busycat.model.Goal;

import java.util.List;

public interface GoalDAO {
    void createGoal(Goal goal);
    List<Goal> showAllGoals(int user_id);
}
