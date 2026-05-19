package view;

import controller.PaymentController;
import model.Payment;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class PaymentUI extends JFrame {

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel titleLabel;

    private JLabel rentalIdLabel;
    private JLabel amountLabel;
    private JLabel paymentDateLabel;
    private JLabel paymentMethodLabel;

    private JTextField rentalIdField;
    private JTextField amountField;
    private JTextField paymentDateField;
    private JTextField paymentMethodField;

    private JButton processPaymentButton;
    private JButton updatePaymentButton;
    private JButton deletePaymentButton;
    private JButton loadPaymentsButton;
    private JButton printReceiptButton;
    private JButton clearFieldsButton;
    private JButton backButton;

    private JTextArea paymentsTextArea;

    private JScrollPane paymentsScrollPane;

    private final PaymentController paymentController = new PaymentController();

    public PaymentUI() {
        initializeFrame();

        initializeLeftPanel();
        initializeRightPanel();

        initializeActions();
        setVisible(true);
    }

    // FRAME
    // =========================
    private void initializeFrame() {

        setTitle("Payment Management");
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
        leftPanel.setBounds(0, 0, 520, 760);
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.BLACK);

        ImageIcon imageIcon = new ImageIcon("src/image/LeftIcon.png");
        Image image = imageIcon.getImage().getScaledInstance(520, 760, Image.SCALE_SMOOTH);

        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0, 0, 520, 760);

        JLabel leftTitleLabel = new JLabel("Payments");
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
        rightPanel.setBounds(520, 0, 780, 760);
        rightPanel.setBackground(new Color(12, 17, 33));
        rightPanel.setLayout(null);

        titleLabel = new JLabel("Payment Management");
        titleLabel.setForeground(new Color(255, 215, 0));
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setBounds(160, 30, 450, 40);

        JPanel titleLine = new JPanel();
        titleLine.setBackground(new Color(255, 215, 0));
        titleLine.setBounds(160, 80, 300, 4);

        rentalIdLabel = createLabel("Rental ID", 150);

        amountLabel = createLabel("Amount", 220);

        paymentDateLabel = createLabel("Payment Date", 290);

        paymentMethodLabel = createLabel("Payment Method", 360);

        rentalIdField = createTextField(150);

        amountField = createTextField(220);

        paymentDateField = createTextField(290);

        paymentMethodField = createTextField(360);

        paymentDateField.setText("2026-01-01");

        processPaymentButton = createButton("Process", new Color(0, 191, 255), 40, 500);

        updatePaymentButton = createButton("Update", new Color(22, 30, 50), 210, 500);

        deletePaymentButton = createButton("Delete", new Color(22, 30, 50), 380, 500);

        loadPaymentsButton = createButton("Payments", new Color(22, 30, 50), 550, 500);

        printReceiptButton = createButton("Receipt", new Color(22, 30, 50), 170, 560);

        clearFieldsButton = createButton("Clear", new Color(22, 30, 50), 340, 560);

        backButton = createButton("Back", new Color(255, 140, 0), 510, 560);

        paymentsTextArea = new JTextArea();
        paymentsTextArea.setBackground(new Color(20, 25, 45));
        paymentsTextArea.setForeground(Color.WHITE);
        paymentsTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        paymentsTextArea.setEditable(false);

        paymentsScrollPane = new JScrollPane(paymentsTextArea);
        paymentsScrollPane.setBounds(40, 630, 700, 70);
        paymentsScrollPane.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        rightPanel.add(titleLabel);
        rightPanel.add(titleLine);
        rightPanel.add(rentalIdLabel);
        rightPanel.add(amountLabel);
        rightPanel.add(paymentDateLabel);
        rightPanel.add(paymentMethodLabel);
        rightPanel.add(rentalIdField);
        rightPanel.add(amountField);
        rightPanel.add(paymentDateField);
        rightPanel.add(paymentMethodField);
        rightPanel.add(processPaymentButton);
        rightPanel.add(updatePaymentButton);
        rightPanel.add(deletePaymentButton);
        rightPanel.add(loadPaymentsButton);
        rightPanel.add(printReceiptButton);
        rightPanel.add(clearFieldsButton);
        rightPanel.add(backButton);
        rightPanel.add(paymentsScrollPane);

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

    JTextField field = new JTextField();

    field.setBounds(270, y, 760, 48);

    field.setBackground(new Color(18, 25, 45));

    field.setForeground(Color.WHITE);

    field.setCaretColor(Color.WHITE);

    field.setFont(new Font("Segoe UI", Font.PLAIN, 16));

    field.setBorder(
            new LineBorder(new Color(0, 191, 255), 2)
    );

    return field;
}

    // BUTTON
    // =========================
    private JButton createButton(String text, Color color, int x, int y) {

        JButton button = new JButton(text);
        button.setBounds(x, y, 140, 45);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));

        if (!text.equals("Process") && !text.equals("Back")) {
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

        processPaymentButton.addActionListener(e -> processPayment());
        updatePaymentButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Update Feature Coming Soon"));
        deletePaymentButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Delete Feature Coming Soon"));
        loadPaymentsButton.addActionListener(e -> loadPayments());
        printReceiptButton.addActionListener(e -> printReceipt());
        clearFieldsButton.addActionListener(e -> clearFields());
        backButton.addActionListener(e -> { new Dashboard().setVisible(true); this.dispose(); });
    }

    // PROCESS PAYMENT
    // =========================
    private void processPayment() {

        Payment payment = new Payment();
        payment.setRentalId(Integer.parseInt(rentalIdField.getText()));
        payment.setAmount(Double.parseDouble(amountField.getText()));
        payment.setPaymentDate(LocalDate.parse(paymentDateField.getText()));
        payment.setPaymentMethod(paymentMethodField.getText());
        String result = paymentController.processPayment(payment);
        JOptionPane.showMessageDialog(this, result);
        loadPayments();
    }

    // LOAD PAYMENTS
    // =========================
    private void loadPayments() {

        List<Payment> payments = paymentController.getAllPayments();
        paymentsTextArea.setText("");
        for (Payment payment : payments) {
            paymentsTextArea.append(
                    "Payment ID : "
                    + payment.getPaymentId()
                    + " | Rental ID : "
                    + payment.getRentalId()
                    + " | Amount : "
                    + payment.getAmount()
                    + " | Method : "
                    + payment.getPaymentMethod()
                    + "\n"
            );
        }
    }

    // PRINT RECEIPT
    // =========================
    private void printReceipt() {

        String paymentIdText = JOptionPane.showInputDialog(this, "Enter Payment ID");
        if (paymentIdText == null || paymentIdText.isBlank()) {
            return;
        }

        int paymentId = Integer.parseInt(paymentIdText);
        String receipt = paymentController.printReceipt(paymentId);
        JOptionPane.showMessageDialog(this, receipt);
    }

    // CLEAR FIELDS
    // =========================
    private void clearFields() {
        rentalIdField.setText("");
        amountField.setText("");
        paymentDateField.setText("");
        paymentMethodField.setText("");
    }
}