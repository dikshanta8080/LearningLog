package com.acharya.dikshanta.controller;

import com.acharya.dikshanta.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserService userService;


    public RegisterServlet() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String errorMessage = userService.registerUser(name, email, password);
        if (errorMessage != null) {
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;

        }
        resp.sendRedirect(req.getContextPath() + "/login");
        System.out.println("The name is " + name);
        System.out.println("The email is " + email);

    }
}
