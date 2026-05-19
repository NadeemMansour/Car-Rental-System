package service;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO = new UserDAO();

    // LOGIN
    // =========================
    public User login(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        if (username.isBlank() || password.isBlank()) {
            return null;
        }
        return userDAO.login(username.trim(), password.trim());
    }

    // ADD USER
    // =========================
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        userDAO.insert(user);
    }

    // UPDATE USER
    // =========================
    public void updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        userDAO.update(user);
    }

    // DELETE USER
    // =========================
    public void deleteUser(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid User ID");
        }
        userDAO.delete(userId);
    }

    // GET USER BY ID
    // =========================
    public User getUserById(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid User ID");
        }
        return userDAO.findById(userId);
    }

    // GET ALL USERS
    // =========================
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    // FIND BY USERNAME
    // =========================
    public User findByUsername(String username) {
        if (username == null || username.isBlank()) {
            return null;
        }
        return userDAO.findByUsername(username.trim());
    }

    // CHANGE PASSWORD
    // =========================
    public void changePassword(int userId, String newPassword) {
        User user = userDAO.findById(userId);
        if (user != null) {
            user.setPassword(newPassword);
            userDAO.update(user);
        }
    }

    // ACTIVATE USER
    // =========================
    public void activateUser(int userId) {
        User user = userDAO.findById(userId);
        if (user != null) {
            user.setStatus("ACTIVE");
            userDAO.update(user);
        }
    }

    // DEACTIVATE USER
    // =========================
    public void deactivateUser(int userId) {
        User user = userDAO.findById(userId);
        if (user != null) {
            user.setStatus("INACTIVE");
            userDAO.update(user);
        }
    }
}