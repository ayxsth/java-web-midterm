package com.iims.controller;

import com.iims.dao.QuestionDao;
import com.iims.dao.impl.QuestionDaoImpl;
import com.iims.model.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "home", urlPatterns = "/home")
public class Home extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        QuestionDao questionDao = new QuestionDaoImpl();

        try {
            if (session.getAttribute("buttonName") == null) {
                session.setAttribute("questions", questionDao.getRandom10Questions());
                session.setAttribute("buttonName", "Submit");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("buttonName") == "Submit"){
            List<Question> questions = (List<Question>) session.getAttribute("questions");
            int points = 0;
            List<String> chosenAnswers = new ArrayList<>();

            for (Question question : questions) {
                String chosenAnswer = req.getParameter(String.valueOf(question.getId()));
                chosenAnswers.add(chosenAnswer);
                if (Objects.equals(chosenAnswer, question.getCorrectAns()))
                    points++;
            }

            session.setAttribute("chosenAnswers", chosenAnswers);
            session.setAttribute("points", points);
            session.setAttribute("buttonName", "Try Again");
        } else if(session.getAttribute("buttonName") == "Try Again"){
            session.removeAttribute("chosenAnswers");
            session.removeAttribute("buttonName");
            session.removeAttribute("questions");
            session.setAttribute("points", 0);
        }

        resp.sendRedirect("home");
    }
}
