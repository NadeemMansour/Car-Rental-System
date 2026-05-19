package dao;

import model.User;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // LOGIN
    public User login(String username, String password) {

        User user = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sql ="SELECT * FROM user WHERE Username=? AND Password=?";

            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("User_ID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setStatus(rs.getString("Status"));
                user.setRole(rs.getString("Role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // INSERT USER
    public void insert(User user) {

        try {
            Connection conn = DBConnection.getConnection();
            String sql ="INSERT INTO user(Username,Password,Status,Role) VALUES(?,?,?,?)";
            PreparedStatement ps =conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getStatus());
            ps.setString(4, user.getRole());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE USER
    public void update(User user) {

        try {
            Connection conn = DBConnection.getConnection();
            String sql ="UPDATE user SET Username=?, Password=?, Status=?, Role=? WHERE User_ID=?";
            PreparedStatement ps =conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getStatus());
            ps.setString(4, user.getRole());
            ps.setInt(5, user.getUserId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE USER
    public void delete(int userId) {

        try {
            Connection conn = DBConnection.getConnection();
            String sql ="DELETE FROM user WHERE User_ID=?";
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FIND USER BY ID
    public User findById(int id) {

        User user = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sql ="SELECT * FROM user WHERE User_ID=?";
            PreparedStatement ps =conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("User_ID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setStatus(rs.getString("Status"));
                user.setRole(rs.getString("Role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // FIND ALL USERS
    public List<User> findAll() {

        List<User> users = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM user";

            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("User_ID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setStatus(rs.getString("Status"));
                user.setRole(rs.getString("Role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // FIND USER BY USERNAME
    public User findByUsername(String username) {

        try {
            Connection conn = DBConnection.getConnection();
            String sql ="SELECT * FROM user WHERE Username=?";
            PreparedStatement ps =conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("User_ID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setStatus(rs.getString("Status"));
                user.setRole(rs.getString("Role"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}