package com.acharya.dikshanta.utils;

public class Validator {
    public static String validateRegisterRequest(String name, String email, String password) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        boolean isMatched = email.matches(regex);
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || !isMatched) {
            return "Please provide valid input credentials";
        }
        return null;

    }
}
