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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/signUpPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nickname = req.getParameter("nickname");
        String email_login = req.getParameter("email");
        String password = req.getParameter("password");


        if (!EmailValidation.isValidEmail(email_login) || password.equals("") || nickname.equals("")) {
            req.setAttribute("warning", "Check the entered data");
            req.getRequestDispatcher("/WEB-INF/views/signUpPage.jsp").forward(req, resp);
        }

        UserDAO userDAO = new UserDAOImpl();
        int result = userDAO.createNewUser(nickname, email_login, password);

        if(result==0) {
            req.setAttribute("warning", "This user already exists");
            req.getRequestDispatcher("/WEB-INF/views/signUpPage.jsp").forward(req, resp);
        }

        int user_id = userDAO.findUserId(email_login, password);

        HttpSession session = req.getSession();
        session.setAttribute("user_id", user_id);
        session.setAttribute("user_nickname", nickname);

        resp.sendRedirect("tasks");
    }

}
