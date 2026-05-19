package view;

import controller.LoginController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LoginScreen extends JFrame {

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel imageLabel;

    private JLabel titleLabel;
    private JLabel subTitleLabel;
    private JLabel loginLabel;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheck;

    private JButton loginButton;
    private final LoginController loginController = new LoginController();

    public LoginScreen() {
        initializeFrame();
        initializeLeftPanel();

        initializeRightPanel();
        setVisible(true);
    }

    // FRAME
    private void initializeFrame() {

        setTitle("Car Rental System");
        ImageIcon icon = new ImageIcon("src/image/LeftIcon.png");
        setIconImage(icon.getImage());
        setSize(1300, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
    }

    // LEFT PANEL
    private void initializeLeftPanel() {

        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 650, 760);
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.BLACK);

        ImageIcon imageIcon = new ImageIcon("src/image/lll.png");
        Image image = imageIcon.getImage().getScaledInstance(650, 760, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0, 0, 650, 760);

        titleLabel = new JLabel("Car Rental System");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
        titleLabel.setBounds(110, 70, 450, 50);

        subTitleLabel = new JLabel("Luxury Car Rental");
        subTitleLabel.setForeground(new Color(220, 220, 220));
        subTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        subTitleLabel.setBounds(150, 125, 350, 35);

        leftPanel.add(titleLabel);
        leftPanel.add(subTitleLabel);
        leftPanel.add(imageLabel);

        add(leftPanel);
    }

    // RIGHT PANEL
    // =========================
    private void initializeRightPanel() {

        rightPanel = new JPanel();
        rightPanel.setBounds(650, 0, 650, 760);
        rightPanel.setBackground(new Color(12, 17, 33));
        rightPanel.setLayout(null);

        loginLabel = new JLabel("Welcome Back");
        loginLabel.setForeground(new Color(255, 215, 0));
        loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));
        loginLabel.setBounds(120, 110, 400, 50);

        JPanel line = new JPanel();
        line.setBackground(new Color(255, 215, 0));
        line.setBounds(120, 180, 250, 4);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        usernameLabel.setBounds(140, 260, 150, 30);

        usernameField = new JTextField();
        usernameField.setBounds(140, 300, 380, 55);
        usernameField.setBackground(new Color(22, 30, 50));
        usernameField.setForeground(Color.WHITE);
        usernameField.setCaretColor(Color.WHITE);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        usernameField.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        passwordLabel.setBounds(140, 390, 150, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 430, 380, 55);
        passwordField.setBackground(new Color(22, 30, 50));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        passwordField.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        showPasswordCheck = new JCheckBox("Show Password");
        showPasswordCheck.setBounds(140, 510, 180, 30);
        showPasswordCheck.setForeground(Color.WHITE);
        showPasswordCheck.setBackground(new Color(12, 17, 33));
        showPasswordCheck.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        showPasswordCheck.addActionListener(e -> {
            if (showPasswordCheck.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(140, 610, 380, 60);
        loginButton.setBackground(new Color(0, 191, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 22));
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(e -> login());

        rightPanel.add(loginLabel);
        rightPanel.add(line);
        rightPanel.add(usernameLabel);
        rightPanel.add(usernameField);
        rightPanel.add(passwordLabel);
        rightPanel.add(passwordField);
        rightPanel.add(showPasswordCheck);
        rightPanel.add(loginButton);

        add(rightPanel);
    }

    // LOGIN
    // ***********************
    private void login() {

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        String result = loginController.login(username, password);

        if (result.equals("Login Successful")) {
            dispose();
            new Dashboard().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username Or Password");
        }
    }
}