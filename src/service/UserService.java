package service;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO = new UserDAO();

    //  تسجيل الدخول الحقيقي (يرجع User وليس boolean)
    public User login(String username, String password) {

        if (username == null || password == null
                || username.isBlank() || password.isBlank()) {
            return null;
        }

        return userDAO.login(username.trim(), password.trim());
    }

    //  إضافة مستخدم
    public void addUser(User user) {

        if (user == null) return;

        userDAO.insert(user);
    }
    
    //  تحديث مستخدم
    public void updateUser(User user) {

        if (user == null || user.getUserId() <= 0) return;

        userDAO.update(user);
    }

    //  حذف مستخدم
    public void deleteUser(int userId) {

        if (userId <= 0) return;

        userDAO.delete(userId);
    }

    //  جلب حسب ID
    public User getUserById(int id) {
        return userDAO.findById(id);
    }

    //  جميع المستخدمين
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    //  البحث باسم المستخدم
    public User getByUsername(String username) {

        if (username == null || username.isBlank()) return null;

        return userDAO.findByUsername(username.trim());
    }
}