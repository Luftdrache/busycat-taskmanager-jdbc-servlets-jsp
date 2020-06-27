package com.taskmanager.busycat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MainLogicControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();

//        try {
            switch (action) {
                case "/new":
//                    showNewForm(request, response);
                    break;
                case "/insert":
                  //  insertNewTask(request, response);
                    break;
                case "/delete":
                //    deleteBook(request, response);
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

    }
}
