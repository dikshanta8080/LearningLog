package com.acharya.dikshanta.service;

import com.acharya.dikshanta.annotations.Autowired;
import com.acharya.dikshanta.dao.UserDaoImpl;
import com.acharya.dikshanta.utils.Validator;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    private final UserDaoImpl userDao;

    @Autowired
    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    public String registerUser(String name, String email, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String errorMessage = Validator.validateRegisterRequest(name, email, password);
        if (errorMessage != null) return errorMessage;
        if (userDao.existsByEmail(email)) return "The user with this email already exists";
        boolean isSaved = userDao.saveUser(name, email, hashedPassword);
        if (!isSaved) return "Registration Failed";
        return null;

    }
}
