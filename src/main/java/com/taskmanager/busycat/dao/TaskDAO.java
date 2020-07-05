package com.taskmanager.busycat.dao;

import com.taskmanager.busycat.model.Task;

import java.util.List;

public interface TaskDAO {
    void createTask(Task task);
    List<Task> showAllTasks(int user_id);
    void changeTaskStatus(int task_id, String task_status);
    void deleteTask(int task_id);
}
