package ui.auth;

import ui.main.MainFrame;
import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private final UserController userController = new UserController();

    public LoginFrame() {

        setTitle("Login - Car Rental System");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        createLeftPanel();
        createRightPanel();

        setVisible(true);
    }

    // 🎨 Left Panel
    private void createLeftPanel() {

        JPanel left = new JPanel();
        left.setBounds(0, 0, 350, 500);
        left.setBackground(new Color(30, 30, 30));
        left.setLayout(null);

        JLabel title = new JLabel("Car Rental System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(70, 150, 250, 30);

        JLabel subtitle = new JLabel("Enterprise Management");
        subtitle.setForeground(Color.GRAY);
        subtitle.setBounds(80, 190, 250, 20);

        left.add(title);
        left.add(subtitle);

        add(left);
    }

    // 📋 Right Panel
    private void createRightPanel() {

        JPanel right = new JPanel();
        right.setBounds(350, 0, 550, 500);
        right.setLayout(null);
        right.setBackground(Color.WHITE);

        JLabel loginTitle = new JLabel("Login");
        loginTitle.setFont(new Font("Arial", Font.BOLD, 24));
        loginTitle.setBounds(230, 60, 200, 30);

        usernameField = new JTextField();
        usernameField.setBounds(150, 140, 250, 35);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 200, 250, 35);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 270, 250, 40);
        loginBtn.setBackground(new Color(40, 40, 40));
        loginBtn.setForeground(Color.WHITE);

        JButton registerBtn = new JButton("Create Account");
        registerBtn.setBounds(150, 320, 250, 30);

        // 🔐 Login Action
        loginBtn.addActionListener(e -> login());

        // ➕ Register
        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterFrame().setVisible(true);
        });

        right.add(loginTitle);
        right.add(usernameField);
        right.add(passwordField);
        right.add(loginBtn);
        right.add(registerBtn);

        add(right);
    }

    // 🔐 LOGIN LOGIC (FIXED)
    private void login() {

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username and password");
            return;
        }

        boolean valid = userController.login(username, password);

        if (valid) {

            JOptionPane.showMessageDialog(this, "Login Successful");

            dispose();
            new MainFrame();

        } else {

            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }
}
// package ui.auth;

// import ui.main.MainFrame;
// import controller.UserController;

// import javax.swing.*;
// import java.awt.*;

// public class LoginFrame extends JFrame {

// private JTextField usernameField;
// private JPasswordField passwordField;

// private UserController userController = new UserController();

// public LoginFrame() {

// setTitle("Login - Car Rental System");
// setSize(900, 500);
// setLocationRelativeTo(null);
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setLayout(null);

// createLeftPanel();
// createRightPanel();

// setVisible(true);
// }

// // 🎨 Left Branding Panel
// private void createLeftPanel() {

// JPanel left = new JPanel();
// left.setBounds(0, 0, 350, 500);
// left.setBackground(new Color(30, 30, 30));
// left.setLayout(null);

// JLabel title = new JLabel("Car Rental System");
// title.setForeground(Color.WHITE);
// title.setFont(new Font("Arial", Font.BOLD, 18));
// title.setBounds(70, 150, 250, 30);

// JLabel subtitle = new JLabel("Enterprise Management");
// subtitle.setForeground(Color.GRAY);
// subtitle.setBounds(80, 190, 250, 20);

// left.add(title);
// left.add(subtitle);

// add(left);
// }

// // 📋 Right Login Form
// private void createRightPanel() {

// JPanel right = new JPanel();
// right.setBounds(350, 0, 550, 500);
// right.setLayout(null);
// right.setBackground(Color.WHITE);

// JLabel loginTitle = new JLabel("Login");
// loginTitle.setFont(new Font("Arial", Font.BOLD, 24));
// loginTitle.setBounds(230, 60, 200, 30);

// usernameField = new JTextField();
// usernameField.setBounds(150, 140, 250, 35);

// passwordField = new JPasswordField();
// passwordField.setBounds(150, 200, 250, 35);

// JButton loginBtn = new JButton("Login");
// loginBtn.setBounds(150, 270, 250, 40);
// loginBtn.setBackground(new Color(40, 40, 40));
// loginBtn.setForeground(Color.WHITE);

// JButton registerBtn = new JButton("Create Account");
// registerBtn.setBounds(150, 320, 250, 30);

// // 🔐 Login Action
// loginBtn.addActionListener(e -> login());

// // ➕ Go Register
// registerBtn.addActionListener(e -> {
// dispose();
// new RegisterFrame().setVisible(true);
// });

// right.add(loginTitle);
// right.add(usernameField);
// right.add(passwordField);
// right.add(loginBtn);
// right.add(registerBtn);

// add(right);
// }

// // 🔐 Login Logic
// private void login() {

// String username = usernameField.getText();
// String password = new String(passwordField.getPassword());

// boolean valid = userController.login(username, password);

// if (valid) {

// JOptionPane.showMessageDialog(this, "Login Successful");

// dispose();
// new MainFrame();

// } else {
// JOptionPane.showMessageDialog(this, "Invalid Credentials");
// }
// }

// }