package com.taskmanager.busycat.controller;

import com.taskmanager.busycat.dao.DBConnectionPooling;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String login  = request.getParameter("login");
       String password = request.getParameter("password");


        String sql = "SELECT * FROM taskmanager.user_data";
        try(Connection connection = DBConnectionPooling.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            System.out.println("DB works");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        request.getRequestDispatcher("/WEB-INF/views/startPage.jsp").forward(request, response);
    }
}
