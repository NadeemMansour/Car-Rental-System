package controller;

import model.User;
import service.AuthService;
import util.SessionManager;

public class AuthController {

    private AuthService authService = new AuthService();

    public String login(String username, String password) {

        User user = authService.login(username, password);

        if (user != null) {
            SessionManager.setCurrentUser(user);
            return "Login Successful";
        }

        return "Invalid Credentials";
    }

    public void logout() {
        SessionManager.clearSession();
    }

    public boolean isLoggedIn() {
        return SessionManager.isLoggedIn();
    }
}