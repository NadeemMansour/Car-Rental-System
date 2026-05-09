package ui.auth;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField roleField;

    private UserController userController = new UserController();

    public RegisterFrame() {

        setTitle("Register - Car Rental System");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        createLeftPanel();
        createRightPanel();

        setVisible(true);
    }

    private void createLeftPanel() {

        JPanel left = new JPanel();
        left.setBounds(0, 0, 350, 500);
        left.setBackground(new Color(20, 20, 20));
        left.setLayout(null);

        JLabel title = new JLabel("Create Account");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(80, 180, 250, 30);

        left.add(title);

        add(left);
    }

    private void createRightPanel() {

        JPanel right = new JPanel();
        right.setBounds(350, 0, 550, 500);
        right.setLayout(null);
        right.setBackground(Color.WHITE);

        JLabel title = new JLabel("Register");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(230, 60, 200, 30);

        usernameField = new JTextField();
        usernameField.setBounds(150, 130, 250, 35);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 180, 250, 35);

        roleField = new JTextField("EMPLOYEE");
        roleField.setBounds(150, 230, 250, 35);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(150, 290, 250, 40);
        registerBtn.setBackground(new Color(50, 50, 50));
        registerBtn.setForeground(Color.WHITE);

        JButton backBtn = new JButton("Back to Login");
        backBtn.setBounds(150, 340, 250, 30);

        registerBtn.addActionListener(e -> register());
        backBtn.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });

        right.add(title);
        right.add(usernameField);
        right.add(passwordField);
        right.add(roleField);
        right.add(registerBtn);
        right.add(backBtn);

        add(right);
    }

    private void register() {

        User user = new User();
        user.setUsername(usernameField.getText());
        user.setPassword(new String(passwordField.getPassword()));
        user.setRole(roleField.getText());
        user.setStatus("ACTIVE");

        userController.register(user);

        JOptionPane.showMessageDialog(this, "Account Created Successfully");

        dispose();
        new LoginFrame().setVisible(true);
    }
    
}