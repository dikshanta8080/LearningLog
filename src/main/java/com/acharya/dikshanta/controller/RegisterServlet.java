package com.acharya.dikshanta.controller;

import com.acharya.dikshanta.dao.UserDaoImpl;
import com.acharya.dikshanta.utils.Validator;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserDaoImpl userDao;

    public RegisterServlet(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("views/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String errorMessage = Validator.validateRegisterRequest(name, email, password);
        if (errorMessage != null) {
            RequestDispatcher rd = req.getRequestDispatcher("views/register.jsp");
            rd.forward(req, resp);
        }
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

    }
}
