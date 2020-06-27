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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String email_login  = request.getParameter("login");
       String password = request.getParameter("password");

      if(!isValidEmail(email_login) || password.equals("")) {
          request.setAttribute("warning", "Invalid email or password");
          request.getRequestDispatcher("index.jsp").forward(request, response);
      }


       String sql = "SELECT * FROM taskmanager.user_data";
        try(Connection connection = DBConnectionPooling.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            System.out.println("DB works");

            request.getRequestDispatcher("/WEB-INF/views/startPage.jsp").forward(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private boolean isValidEmail(String email_login) {
        Pattern pattern = Pattern.compile("(\\w+\\.)*\\w+@(\\w+\\.)+[a-zA-z]{2,}");
        Matcher matcher = pattern.matcher(email_login);
        return matcher.find();
    }
}
