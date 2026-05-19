
package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Dashboard extends JFrame {

    private JPanel sidebarPanel;
    private JPanel topPanel;
    private JPanel contentPanel;

    private JLabel logoLabel;// icon of system or image
    private JLabel titleLabel;
    private JTextField searchField;

    private JButton customerButton;
    private JButton carButton;
    private JButton rentalButton;
    private JButton paymentButton;
    private JButton maintenanceButton;
    private JButton reportsButton;
    private JButton logoutButton;

    public Dashboard() {
        initializeFrame();
        initializeSidebar();

        initializeTopPanel();
        initializeContent();

        initializeActions();
        setVisible(true);
    }

    // FRAME
    // =========================
    private void initializeFrame() {
        setTitle("Car Rental");
        ImageIcon icon = new ImageIcon("src/image/LeftIcon.png");

        setIconImage(icon.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        getContentPane().setBackground(new Color(8, 12, 24));
    }

    // SIDEBAR
    // =========================
    private void initializeSidebar() {

        sidebarPanel = new JPanel();
        sidebarPanel.setBounds(0, 0, 250, 800);
        sidebarPanel.setBackground(new Color(15, 23, 42));
        sidebarPanel.setLayout(null);

        JLabel logoIcon = new JLabel("🚘");
        logoIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 42));
        logoIcon.setBounds(95, 25, 80, 50);

        logoLabel = new JLabel("RentalCar");
        logoLabel.setForeground(new Color(255, 215, 0));
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        logoLabel.setBounds(45, 80, 200, 40);

        JLabel subTitle = new JLabel("Car Rental Management System");
        subTitle.setForeground(new Color(180, 180, 180));
        subTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subTitle.setBounds(55, 120, 170, 30);

        customerButton = createMenuButton("Customers", 190);
        carButton = createMenuButton("Cars", 255);
        rentalButton = createMenuButton("Rentals", 320);
        paymentButton = createMenuButton("Payments", 385);
        maintenanceButton = createMenuButton("Maintenance", 450);
        reportsButton = createMenuButton("Reports", 515);
        logoutButton = createMenuButton("Logout", 650);

        sidebarPanel.add(logoIcon);
        sidebarPanel.add(logoLabel);
        sidebarPanel.add(subTitle);
        sidebarPanel.add(customerButton);
        sidebarPanel.add(carButton);
        sidebarPanel.add(rentalButton);
        sidebarPanel.add(paymentButton);
        sidebarPanel.add(maintenanceButton);
        sidebarPanel.add(reportsButton);
        sidebarPanel.add(logoutButton);

        add(sidebarPanel);
    }

    // TOP PANEL
    // =========================
    private void initializeTopPanel() {

        topPanel = new JPanel();
        topPanel.setBounds(250, 0, 1150, 100);
        topPanel.setBackground(new Color(8, 12, 24));
        topPanel.setLayout(null);

        titleLabel = new JLabel("Luxury Car Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 34));
        titleLabel.setBounds(40, 25, 500, 40);

        JPanel line = new JPanel();
        line.setBackground(new Color(255, 215, 0));
        line.setBounds(40, 72, 260, 4);

        searchField = new JTextField();
        searchField.setBounds(700, 28, 360, 42);
        searchField.setBackground(new Color(22, 30, 50));
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);
        searchField.setBorder(new LineBorder(new Color(0, 191, 255), 2));
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        topPanel.add(titleLabel);
        topPanel.add(line);
        topPanel.add(searchField);

        add(topPanel);
    }

    // CONTENT
    // =========================
    private void initializeContent() {

        contentPanel = new JPanel();

        contentPanel.setPreferredSize(new Dimension(1300, 1280));
        contentPanel.setBackground(new Color(8, 12, 24));
        contentPanel.setLayout(null);

        JPanel carCard1 = createCarCard("BMW M4", "$120 / Day", "src/image/BMW M4.png", 20, 20);
        JPanel carCard2 = createCarCard("Audi RS7", "$150 / Day", "src/image/audi rs7.jpg", 390, 20);
        JPanel carCard3 = createCarCard("Mercedes C63", "$170 / Day", "src/image/MERCEDES C63.jfif", 760, 20);
        JPanel carCard4 = createCarCard("Porsche 911", "$250 / Day", "src/image/PORSCHE 911.jfif", 20, 340);
        JPanel carCard5 = createCarCard("Lamborghini", "$400 / Day", "src/image/Lamborghini.jfif", 390, 340);
        JPanel carCard6 = createCarCard("Ferrari", "$500 / Day", "src/image/Ferrari.jfif", 760, 340);
        JPanel carCard7 = createCarCard("Jeep Wrangler", "$190 / Day", "src/image/jeep wrangler.jfif", 20, 660);
        JPanel carCard8 = createCarCard("Hyundai Sonata", "$110 / Day", "src/image/Hyundai Sontata.jfif", 390, 660);
        JPanel carCard9 = createCarCard("Kia K8", "$130 / Day", "src/image/Kai K8.jfif", 760, 660);
        JPanel carCard10 = createCarCard("Mazda RX7", "$240 / Day", "src/image/mazda rx7.jfif", 20, 980);
        JPanel carCard11 = createCarCard("Lexus LX600", "$380 / Day", "src/image/lexus lx600.jfif", 390, 980);
        JPanel carCard12 = createCarCard("Chevrolet Tahoe", "$260 / Day", "src/image/chevrolet tahoe.jfif", 760, 980);

        contentPanel.add(carCard1);
        contentPanel.add(carCard2);
        contentPanel.add(carCard3);

        contentPanel.add(carCard4);
        contentPanel.add(carCard5);
        contentPanel.add(carCard6);

        contentPanel.add(carCard7);
        contentPanel.add(carCard8);
        contentPanel.add(carCard9);

        contentPanel.add(carCard10);
        contentPanel.add(carCard11);
        contentPanel.add(carCard12);

        // اضافة عمود التحرك
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(250, 100, 1295, 640);
        scrollPane.setBorder(null);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//لا تُظهر شريط تمرير أفقي أبدًا حتى لا يتحرك المحتوى يمين ويسار
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);// أظهر شريط التمرير العمودي دائمًا حتى لو لم يكن هناك محتوى طويل
        scrollPane.getViewport().setBackground(new Color(8, 12, 24));//عشان المنطقة التي تعرض المحتوى داخل الـ ScrollPane. خلفية الـ scroll تصبح Dark Mode.

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);//حدد سرعة التمرير حق الموس 
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));//حجم الشريط
        scrollPane.getVerticalScrollBar().setBackground(new Color(8, 12, 24));

        add(scrollPane);
    }

    // MENU BUTTON
    // =========================
    private JButton createMenuButton(String text, int y) {

        JButton button = new JButton(text);
        button.setBounds(20, y, 215, 60);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(new Color(22, 30, 50));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        // زر تسجيل الخروج
        if (text.equals("Logout")) {
            button.setBackground(new Color(0, 191, 255));
            button.setBorder(null);
        }
        return button;
    }

    // CAR CARD
    // =========================
private JPanel createCarCard(String name, String price, String imagePath, int x, int y) {

    JPanel card = new JPanel();

    card.setBounds(x, y, 320, 280);

    card.setBackground(new Color(15, 23, 42));

    card.setLayout(null);

    card.setBorder(new LineBorder(new Color(0, 191, 255), 2));

    JLabel nameLabel = new JLabel(name);

    nameLabel.setForeground(Color.WHITE);

    nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));

    nameLabel.setBounds(20, 15, 250, 30);

    JLabel priceLabel = new JLabel(price);

    priceLabel.setForeground(new Color(255, 215, 0));

    priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));

    priceLabel.setBounds(20, 52, 150, 25);

    ImageIcon imageIcon = new ImageIcon(imagePath);

    Image image = imageIcon.getImage().getScaledInstance(270, 150, Image.SCALE_SMOOTH);

    JLabel imageLabel = new JLabel(new ImageIcon(image));

    imageLabel.setBounds(25, 85, 270, 150);

    JButton rentButton = new JButton("Rent Now");

    rentButton.setBounds(85, 240, 150, 32);

    rentButton.setBackground(new Color(0, 191, 255));

    rentButton.setForeground(Color.WHITE);

    rentButton.setFocusPainted(false);

    rentButton.setBorderPainted(false);

    rentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    rentButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

    rentButton.addActionListener(e -> {

        RentalForm rentalForm = new RentalForm();

        rentalForm.setCarData(name, price);

        rentalForm.setVisible(true);

        dispose();
    });

    card.add(nameLabel);

    card.add(priceLabel);

    card.add(imageLabel);

    card.add(rentButton);

    return card;
}

    // ACTIONS
    // =========================
    private void initializeActions() {

        customerButton.addActionListener(e -> {
            new CustomerForm().setVisible(true);
            this.dispose();
        });

        carButton.addActionListener(e -> {
            new CarManagementUI().setVisible(true);
            this.dispose();
        });

        rentalButton.addActionListener(e -> {
            new RentalForm().setVisible(true);
            this.dispose();
        });

        paymentButton.addActionListener(e -> {
            new PaymentUI().setVisible(true);
            this.dispose();
        });

        maintenanceButton.addActionListener(e -> {
            new MaintenanceUI().setVisible(true);
            this.dispose();
        });

        reportsButton.addActionListener(e -> {
            new ReportsUI().setVisible(true);
            this.dispose();
        });

        logoutButton.addActionListener(e -> {
            new LoginScreen().setVisible(true);
            this.dispose();
        });
    }
}
