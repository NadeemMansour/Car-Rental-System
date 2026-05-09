package ui.dashboard;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {

        setLayout(null);
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Overview");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(30, 20, 200, 30);

        add(title);

        addCard("Revenue", "12,500$", 30, 100, new Color(230, 230, 250));
        addCard("Cars", "45", 260, 100, new Color(240, 255, 240));
        addCard("Customers", "120", 490, 100, new Color(255, 245, 230));
        addCard("Active Rentals", "18", 720, 100, new Color(245, 245, 245));

        JPanel chart = new JPanel();
        chart.setBounds(30, 300, 1000, 300);
        chart.setBackground(new Color(240, 240, 240));

        JLabel chartLabel = new JLabel("Revenue Chart Area (JFreeChart placeholder)");
        chart.add(chartLabel);

        add(chart);
    }

    private void addCard(String title, String value, int x, int y, Color color) {

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(x, y, 200, 120);
        card.setBackground(color);

        JLabel t = new JLabel(title);
        t.setBounds(10, 10, 180, 20);

        JLabel v = new JLabel(value);
        v.setBounds(10, 50, 180, 30);
        v.setFont(new Font("Arial", Font.BOLD, 18));

        card.add(t);
        card.add(v);

        add(card);
    }
}