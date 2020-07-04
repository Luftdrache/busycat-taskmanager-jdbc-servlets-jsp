package com.taskmanager.busycat.model;


public class Goal {
   private int goal_id;
   private String goal_title;
   private String goal_description;
   private int subgoal_id;
   private int task_id;
   private int user_id;

    public int getGoal_id() {
        return goal_id;
    }

    public String getGoal_title() {
        return goal_title;
    }

    public String getGoal_description() {
        return goal_description;
    }

    public int getSubgoal_id() {
        return subgoal_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public int getUser_id() {
        return user_id;
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

    public void setSubgoal_id(int subgoal_id) {
        this.subgoal_id = subgoal_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goal_id=" + goal_id +
                ", goal_title='" + goal_title + '\'' +
                ", goal_description='" + goal_description + '\'' +
                ", subgoal_id=" + subgoal_id +
                ", task_id=" + task_id +
                ", user_id=" + user_id +
                '}';
    }
}
