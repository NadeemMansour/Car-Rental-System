package controller;

import model.User;
import service.UserService;

public class LoginController {

    private final UserService userService = new UserService();
    private User currentUser;

    // LOGIN
    // =========================
    public String login(String username, String password) {

        if (!validateLogin(username, password)) {
            return "Invalid Username Or Password";
        }
        currentUser = userService.login(username, password);
        if (currentUser == null) {
            return "Login Failed";
        }
        return "Login Successful";
    }

    // LOGOUT
    // =========================
    public void logout() {
        currentUser = null;
    }

    // VALIDATE LOGIN
    // =========================
    public boolean validateLogin(String username, String password) {

        if (username == null || password == null) {
            return false;
        }
        if (username.isBlank() || password.isBlank()) {
            return false;
        }
        return true;
    }

    // GET CURRENT USER
    // =========================
    public User getCurrentUser() {
        return currentUser;
    }

    // CHECK ADMIN
    // =========================
    public boolean isAdmin() {
        return currentUser != null && currentUser.getRole().equalsIgnoreCase("ADMIN");
    }

    // CHECK EMPLOYEE
    public boolean isEmployee() {
        return currentUser != null && currentUser.getRole().equalsIgnoreCase("EMPLOYEE");
    }
}