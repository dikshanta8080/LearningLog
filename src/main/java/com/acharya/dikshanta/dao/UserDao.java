package com.acharya.dikshanta.dao;

public interface UserDao {
    boolean saveUser(String name, String email, String password);

    boolean existsByEmail(String email);


}
