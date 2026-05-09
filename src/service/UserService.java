package service;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    // ➕ إضافة مستخدم
    public void addUser(User user) {

        if (user == null) return;

        userDAO.insert(user);
    }

    // ✏️ تحديث مستخدم
    public void updateUser(User user) {

        if (user == null || user.getUserId() <= 0) return;

        userDAO.update(user);
    }

    // ❌ حذف مستخدم
    public void deleteUser(int userId) {

        if (userId <= 0) return;

        userDAO.delete(userId);
    }

    // 🔍 جلب مستخدم حسب ID
    public User getUserById(int id) {
        return userDAO.findById(id);
    }

    // 📋 جميع المستخدمين
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    // 🔎 البحث باسم المستخدم
    public User getByUsername(String username) {

        if (username == null || username.isEmpty()) return null;

        return userDAO.findByUsername(username);
    }

    // 🔐 التحقق من تسجيل الدخول
    public boolean validateLogin(String username, String password) {

        if (username == null || password == null) return false;

        return userDAO.validateLogin(username, password);
    }
}