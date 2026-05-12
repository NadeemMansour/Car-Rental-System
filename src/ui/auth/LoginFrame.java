package ui.auth;

import ui.main.MainFrame;
import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;

    private JPasswordField passwordField;

    private final UserController userController =
            new UserController();

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

    private void createLeftPanel() {

        JPanel left = new JPanel();

        left.setBounds(0, 0, 350, 500);

        left.setBackground(new Color(30, 30, 30));

        left.setLayout(null);

        JLabel title =
                new JLabel("Car Rental System");

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        title.setBounds(70, 150, 250, 30);

        JLabel subtitle =
                new JLabel("Enterprise Management");

        subtitle.setForeground(Color.GRAY);

        subtitle.setBounds(80, 190, 250, 20);

        left.add(title);

        left.add(subtitle);

        add(left);
    }

    private void createRightPanel() {

        JPanel right = new JPanel();

        right.setBounds(350, 0, 550, 500);

        right.setLayout(null);

        right.setBackground(Color.WHITE);

        JLabel loginTitle =
                new JLabel("Login");

        loginTitle.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        loginTitle.setBounds(230, 60, 200, 30);

        usernameField = new JTextField();

        usernameField.setBounds(150, 140, 250, 35);

        passwordField = new JPasswordField();

        passwordField.setBounds(150, 200, 250, 35);

        JButton loginBtn =
                new JButton("Login");

        loginBtn.setBounds(150, 270, 250, 40);

        loginBtn.setBackground(
                new Color(40, 40, 40)
        );

        loginBtn.setForeground(Color.WHITE);

        JButton registerBtn =
                new JButton("Create Account");

        registerBtn.setBounds(150, 320, 250, 30);

        loginBtn.addActionListener(
                e -> login()
        );

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

    private void login() {

        String username =
                usernameField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                ).trim();

        if (username.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter username and password"
            );

            return;
        }

        User user =
                userController.login(
                        username,
                        password
                );

        if (user != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful\nWelcome "
                            + user.getUsername()
            );

            dispose();

            new MainFrame(user).setVisible(true);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Credentials"
            );
        }
    }
}
// package ui.auth;

// import ui.main.MainFrame;
// import controller.UserController;
// import model.User;

// import javax.swing.*;
// import java.awt.*;

// public class LoginFrame extends JFrame {

//     private JTextField usernameField;
//     private JPasswordField passwordField;

//     private final UserController userController = new UserController();

//     public LoginFrame() {

//         setTitle("Login - Car Rental System");
//         setSize(900, 500);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(null);

//         createLeftPanel();
//         createRightPanel();

//         setVisible(true);
//     }

//     private void createLeftPanel() {

//         JPanel left = new JPanel();
//         left.setBounds(0, 0, 350, 500);
//         left.setBackground(new Color(30, 30, 30));
//         left.setLayout(null);

//         JLabel title = new JLabel("Car Rental System");
//         title.setForeground(Color.WHITE);
//         title.setFont(new Font("Arial", Font.BOLD, 18));
//         title.setBounds(70, 150, 250, 30);

//         JLabel subtitle = new JLabel("Enterprise Management");
//         subtitle.setForeground(Color.GRAY);
//         subtitle.setBounds(80, 190, 250, 20);

//         left.add(title);
//         left.add(subtitle);

//         add(left);
//     }

//     private void createRightPanel() {

//         JPanel right = new JPanel();
//         right.setBounds(350, 0, 550, 500);
//         right.setLayout(null);
//         right.setBackground(Color.WHITE);

//         JLabel loginTitle = new JLabel("Login");
//         loginTitle.setFont(new Font("Arial", Font.BOLD, 24));
//         loginTitle.setBounds(230, 60, 200, 30);

//         usernameField = new JTextField();
//         usernameField.setBounds(150, 140, 250, 35);

//         passwordField = new JPasswordField();
//         passwordField.setBounds(150, 200, 250, 35);

//         JButton loginBtn = new JButton("Login");
//         loginBtn.setBounds(150, 270, 250, 40);
//         loginBtn.setBackground(new Color(40, 40, 40));
//         loginBtn.setForeground(Color.WHITE);

//         JButton registerBtn = new JButton("Create Account");
//         registerBtn.setBounds(150, 320, 250, 30);

//         loginBtn.addActionListener(e -> login());

//         registerBtn.addActionListener(e -> {
//             dispose();
//             new RegisterFrame().setVisible(true);
//         });

//         right.add(loginTitle);
//         right.add(usernameField);
//         right.add(passwordField);
//         right.add(loginBtn);
//         right.add(registerBtn);

//         add(right);
//     }

//     private void login() {

//         String username = usernameField.getText().trim();
//         String password = new String(passwordField.getPassword()).trim();

//         if (username.isEmpty() || password.isEmpty()) {
//             JOptionPane.showMessageDialog(this,
//                     "Please enter username and password");
//             return;
//         }


//         User user = userController.login(username, password);

//         if (user != null) {

//             JOptionPane.showMessageDialog(this,
//                     "Login Successful\nWelcome " + user.getUsername());

//             dispose();

//             new MainFrame(user).setVisible(true);

//         } else {

//             JOptionPane.showMessageDialog(this,
//                     "Invalid Credentials");
//         }
//     }
// }


