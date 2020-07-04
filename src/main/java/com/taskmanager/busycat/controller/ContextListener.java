package com.taskmanager.busycat.controller;

import com.taskmanager.busycat.util.DBCreation;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//Сработает до всех сервлетов
@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DBCreation.createTables();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
