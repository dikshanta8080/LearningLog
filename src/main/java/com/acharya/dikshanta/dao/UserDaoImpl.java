package com.acharya.dikshanta.dao;

import com.acharya.dikshanta.annotations.Autowired;
import com.acharya.dikshanta.model.User;
import com.acharya.dikshanta.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

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

    public Optional<User> getLoggedUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String savedEmail = rs.getString("email");
                String savedPassword = rs.getString("password");
                return Optional.of(new User(savedEmail, savedPassword));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}
