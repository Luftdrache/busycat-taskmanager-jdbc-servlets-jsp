package com.taskmanager.busycat.model;

import com.taskmanager.busycat.util.TaskStatus;
import java.util.Date;

public class Task {
    private int task_id;
    private String task_title;
    private String task_description;
    private TaskStatus task_status;
    private int goal_id;
    private int user_id;

    public Task(String task_title, String task_description, int user_id) {
        this.task_title = task_title;
        this.task_description = task_description;
        this.task_status = TaskStatus.IN_PROGRESS;
        this.user_id = user_id;
    }
    public Task(int task_id, String task_title, String task_description, TaskStatus task_status, int goal_id, int user_id) {
        this.task_id = task_id;
        this.task_title = task_title;
        this.task_description = task_description;
        this.task_status = task_status;
        this.goal_id = goal_id;
        this.user_id = user_id;
    }

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

    public void setTask_status(TaskStatus task_status) {
        this.task_status = task_status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_title='" + task_title + '\'' +
                ", task_description='" + task_description + '\'' +
                ", task_status=" + task_status +
                ", goal_id=" + goal_id +
                ", user_id=" + user_id +
                '}';
    }
}
