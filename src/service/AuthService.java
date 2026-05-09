package service;

import dao.UserDAO;
import model.User;

public class AuthService {

    private UserDAO dao = new UserDAO();

    public User login(String username, String password) {
        if (dao.validateLogin(username, password)) {
            return dao.findByUsername(username);
        }
        return null;
    }

    public boolean validate(String username, String password) {
        return dao.validateLogin(username, password);
    }
}