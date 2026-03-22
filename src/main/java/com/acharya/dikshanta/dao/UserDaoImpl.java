package com.acharya.dikshanta.dao;

import com.acharya.dikshanta.Autowired;
import com.acharya.dikshanta.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Autowired
public class UserDaoImpl implements UserDao {
    private static final String INSERT_USER = "INSERT INTO users (name,email,password) VALUES (?,?,?)";

    @Override
    public boolean saveUser(String name, String email, String password) {
        try (
                Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_USER);
        ) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            int rowsEffected = ps.executeUpdate();
            return rowsEffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
