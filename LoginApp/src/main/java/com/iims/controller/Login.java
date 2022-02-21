package com.iims.controller;

import com.iims.dao.UserDao;
import com.iims.dao.impl.UserDaoImpl;
import com.iims.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("home");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        session.setAttribute("username", username);

        if (username.length() > 0 && password.length() > 0) {

            UserDao userDao = new UserDaoImpl();
            User user = null;

            try {
                user = userDao.findOne(username, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (user != null) {
                session.setAttribute("user", user);
                session.removeAttribute("username");
                session.removeAttribute("error");
                resp.sendRedirect("home");
            } else {
                session.setAttribute("error", "Invalid Credentials!");
                resp.sendRedirect("login");
            }
        } else {
            session.setAttribute("error", "Enter both email and password!");
            resp.sendRedirect("login");
        }
    }
}
