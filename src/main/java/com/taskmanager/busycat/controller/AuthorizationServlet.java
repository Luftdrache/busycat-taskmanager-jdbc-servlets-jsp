package com.taskmanager.busycat.controller;

import com.taskmanager.busycat.dao.UserDAO;
import com.taskmanager.busycat.dao.UserDAOImpl;
import com.taskmanager.busycat.util.EmailValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email_login = req.getParameter("login");
        String password = req.getParameter("password");

        if (!EmailValidation.isValidEmail(email_login) || password.equals("")) {
            req.setAttribute("warning", "Invalid email or empty password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

        UserDAO userDAO = new UserDAOImpl();
        int user_id = userDAO.findUserId(email_login, password);
        if(user_id < 1) {
            req.setAttribute("warning", "Username does not exist or password is bad");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }


        HttpSession session = req.getSession();
        session.setAttribute("user_id", user_id);
        session.setAttribute("user_nickname", userDAO.getNickname(user_id));

        resp.sendRedirect("tasks");
    }


}
