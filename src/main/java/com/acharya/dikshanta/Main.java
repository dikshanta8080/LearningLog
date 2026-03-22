package com.acharya.dikshanta;

import com.acharya.dikshanta.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        String message = userService.registerUser("Dikshanta Acharya", "dikshantaacharya04@gmail.com", "@Dikshyant9898");
        System.out.println(message);


    }
}
