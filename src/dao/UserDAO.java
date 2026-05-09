package dao;

import model.User;
import java.util.List;

public class UserDAO {

    public void insert(User user) {}
    public void update(User user) {}
    public void delete(int userId) {}

    public User findById(int id) { return null; }

    public User findByUsername(String username) { return null; }

    public List<User> findAll() { return null; }

    public boolean validateLogin(String username, String password) { return false; }
}