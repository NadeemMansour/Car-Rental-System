package service;

import dao.UserDAO;
import model.User;

public class AuthService {

    private final UserDAO dao = new UserDAO();

    //  LOGIN (الطريقة الصحيحة)
    // يرجع User إذا نجح تسجيل الدخول، وإلا null
    public User login(String username, String password) {

        //  Validation أولي
        if (username == null || password == null
                || username.isBlank() || password.isBlank()) {
            return null;
        }

        //  استعلام واحد فقط من قاعدة البيانات
        return dao.login(username.trim(), password.trim());
    }

    //  التحقق (اختياري للاستخدام في UI)
    public boolean validate(String username, String password) {

        if (username == null || password == null
                || username.isBlank() || password.isBlank()) {
            return false;
        }

        User user = dao.login(username.trim(), password.trim());
        return user != null;
    }
}