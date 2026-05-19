package view;

import controller.MaintenanceController;
import model.Maintenance;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class MaintenanceUI extends JFrame {

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel titleLabel;

    private JLabel carIdLabel;
    private JLabel serviceDateLabel;
    private JLabel descriptionLabel;
    private JLabel costLabel;

    private JTextField carIdField;
    private JTextField serviceDateField;
    private JTextField descriptionField;
    private JTextField costField;

    private JButton addMaintenanceButton;
    private JButton updateMaintenanceButton;
    private JButton deleteMaintenanceButton;
    private JButton loadMaintenanceButton;
    private JButton clearFieldsButton;
    private JButton backButton;

    private JTextArea maintenanceTextArea;

    private final MaintenanceController maintenanceController = new MaintenanceController();

    public MaintenanceUI() {
        initializeFrame();
        initializeLeftPanel();

        initializeRightPanel();
        initializeActions();
        setVisible(true);
    }

    // FRAME
    // =========================
    private void initializeFrame() {

        setTitle("Maintenance Management");
        ImageIcon icon = new ImageIcon("src/LocalIcon.png");
        setIconImage(icon.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
    }

    // LEFT PANEL
    // =========================
    private void initializeLeftPanel() {

        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 500, 900);
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.BLACK);

        ImageIcon imageIcon = new ImageIcon("src/image/LeftIcon.png");
        Image image = imageIcon.getImage().getScaledInstance(500, 900, Image.SCALE_SMOOTH);

        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0, 0, 500, 900);

        JPanel overlayPanel = new JPanel();
        overlayPanel.setBounds(0, 0, 500, 900);
        overlayPanel.setBackground(new Color(0, 0, 0, 150));
        overlayPanel.setLayout(null);

        JLabel systemTitleLabel = new JLabel("Car Rental System");
        systemTitleLabel.setForeground(Color.WHITE);
        systemTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        systemTitleLabel.setBounds(55, 60, 380, 45);

        JLabel subTitleLabel = new JLabel("Luxury Maintenance Center");
        subTitleLabel.setForeground(new Color(220, 220, 220));
        subTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        subTitleLabel.setBounds(70, 115, 320, 30);

        JLabel quoteLabel = new JLabel("\"Drive Safe, Drive Luxury\"");
        quoteLabel.setForeground(new Color(255, 215, 0));
        quoteLabel.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        quoteLabel.setBounds(85, 170, 300, 30);

        JButton carsButton = createLeftButton("Cars");
        carsButton.setBounds(100, 300, 280, 48);

        JButton rentalsButton = createLeftButton("Rentals");
        rentalsButton.setBounds(100, 380, 280, 48);

        JButton reportsButton = createLeftButton("Reports");
        reportsButton.setBounds(100, 460, 280, 48);

        carsButton.addActionListener(e -> {
            new CarManagementUI().setVisible(true);
            this.dispose();
        });

        rentalsButton.addActionListener(e -> {
            new RentalForm().setVisible(true);
            this.dispose();
        });

        reportsButton.addActionListener(e -> {
            new ReportsUI().setVisible(true);
            this.dispose();
        });

        JLabel footerLabel = new JLabel("Version 1.0");
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        footerLabel.setBounds(195, 780, 120, 20);

        overlayPanel.add(systemTitleLabel);
        overlayPanel.add(subTitleLabel);
        overlayPanel.add(quoteLabel);

        overlayPanel.add(carsButton);
        overlayPanel.add(rentalsButton);
        overlayPanel.add(reportsButton);

        overlayPanel.add(footerLabel);
        leftPanel.add(overlayPanel);
        leftPanel.add(imageLabel);

        add(leftPanel);
    }

    // RIGHT PANEL
    // =========================
    private void initializeRightPanel() {

        rightPanel = new JPanel();
        rightPanel.setBounds(500, 0, 900, 900);
        rightPanel.setBackground(new Color(12, 17, 33));
        rightPanel.setLayout(null);

        titleLabel = new JLabel("Maintenance Management");
        titleLabel.setForeground(new Color(255, 215, 0));
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 34));
        titleLabel.setBounds(180, 30, 500, 40);

        JPanel titleLine = new JPanel();
        titleLine.setBackground(new Color(255, 215, 0));
        titleLine.setBounds(180, 82, 320, 4);

        carIdLabel = createLabel("Car ID", 150);

        serviceDateLabel = createLabel("Service Date", 240);

        descriptionLabel = createLabel("Description", 330);

        costLabel = createLabel("Cost", 420);

        carIdField = createTextField(150);

        serviceDateField = createTextField(240);

        descriptionField = createTextField(330);

        costField = createTextField(420);

        serviceDateField.setText("2026-01-01");

        addMaintenanceButton = createPrimaryButton("Add", 60, 560);

        updateMaintenanceButton = createSecondaryButton("Update", 260, 560);

        deleteMaintenanceButton = createSecondaryButton("Delete", 460, 560);

        loadMaintenanceButton = createSecondaryButton("Load", 660, 560);

        clearFieldsButton = createSecondaryButton("Clear", 260, 640);

        backButton = createBackButton();

        rightPanel.add(titleLabel);
        rightPanel.add(titleLine);
        rightPanel.add(carIdLabel);

        rightPanel.add(serviceDateLabel);
        rightPanel.add(descriptionLabel);
        rightPanel.add(costLabel);

        rightPanel.add(carIdField);
        rightPanel.add(serviceDateField);
        rightPanel.add(descriptionField);

        rightPanel.add(costField);
        rightPanel.add(addMaintenanceButton);
        rightPanel.add(updateMaintenanceButton);

        rightPanel.add(deleteMaintenanceButton);
        rightPanel.add(loadMaintenanceButton);
        rightPanel.add(clearFieldsButton);

        rightPanel.add(backButton);

        add(rightPanel);
    }

    // LABEL
    // =========================
    private JLabel createLabel(String text, int y) {

        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 17));
        label.setBounds(40, y, 180, 30);

        return label;
    }

    // TEXT FIELD
    // =========================
    private JTextField createTextField(int y) {

        JTextField textField = new JTextField();
        textField.setBounds(240, y, 560, 50);
        textField.setBackground(new Color(22, 30, 50));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        return textField;
    }

    // LEFT BUTTON
    // =========================
    private JButton createLeftButton(String text) {

        JButton button = new JButton(text);
        button.setBackground(new Color(22, 30, 50));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 17));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        return button;
    }

    // PRIMARY BUTTON
    // =========================
    private JButton createPrimaryButton(String text, int x, int y) {

        JButton button = new JButton(text);
        button.setBounds(x, y, 160, 50);
        button.setBackground(new Color(0, 191, 255));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    // SECONDARY BUTTON
    // =========================
    private JButton createSecondaryButton(String text, int x, int y) {

        JButton button = new JButton(text);
        button.setBounds(x, y, 160, 50);
        button.setBackground(new Color(22, 30, 50));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        return button;
    }

    // BACK BUTTON
    // =========================
    private JButton createBackButton() {

        JButton button = new JButton("Back");
        button.setBounds(460, 640, 160, 50);
        button.setBackground(new Color(255, 140, 0));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    // ACTIONS
    // =========================
    private void initializeActions() {

        addMaintenanceButton.addActionListener(e -> addMaintenance());

        updateMaintenanceButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Update Feature Coming Soon"));

        deleteMaintenanceButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Delete Feature Coming Soon"));

        loadMaintenanceButton.addActionListener(e -> loadMaintenance());

        clearFieldsButton.addActionListener(e -> clearFields());

        backButton.addActionListener(e -> {

            new Dashboard().setVisible(true);
            this.dispose();
        });
    }

    // ADD MAINTENANCE
    // =========================
    private void addMaintenance() {

        Maintenance maintenance = new Maintenance();

        maintenance.setCarId(Integer.parseInt(carIdField.getText()));
        maintenance.setServiceDate(LocalDate.parse(serviceDateField.getText()));
        maintenance.setDescription(descriptionField.getText());
        maintenance.setCost(Double.parseDouble(costField.getText()));

        String result = maintenanceController.addMaintenance(maintenance);

        JOptionPane.showMessageDialog(this, result);
        loadMaintenance();
    }

    // LOAD MAINTENANCE
    // =========================
    private void loadMaintenance() {

        List<Maintenance> maintenanceList = maintenanceController.getAllMaintenance();

        maintenanceTextArea.setText("");
        for (Maintenance maintenance : maintenanceList) {
            maintenanceTextArea.append(
                    "Maintenance ID : "
                            + maintenance.getMaintenanceId()
                            + " | Car ID : "
                            + maintenance.getCarId()
                            + " | Cost : "
                            + maintenance.getCost()
                            + " | Description : "
                            + maintenance.getDescription()
                            + "\n");
        }
    }

    // CLEAR FIELDS
    // =========================
    private void clearFields() {
        carIdField.setText("");
        serviceDateField.setText("");
        descriptionField.setText("");
        costField.setText("");
    }
}