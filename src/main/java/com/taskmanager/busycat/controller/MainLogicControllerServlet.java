package com.taskmanager.busycat.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/tasks/*")
public class MainLogicControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getPathInfo();

//        try {
        switch (action) {
            case "/new_task":
                System.out.println("333333333333333");
//                    addTask(request, response);
                break;
            case "/new_goal":
//                    addGoal(request, response);
                break;
            case "/insert":
                //  insertNewTask(request, response);
                break;
            case "/delete":
                //    deleteTask(request, response);
                break;
            case "/edit":
                //    showEditForm(request, response);
                break;
            case "/update":
                //      updateBook(request, response);
                break;
            default:
                //    listBook(request, response);
                break;
        }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if( req.getSession(false) == null) {
//            req.getRequestDispatcher("index.jsp").forward(req, resp);
//        }
        req.getRequestDispatcher("/WEB-INF/views/tasksPage.jsp").forward(req, resp);

    }
}
