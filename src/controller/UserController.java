package controller;

import model.User;
import service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService;

    // 🔥 Dependency Injection (أفضل من إنشاء object مباشرة)
    public UserController() {
        this.userService = new UserService();
    }

    // =========================
    // 🔐 AUTHENTICATION
    // =========================

    public boolean login(String username, String password) {

        if (isInvalidCredentials(username, password)) {
            return false;
        }

        return userService.validateLogin(username.trim(), password.trim());
    }

    private boolean isInvalidCredentials(String username, String password) {
        return username == null || password == null
                || username.isBlank()
                || password.isBlank();
    }

    // =========================
    // 👤 USER MANAGEMENT
    // =========================

    public String addUser(User user) {

        if (user == null || !isValidUser(user)) {
            return "Invalid User Data";
        }

        userService.addUser(user);
        return "User Added Successfully";
    }

    public String updateUser(User user) {

        if (user == null || user.getUserId() <= 0) {
            return "Invalid User Data";
        }

        userService.updateUser(user);
        return "User Updated Successfully";
    }

    public String deleteUser(int userId) {

        if (userId <= 0) {
            return "Invalid User ID";
        }

        userService.deleteUser(userId);
        return "User Deleted Successfully";
    }

    // =========================
    // 🔍 QUERIES
    // =========================

    public User getUserById(int userId) {
        return userService.getUserById(userId);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public User getByUsername(String username) {

        if (username == null || username.isBlank()) {
            return null;
        }

        return userService.getByUsername(username.trim());
    }

    // =========================
    // ⚙️ STATUS CONTROL
    // =========================

    public String changeStatus(int userId, String status) {

        if (userId <= 0 || status == null || status.isBlank()) {
            return "Invalid Data";
        }

        User user = userService.getUserById(userId);

        if (user == null) {
            return "User Not Found";
        }

        user.setStatus(status);
        userService.updateUser(user);

        return "User Status Updated";
    }

    // =========================
    // 🧠 VALIDATION (clean helper)
    // =========================

    private boolean isValidUser(User user) {
        return user.getUsername() != null && !user.getUsername().isBlank()
                && user.getPassword() != null && !user.getPassword().isBlank();
    }
    public String register(User user) {

    if (user == null
            || user.getUsername() == null
            || user.getPassword() == null) {
        return "Invalid User Data";
    }

    return addUser(user);
}
}

// package controller;

// import model.User;
// import service.UserService;

// import java.util.List;

// public class UserController {

//     private UserService userService = new UserService();

//     // ➕ إضافة مستخدم جديد
//     public String addUser(User user) {

//         if (user == null || user.getUsername() == null || user.getPassword() == null) {
//             return "Invalid User Data";
//         }

//         userService.addUser(user);
//         return "User Added Successfully";
//     }

//     // ✏️ تحديث مستخدم
//     public String updateUser(User user) {

//         if (user == null || user.getUserId() <= 0) {
//             return "Invalid User Data";
//         }

//         userService.updateUser(user);
//         return "User Updated Successfully";
//     }

//     // ❌ حذف مستخدم
//     public String deleteUser(int userId) {

//         if (userId <= 0) {
//             return "Invalid User ID";
//         }

//         userService.deleteUser(userId);
//         return "User Deleted Successfully";
//     }

//     // 🔍 جلب مستخدم حسب ID
//     public User getUserById(int userId) {
//         return userService.getUserById(userId);
//     }

//     // 📋 جلب جميع المستخدمين
//     public List<User> getAllUsers() {
//         return userService.getAllUsers();
//     }

//     // 🔎 البحث باسم المستخدم
//     public User getByUsername(String username) {

//         if (username == null || username.isEmpty()) {
//             return null;
//         }

//         return userService.getByUsername(username);
//     }

//     // 🔐 التحقق من تسجيل الدخول
//     public boolean validateLogin(String username, String password) {

//         if (username == null || password == null) {
//             return false;
//         }

//         return userService.validateLogin(username, password);
//     }

//     //  تغيير حالة المستخدم (Active / Inactive)
//     public String changeStatus(int userId, String status) {

//         User user = userService.getUserById(userId);

//         if (user == null) {
//             return "User Not Found";
//         }

//         user.setStatus(status);
//         userService.updateUser(user);

//         return "User Status Updated";
//     }
// }