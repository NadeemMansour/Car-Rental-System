package ui.user;

import controller.UserController;
import model.User;

import javax.swing.*;


public class UserFormDialog extends JDialog {

    private JTextField usernameField;
    private JTextField fullNameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;
    private JComboBox<String> statusBox;

    private UserController controller = new UserController();

    public UserFormDialog(JFrame parent) {

        super(parent, "User Form", true);

        setSize(420, 350);
        setLocationRelativeTo(parent);
        setLayout(null);

        createForm();

        setVisible(true);
    }

    private void createForm() {

        JLabel usernameLbl = new JLabel("Username:");
        usernameLbl.setBounds(30, 30, 120, 25);

        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 200, 25);

        JLabel nameLbl = new JLabel("Full Name:");
        nameLbl.setBounds(30, 70, 120, 25);

        fullNameField = new JTextField();
        fullNameField.setBounds(150, 70, 200, 25);

        JLabel passLbl = new JLabel("Password:");
        passLbl.setBounds(30, 110, 120, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 200, 25);

        JLabel roleLbl = new JLabel("Role:");
        roleLbl.setBounds(30, 150, 120, 25);

        roleBox = new JComboBox<>(new String[]{"ADMIN", "EMPLOYEE"});
        roleBox.setBounds(150, 150, 200, 25);

        JLabel statusLbl = new JLabel("Status:");
        statusLbl.setBounds(30, 190, 120, 25);

        statusBox = new JComboBox<>(new String[]{"ACTIVE", "INACTIVE"});
        statusBox.setBounds(150, 190, 200, 25);

        JButton saveBtn = new JButton("Save User");
        saveBtn.setBounds(150, 240, 150, 35);

        saveBtn.addActionListener(e -> saveUser());

        add(usernameLbl);
        add(usernameField);
        add(nameLbl);
        add(fullNameField);
        add(passLbl);
        add(passwordField);
        add(roleLbl);
        add(roleBox);
        add(statusLbl);
        add(statusBox);
        add(saveBtn);
    }

    private void saveUser() {

        User u = new User();

        u.setUsername(usernameField.getText());
        u.setFullName(fullNameField.getText());
        u.setPassword(new String(passwordField.getPassword()));
        u.setRole(roleBox.getSelectedItem().toString());
        u.setStatus(statusBox.getSelectedItem().toString());

        controller.addUser(u);

        JOptionPane.showMessageDialog(this, "User Saved Successfully");

        dispose();
    }
}