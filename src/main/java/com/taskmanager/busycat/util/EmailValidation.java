package com.taskmanager.busycat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidation {
    public static boolean isValidEmail(String email_login) {
        Pattern pattern = Pattern.compile("(\\w+\\.)*\\w+@(\\w+\\.)+[a-zA-z]{2,}");
        Matcher matcher = pattern.matcher(email_login);
        return matcher.find();
    }
}
