package com.taskmanager.busycat.dao;

import com.taskmanager.busycat.model.User;

public interface UserDAO {
    int findUserId(String email, String password);
    int createNewUser(String nickname, String email, String password);
    String getNickname(int user_id);
}
