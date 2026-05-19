package view;

import service.ReportService;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ReportsUI extends JFrame {

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel titleLabel;

    private JButton rentalReportButton;
    private JButton paymentReportButton;
    private JButton customerReportButton;
    private JButton carReportButton;
    private JButton maintenanceReportButton;
    private JButton expenseReportButton;
    private JButton statisticsButton;
    private JButton backButton;

    private JTextArea reportTextArea;
    private JScrollPane reportScrollPane;

    private final ReportService reportService = new ReportService();

    public ReportsUI() {
        initializeFrame();

        initializeLeftPanel();
        initializeRightPanel();

        initializeActions();
        setVisible(true);
    }

    // FRAME
    // =========================
    private void initializeFrame() {

        setTitle("Reports Management");
        ImageIcon icon = new ImageIcon("src/LocalIcon.png");
        setIconImage(icon.getImage());
        setSize(1300, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
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

        JPanel overlayPanel = new JPanel();
        overlayPanel.setBounds(0, 0, 520, 760);
        overlayPanel.setBackground(new Color(0, 0, 0, 150));
        overlayPanel.setLayout(null);

        JLabel systemTitleLabel = new JLabel("Car Rental System");
        systemTitleLabel.setForeground(Color.WHITE);
        systemTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
        systemTitleLabel.setBounds(70, 60, 400, 45);

        JLabel subTitleLabel = new JLabel("Reports & Analytics");
        subTitleLabel.setForeground(new Color(220, 220, 220));
        subTitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        subTitleLabel.setBounds(110, 115, 320, 30);

        JLabel quoteLabel = new JLabel("\"Track Everything Professionally\"");
        quoteLabel.setForeground(new Color(255, 215, 0));
        quoteLabel.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        quoteLabel.setBounds(70, 170, 380, 30);

        JButton carsButton = createLeftButton("Cars");
        carsButton.setBounds(110, 300, 300, 50);

        JButton rentalsButton = createLeftButton("Rentals");
        rentalsButton.setBounds(110, 380, 300, 50);

        JButton maintenanceButton = createLeftButton("Maintenance");
        maintenanceButton.setBounds(110, 460, 300, 50);

        carsButton.addActionListener(e -> {
            new CarManagementUI().setVisible(true);
            this.dispose();
        });

        rentalsButton.addActionListener(e -> {
            new RentalForm().setVisible(true);
            this.dispose();
        });

        maintenanceButton.addActionListener(e -> {
            new MaintenanceUI().setVisible(true);
            this.dispose();
        });

        JLabel footerLabel = new JLabel("Version 1.0");
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        footerLabel.setBounds(205, 690, 120, 20);

        overlayPanel.add(systemTitleLabel);
        overlayPanel.add(subTitleLabel);
        overlayPanel.add(quoteLabel);
        overlayPanel.add(carsButton);
        overlayPanel.add(rentalsButton);
        overlayPanel.add(maintenanceButton);
        overlayPanel.add(footerLabel);

        leftPanel.add(overlayPanel);
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

        titleLabel = new JLabel("Reports Management");
        titleLabel.setForeground(new Color(255, 215, 0));
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 34));
        titleLabel.setBounds(160, 25, 420, 40);

        JPanel titleLine = new JPanel();
        titleLine.setBackground(new Color(255, 215, 0));
        titleLine.setBounds(160, 75, 290, 4);

        rentalReportButton = createReportButton("Rental Report", 40, 130);

        paymentReportButton = createReportButton("Payment Report", 410, 130);

        customerReportButton = createReportButton("Customer Report", 40, 200);

        carReportButton = createReportButton("Car Report", 410, 200);

        maintenanceReportButton = createReportButton("Maintenance Report", 40, 270);

        expenseReportButton = createReportButton("Expense Report", 410, 270);

        statisticsButton = createStatisticsButton();

        JPanel revenueCard = createStatisticsCard("Revenue", "$25,000", 40, 390);

        JPanel expensesCard = createStatisticsCard("Expenses", "$8,000", 410, 390);

        JPanel rentalsCard = createStatisticsCard("Rentals", "120", 40, 500);

        JPanel customersCard = createStatisticsCard("Customers", "75", 410, 500);

        backButton = createBackButton();

        reportTextArea = new JTextArea();
        reportTextArea.setBackground(new Color(20, 25, 45));
        reportTextArea.setForeground(Color.WHITE);
        reportTextArea.setCaretColor(Color.WHITE);
        reportTextArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        reportTextArea.setEditable(false);
        reportTextArea.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        reportScrollPane = new JScrollPane(reportTextArea);
        reportScrollPane.setBounds(40, 610, 690, 90);
        reportScrollPane.setBorder(null);
        reportScrollPane.getViewport().setBackground(new Color(12, 17, 33));
        reportScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        reportScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));

        rightPanel.add(titleLabel);
        rightPanel.add(titleLine);
        rightPanel.add(rentalReportButton);
        rightPanel.add(paymentReportButton);
        rightPanel.add(customerReportButton);
        rightPanel.add(carReportButton);
        rightPanel.add(maintenanceReportButton);
        rightPanel.add(expenseReportButton);
        rightPanel.add(statisticsButton);
        rightPanel.add(revenueCard);
        rightPanel.add(expensesCard);
        rightPanel.add(rentalsCard);
        rightPanel.add(customersCard);
        rightPanel.add(backButton);
        rightPanel.add(reportScrollPane);

        add(rightPanel);
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

    // REPORT BUTTON
    // =========================
    private JButton createReportButton(String text, int x, int y) {

        JButton button = new JButton(text);
        button.setBounds(x, y, 320, 50);
        button.setBackground(new Color(22, 30, 50));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        return button;
    }

    // STATISTICS BUTTON
    // =========================
    private JButton createStatisticsButton() {

        JButton button = new JButton("Financial Statistics");
        button.setBounds(225, 330, 320, 45);
        button.setBackground(new Color(0, 191, 255));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    // STATISTICS CARD
    // =========================
    private JPanel createStatisticsCard(String title, String value, int x, int y) {

        JPanel card = new JPanel();
        card.setBounds(x, y, 320, 90);
        card.setBackground(new Color(22, 30, 50));
        card.setLayout(null);
        card.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setBounds(20, 15, 200, 25);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setForeground(new Color(255, 215, 0));
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        valueLabel.setBounds(20, 45, 220, 30);

        card.add(titleLabel);
        card.add(valueLabel);

        return card;
    }

    // BACK BUTTON
    // =========================
    private JButton createBackButton() {

        JButton button = new JButton("Back");
        button.setBounds(310, 640, 160, 45);
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

        rentalReportButton.addActionListener(e -> generateRentalReport());

        paymentReportButton.addActionListener(e -> generatePaymentReport());

        customerReportButton.addActionListener(e -> generateCustomerReport());

        carReportButton.addActionListener(e -> generateCarReport());

        maintenanceReportButton.addActionListener(e -> generateMaintenanceReport());

        expenseReportButton.addActionListener(e -> generateExpenseReport());

        statisticsButton.addActionListener(e -> showStatistics());

        backButton.addActionListener(e -> {
            new Dashboard().setVisible(true);
            this.dispose();
        });
    }

    // RENTAL REPORT
    // =========================
    private void generateRentalReport() {

        reportTextArea.setText("");
        reportService.generateRentalReport().forEach(rental -> {
            reportTextArea.append(
                    "Rental ID : "
                            + rental.getRentalId()
                            + " | Customer ID : "
                            + rental.getCustomerId()
                            + " | Car ID : "
                            + rental.getCarId()
                            + " | Status : "
                            + rental.getContractStatus()
                            + "\n");
        });
    }

    // PAYMENT REPORT
    // =========================
    private void generatePaymentReport() {

        reportTextArea.setText("");
        reportService.generatePaymentReport().forEach(payment -> {
            reportTextArea.append(
                    "Payment ID : "
                            + payment.getPaymentId()
                            + " | Rental ID : "
                            + payment.getRentalId()
                            + " | Amount : "
                            + payment.getAmount()
                            + "\n");
        });
    }

    // CUSTOMER REPORT
    // =========================
    private void generateCustomerReport() {

        reportTextArea.setText("");
        reportService.generateCustomerReport().forEach(customer -> {
            reportTextArea.append(
                    "Customer ID : "
                            + customer.getCustomerId()
                            + " | Name : "
                            + customer.getFullName()
                            + " | Phone : "
                            + customer.getPhone()
                            + "\n");
        });
    }

    // CAR REPORT
    // =========================
    private void generateCarReport() {

        reportTextArea.setText("");
        reportService.generateCarReport().forEach(car -> {
            reportTextArea.append(
                    "Car ID : "
                            + car.getCarId()
                            + " | Brand : "
                            + car.getBrand()
                            + " | Model : "
                            + car.getModel()
                            + " | Status : "
                            + car.getStatus()
                            + "\n");
        });
    }

    // MAINTENANCE REPORT
    // =========================
    private void generateMaintenanceReport() {

        reportTextArea.setText("");
        reportService.generateMaintenanceReport().forEach(maintenance -> {
            reportTextArea.append(
                    "Maintenance ID : "
                            + maintenance.getMaintenanceId()
                            + " | Car ID : "
                            + maintenance.getCarId()
                            + " | Cost : "
                            + maintenance.getCost()
                            + "\n");
        });
    }

    // EXPENSE REPORT
    // =========================
    private void generateExpenseReport() {

        reportTextArea.setText("");
        reportService.generateExpenseReport().forEach(expense -> {
            reportTextArea.append(
                    "Expense ID : "
                            + expense.getExpenseId()
                            + " | Amount : "
                            + expense.getCost()
                            + " | Title : "
                            + expense.getDescription()
                            + "\n");
        });
    }

    // FINANCIAL STATISTICS
    // =========================
    private void showStatistics() {

        double totalRevenue = reportService.getTotalRevenue();

        double totalExpenses = reportService.getTotalExpenses();

        double netProfit = reportService.getNetProfit();
        reportTextArea.setText(
                "========== FINANCIAL STATISTICS ==========\n\n"
                        + "Total Revenue : "
                        + totalRevenue
                        + "\n\n"
                        + "Total Expenses : "
                        + totalExpenses
                        + "\n\n"
                        + "Net Profit : "
                        + netProfit);
    }
}
