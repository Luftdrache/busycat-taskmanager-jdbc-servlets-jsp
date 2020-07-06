package com.taskmanager.busycat.model;


import com.taskmanager.busycat.util.TaskStatus;

import java.util.List;

public class Goal {
   private int goal_id;
   private String goal_title;
   private String goal_description;
   private TaskStatus goal_status;
   private int user_id;
   private List<Goal> subgoalsList;
   private List<Task> taskList;

    public Goal(String goal_title, String goal_description, int user_id) {
        this.goal_title = goal_title;
        this.goal_description = goal_description;
        this.goal_status = TaskStatus.IN_PROGRESS;
        this.user_id = user_id;
    }

    public Goal(int goal_id, String goal_title, String goal_description, int user_id) {
        this.goal_id = goal_id;
        this.goal_title = goal_title;
        this.goal_description = goal_description;
        this.user_id = user_id;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public String getGoal_title() {
        return goal_title;
    }

    public String getGoal_description() {
        return goal_description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public void setGoal_title(String goal_title) {
        this.goal_title = goal_title;
    }

    public void setGoal_description(String goal_description) {
        this.goal_description = goal_description;
    }


    public TaskStatus getGoal_status() {
        return goal_status;
    }

    public void setGoal_status(TaskStatus goal_status) {
        this.goal_status = goal_status;
    }

    public List<Goal> getSubgoalsList() {
        return subgoalsList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setSubgoalsList(List<Goal> subgoalsList) {
        this.subgoalsList = subgoalsList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goal_id=" + goal_id +
                ", goal_title='" + goal_title + '\'' +
                ", goal_description='" + goal_description + '\'' +
                ", goal_status=" + goal_status +
                ", user_id=" + user_id +
                ", subgoalsList=" + subgoalsList +
                ", taskList=" + taskList +
                '}';
    }
}
