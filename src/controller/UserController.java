package controller;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    // LOGIN

    public User login(String username, String password) {

        User user = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM User WHERE Username=? AND Password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, username);

            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setUserId(
                        rs.getInt("User_ID")
                );

                user.setUsername(
                        rs.getString("Username")
                );

                user.setPassword(
                        rs.getString("Password")
                );

                user.setFullName(
                        rs.getString("Full_Name")
                );

                user.setRole(
                        rs.getString("Role")
                );

                user.setStatus(
                        rs.getString("Status")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }

    // REGISTER

    public boolean register(User user) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO User "
                            + "(Username, Password, Full_Name, Role, Status) "
                            + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,
                    user.getUsername());

            ps.setString(2,
                    user.getPassword());

            ps.setString(3,
                    user.getFullName());

            ps.setString(4,
                    user.getRole());

            ps.setString(5,
                    user.getStatus());

            int rows =
                    ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
    // GET ALL USERS

public List<User> getAllUsers() {

    List<User> users = new ArrayList<>();

    try {

        Connection con =
                DBConnection.getConnection();

        String sql =
                "SELECT * FROM User";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            User user = new User();

            user.setUserId(
                    rs.getInt("User_ID")
            );

            user.setUsername(
                    rs.getString("Username")
            );

            user.setPassword(
                    rs.getString("Password")
            );

            user.setFullName(
                    rs.getString("Full_Name")
            );

            user.setRole(
                    rs.getString("Role")
            );

            user.setStatus(
                    rs.getString("Status")
            );

            users.add(user);
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return users;
}
}

// package controller;

// import model.User;
// import service.UserService;

// import java.util.List;

// public class UserController {

//     private final UserService userService = new UserService();

//     // Login يرجع User بدل boolean (مهم جدًا)
//     public User login(String username, String password) {

//         if (username == null || password == null
//                 || username.isBlank() || password.isBlank()) {
//             return null;
//         }

//         return userService.login(username.trim(), password.trim());
//     }

//     // إضافة مستخدم
//     public String addUser(User user) {

//         if (user == null)
//             return "Invalid User";

//         userService.addUser(user);
//         return "User Added Successfully";
//     }

//     // تحديث
//     public String updateUser(User user) {

//         if (user == null || user.getUserId() <= 0)
//             return "Invalid User";

//         userService.updateUser(user);
//         return "User Updated Successfully";
//     }

//     // حذف
//     public String deleteUser(int id) {

//         if (id <= 0)
//             return "Invalid ID";

//         userService.deleteUser(id);
//         return "User Deleted";
//     }

//     public User getById(int id) {
//         return userService.getUserById(id);
//     }

//     public List<User> getAll() {
//         return userService.getAllUsers();
//     }

//     public boolean register(User user) {

//         if (user == null ||
//                 user.getUsername() == null ||
//                 user.getPassword() == null) {
//             return false;
//         }

//         userService.addUser(user);
//         return true;
//     }
//     public List<User> getAllUsers() {
//     return userService.getAllUsers();
// }
// }
