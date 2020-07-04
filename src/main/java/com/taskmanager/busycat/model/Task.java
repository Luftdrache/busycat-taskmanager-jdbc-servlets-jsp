package com.taskmanager.busycat.model;

import com.taskmanager.busycat.util.TaskStatus;
import java.util.Date;

public class Task {
    private int task_id;
    private String task_title;
    private String task_description;
    private Date task_termination_date;
    private TaskStatus task_status;
    private int goal_id;
    private int user_id;

    public int getTask_id() {
        return task_id;
    }

    public String getTask_title() {
        return task_title;
    }

    public String getTask_description() {
        return task_description;
    }

    public int getGoal_id() {
        return goal_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public void setGoal_id(int goal_id) {
        this.goal_id = goal_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public TaskStatus getTask_status() {
        return task_status;
    }

    public void setTask_termination_date(Date task_termination_date) {
        this.task_termination_date = task_termination_date;
    }

    public void setTask_status(TaskStatus task_status) {
        this.task_status = task_status;
    }


}
