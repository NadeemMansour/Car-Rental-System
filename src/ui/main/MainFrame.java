package ui.main;

import ui.dashboard.DashboardPanel;
import ui.car.CarPanel;
import ui.customer.CustomerPanel;
import ui.rental.RentalPanel;
import ui.report.ReportPanel;

import javax.swing.*;

import model.User;

import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout = new CardLayout();
    private JPanel contentPanel = new JPanel(cardLayout);

    public MainFrame(User user) {

        setTitle("Car Rental System - Dashboard");
        setSize(1300, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        createSidebar();
        createHeader();
        createContent();

        setVisible(true);
    }

    //  Sidebar
    private void createSidebar() {

        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBackground(new Color(25, 25, 25));
        sidebar.setBounds(0, 0, 220, 750);

        addButton(sidebar, "Dashboard", 30, "dashboard");
        addButton(sidebar, "Cars", 90, "cars");
        addButton(sidebar, "Customers", 150, "customers");
        addButton(sidebar, "Rentals", 210, "rentals");
        addButton(sidebar, "Reports", 270, "reports");

        add(sidebar);
    }

    //  Sidebar Button
    private void addButton(JPanel panel, String text, int y, String view) {

        JButton btn = new JButton(text);
        btn.setBounds(20, y, 160, 40);
        btn.setFocusPainted(false);

        btn.addActionListener(e -> cardLayout.show(contentPanel, view));

        panel.add(btn);
    }

    //  Header
    private void createHeader() {

        JPanel header = new JPanel();
        header.setBounds(220, 0, 1080, 60);
        header.setBackground(new Color(45, 45, 45));
        header.setLayout(null);

        JLabel title = new JLabel("Car Rental Management System");
        title.setForeground(Color.WHITE);
        title.setBounds(20, 15, 400, 30);

        header.add(title);

        add(header);
    }

    //  Content Area
    private void createContent() {

        contentPanel.setBounds(220, 60, 1080, 690);

        contentPanel.add(new DashboardPanel(), "dashboard");
        contentPanel.add(new CarPanel(), "cars");
        contentPanel.add(new CustomerPanel(), "customers");
        contentPanel.add(new RentalPanel(), "rentals");
        contentPanel.add(new ReportPanel(), "reports");

        add(contentPanel);

        cardLayout.show(contentPanel, "dashboard");
    }

    public static void main(String[] args) {
        new SplashScreen(); // يبدأ من splash
    }
}