package view;

import controller.CustomerController;
import model.Customer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class CustomerForm extends JFrame {

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel titleLabel;

    private JLabel fullNameLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JLabel nationalIdLabel;
    private JLabel licenseNumberLabel;

    private JTextField fullNameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField nationalIdField;
    private JTextField licenseNumberField;

    private JButton addCustomerButton;
    private JButton updateCustomerButton;
    private JButton deleteCustomerButton;
    private JButton loadCustomersButton;
    private JButton backButton;

    private JTextArea customersTextArea;
    private JScrollPane customersScrollPane;

    private final CustomerController customerController = new CustomerController();

    public CustomerForm() {
        initializeFrame();
        initializeLeftPanel();

        initializeRightPanel();
        initializeActions();
        setVisible(true);
    }

    // FRAME
    // =========================
    private void initializeFrame() {

        setTitle("Customer Management");
        ImageIcon icon = new ImageIcon("src/LocalIcon.png");
        setIconImage(icon.getImage());
        setSize(1300, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
    }

    // LEFT PANEL
    // =========================
    private void initializeLeftPanel() {

        leftPanel = new JPanel();

        leftPanel.setBounds(0, 0, 550, getHeight());
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.BLACK);

        ImageIcon imageIcon = new ImageIcon("src/image/LeftIcon.png");
        Image image = imageIcon.getImage().getScaledInstance(520, 760, Image.SCALE_SMOOTH);

        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0, 0, 520, 760);

        JLabel leftTitleLabel = new JLabel("Customers");
        leftTitleLabel.setForeground(Color.WHITE);
        leftTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
        leftTitleLabel.setBounds(140, 40, 300, 40);

        leftPanel.add(leftTitleLabel);
        leftPanel.add(imageLabel);

        add(leftPanel);
    }

    // RIGHT PANEL
    // =========================
    private void initializeRightPanel() {

        rightPanel = new JPanel();
        rightPanel.setBounds(550, 0, 820, getHeight());
        rightPanel.setBackground(new Color(12, 17, 33));
        rightPanel.setLayout(null);

        titleLabel = new JLabel("Customer Management");
        titleLabel.setForeground(new Color(255, 215, 0));
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setBounds(160, 30, 450, 40);

        JPanel titleLine = new JPanel();
        titleLine.setBackground(new Color(255, 215, 0));
        titleLine.setBounds(160, 80, 300, 4);

        fullNameLabel = createLabel("Full Name", 130);

        phoneLabel = createLabel("Phone", 190);

        addressLabel = createLabel("Address", 250);

        nationalIdLabel = createLabel("National ID", 310);

        licenseNumberLabel = createLabel("License Number", 370);

        fullNameField = createTextField(130);

        phoneField = createTextField(190);

        addressField = createTextField(250);

        nationalIdField = createTextField(310);

        licenseNumberField = createTextField(370);

        addCustomerButton = createButton("Add", new Color(0, 191, 255), 40);

        updateCustomerButton = createButton("Update", new Color(22, 30, 50), 210);

        deleteCustomerButton = createButton("Delete", new Color(22, 30, 50), 380);

        loadCustomersButton = createButton("Customers", new Color(22, 30, 50), 550);

        backButton = createButton("Back", new Color(255, 140, 0), 295);

        customersTextArea = new JTextArea();

        customersTextArea.setBackground(new Color(20, 25, 45));
        customersTextArea.setForeground(Color.WHITE);
        customersTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        customersTextArea.setEditable(false);

        customersScrollPane = new JScrollPane(customersTextArea);
        customersScrollPane.setBounds(40, 610, 700, 90);
        customersScrollPane.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        rightPanel.add(titleLabel);
        rightPanel.add(titleLine);
        rightPanel.add(fullNameLabel);

        rightPanel.add(phoneLabel);
        rightPanel.add(addressLabel);
        rightPanel.add(nationalIdLabel);

        rightPanel.add(licenseNumberLabel);
        rightPanel.add(fullNameField);
        rightPanel.add(phoneField);

        rightPanel.add(addressField);
        rightPanel.add(nationalIdField);
        rightPanel.add(licenseNumberField);

        rightPanel.add(addCustomerButton);
        rightPanel.add(updateCustomerButton);
        rightPanel.add(deleteCustomerButton);

        rightPanel.add(loadCustomersButton);
        rightPanel.add(backButton);
        rightPanel.add(customersScrollPane);

        add(rightPanel);
    }

    // LABEL
    // =========================
    private JLabel createLabel(String text, int y) {

        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label.setBounds(40, y, 170, 30);
        return label;
    }

    // TEXT FIELD
    // =========================
    private JTextField createTextField(int y) {

        JTextField textField = new JTextField();
        textField.setBounds(220, y, 520, 42);
        textField.setBackground(new Color(22, 30, 50));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        return textField;
    }

    // BUTTON
    // =========================
    private JButton createButton(String text, Color color, int x) {

        JButton button = new JButton(text);
        button.setBounds(x, 540, 140, 45);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));

        if (!text.equals("Add") && !text.equals("Back")) {
            button.setBackground(new Color(22, 30, 50));
            button.setBorder(new LineBorder(new Color(0, 191, 255), 2));
        } else {
            button.setBorderPainted(false);
        }

        return button;
    }

    // ACTIONS
    // =========================
    private void initializeActions() {

        addCustomerButton.addActionListener(e -> addCustomer());
        updateCustomerButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Update Feature Coming Soon"));
        deleteCustomerButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Delete Feature Coming Soon"));
        loadCustomersButton.addActionListener(e -> loadCustomers());
        backButton.addActionListener(e -> { new Dashboard().setVisible(true); this.dispose(); });
    }

    // ADD CUSTOMER
    // =========================
    private void addCustomer() {

        Customer customer = new Customer();
        customer.setFullName(fullNameField.getText());
        customer.setPhone(phoneField.getText());
        customer.setAddress(addressField.getText());
        customer.setNationalId(nationalIdField.getText());
        customer.setLicenseNumber(licenseNumberField.getText());

        String result = customerController.addCustomer(customer);
        JOptionPane.showMessageDialog(this, result);
        loadCustomers();
    }

    // LOAD CUSTOMERS
    // =========================
    private void loadCustomers() {

        List<Customer> customers = customerController.getAllCustomers();
        customersTextArea.setText("");

        for (Customer customer : customers) {
            customersTextArea.append(
                    "ID : "
                    + customer.getCustomerId()
                    + " | Name : "
                    + customer.getFullName()
                    + " | Phone : "
                    + customer.getPhone()
                    + " | National ID : "
                    + customer.getNationalId()
                    + "\n"
            );
        }
    }
}