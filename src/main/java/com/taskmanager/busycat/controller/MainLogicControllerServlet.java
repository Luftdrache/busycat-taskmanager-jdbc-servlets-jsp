package com.taskmanager.busycat.controller;

import com.taskmanager.busycat.dao.GoalDAO;
import com.taskmanager.busycat.dao.GoalDAOImpl;
import com.taskmanager.busycat.dao.TaskDAO;
import com.taskmanager.busycat.dao.TaskDAOImpl;
import com.taskmanager.busycat.model.Goal;
import com.taskmanager.busycat.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class MainLogicControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if( req.getSession(false) == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
//        showTasks(req, resp);
        showAll(req, resp);
        req.getRequestDispatcher("/WEB-INF/views/tasksPage.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        System.out.println(action);
        System.out.println("In post: "+ req.getRequestURI());

        switch (action) {
            case "new_task":
                addTask(req, resp);
                break;
            case "new_goal":
                addGoal(req, resp);
                break;
            case "insert":
                //  insertNewTask(request, response);
                break;
            case "delete":
                deleteTask(req, resp);
                break;
            case "edit":
                //    showEditForm(request, response);
                break;
            case "update":
                //      updateBook(request, response);
                break;
            case "change_task_status":
                changeTaskStatus(req, resp);
                break;
            case "change_goal_status":
                changeGoalStatus(req, resp);
                break;

            default:
                showAll(req, resp);
                break;
        }
        doGet(req, resp);
    }



    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int user_id = (Integer) session.getAttribute("user_id");

        GoalDAO goalDAO = new GoalDAOImpl();
        List<Goal> listOfGoals = goalDAO.showAllGoalsAndTasks(user_id);
        req.setAttribute("listOfGoals", listOfGoals );
        req.getRequestDispatcher("/WEB-INF/views/tasksPage.jsp").forward(req, resp);
    }

    private void addGoal(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();

        String title = req.getParameter("goal_title");
        String description = req.getParameter("goal_description");
        int user_id = (Integer) session.getAttribute("user_id");
        Goal goal = new Goal(title, description, user_id);
        GoalDAO goalDAO = new GoalDAOImpl();
        System.out.println(goal);
        goalDAO.createGoal(goal);
    }

    private void changeGoalStatus(HttpServletRequest req, HttpServletResponse resp) {
        int goal_id = Integer.parseInt(req.getParameter("goal_id"));
        String status = req.getParameter("goal_status");
        GoalDAO taskDAO = new GoalDAOImpl();
        taskDAO.changeGoalStatus(goal_id, status);
    }

    private void addTask(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int user_id = (Integer) session.getAttribute("user_id");
        Task task = new Task(title, description, user_id);
        TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.createTask(task);
    }

    private void deleteTask(HttpServletRequest req, HttpServletResponse resp) {
        int task_id = Integer.parseInt(req.getParameter("id"));
        TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.deleteTask(task_id);
    }


    private void changeTaskStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int task_id = Integer.parseInt(req.getParameter("task_id"));
        String status = req.getParameter("status");
        TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.changeTaskStatus(task_id, status);
    }


//    private void showTasks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        int user_id = (Integer) session.getAttribute("user_id");
//
//        TaskDAO taskDAO = new TaskDAOImpl();
//        List<Task> listOfTasks = taskDAO.showAllTasks(user_id);
//        req.setAttribute("listOfTasks", listOfTasks);
//        req.getRequestDispatcher("/WEB-INF/views/tasksPage.jsp").forward(req, resp);
//    }
//
//    private void showGoals(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        int user_id = (Integer) session.getAttribute("user_id");
//        GoalDAO goalDAO = new GoalDAOImpl();
//        List<Goal> listOfGoals = goalDAO.showAllGoals(user_id);
//        req.setAttribute("listOfGoals", listOfGoals );
//        req.getRequestDispatcher("/WEB-INF/views/tasksPage.jsp").forward(req, resp);
//    }
}
//
//
//    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        int user_id = (Integer) session.getAttribute("user_id");
//
//        TaskDAO taskDAO = new TaskDAOImpl();
//        List<Task> listOfTasks = taskDAO.showAllTasks(user_id);
//        req.setAttribute("listOfTasks", listOfTasks);
//
//        GoalDAO goalDAO = new GoalDAOImpl();
//        List<Goal> listOfGoals = goalDAO.showAllGoals(user_id);
//        req.setAttribute("listOfGoals", listOfGoals );
//        req.getRequestDispatcher("/WEB-INF/views/tasksPage.jsp").forward(req, resp);
//    }