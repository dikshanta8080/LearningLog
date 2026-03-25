package com.acharya.dikshanta.controller;

import com.acharya.dikshanta.service.UserService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet {
    private final UserService userService;

    public LoginServlet(UserService userService) {
        this.userService = new UserService();
    }
}
