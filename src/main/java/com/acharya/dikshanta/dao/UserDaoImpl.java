package com.acharya.dikshanta.dao;

import com.acharya.dikshanta.annotations.Autowired;
import com.acharya.dikshanta.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Autowired
public class UserDaoImpl implements UserDao {
    private static final String INSERT_USER = "INSERT INTO users (name,email,password) VALUES (?,?,?)";
    private static final String EXISTS_BY_EMAIL = "SELECT * FROM users WHERE email=?";

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

        }
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        try (
                Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(EXISTS_BY_EMAIL);
        ) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
