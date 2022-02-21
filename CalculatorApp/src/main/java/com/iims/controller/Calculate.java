package com.iims.controller;

import com.iims.evalPrefix.EvalPre;
import com.iims.infixToPrefix.InToPre;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calculate", urlPatterns = "/calculate")
public class Calculate extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String expression = req.getParameter("expression");
        String prefixExpression = InToPre.infixToPrefix(" " + expression);
        double result = EvalPre.evaluatePrefix(prefixExpression);

        resp.setContentType("text/html");
        resp.getWriter().write("{ \"result\": \"" + result + "\" }");
    }
}
