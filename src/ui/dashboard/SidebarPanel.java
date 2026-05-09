package ui.dashboard;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {

    public SidebarPanel(CardLayout cardLayout, JPanel contentPanel) {

        setLayout(null);
        setBackground(new Color(25, 25, 25));
        setBounds(0, 0, 220, 700);

        JLabel logo = new JLabel("CAR RENTAL");
        logo.setForeground(Color.WHITE);
        logo.setBounds(40, 20, 200, 30);
        logo.setFont(new Font("Arial", Font.BOLD, 16));

        add(logo);

        addButton("Dashboard", 100, () -> cardLayout.show(contentPanel, "dashboard"));
        addButton("Cars", 160, () -> cardLayout.show(contentPanel, "cars"));
        addButton("Customers", 220, () -> cardLayout.show(contentPanel, "customers"));
        addButton("Rentals", 280, () -> cardLayout.show(contentPanel, "rentals"));
        addButton("Reports", 340, () -> cardLayout.show(contentPanel, "reports"));
    }

    private void addButton(String text, int y, Runnable action) {

        JButton btn = new JButton(text);
        btn.setBounds(20, y, 170, 40);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(45, 45, 45));
        btn.setForeground(Color.WHITE);

        btn.addActionListener(e -> action.run());

        add(btn);
    }
}