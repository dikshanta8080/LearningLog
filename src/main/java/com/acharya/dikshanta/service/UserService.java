package com.acharya.dikshanta.service;

import com.acharya.dikshanta.annotations.Autowired;
import com.acharya.dikshanta.dao.UserDaoImpl;
import com.acharya.dikshanta.model.User;
import com.acharya.dikshanta.utils.Validator;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

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

    public String authenticate(String email, String password) {
        Optional<User> loggedUser = userDao.getLoggedUser(email, password);
        if (loggedUser.isPresent()) {
            User user = loggedUser.get();
            boolean isAuthenticated = BCrypt.checkpw(password, user.getPassword());
            if (isAuthenticated) return null;
        }
        return "Login Failed";
    }
}
