package ui.report;

import javax.swing.*;
import java.awt.*;

public class KPIWidgetPanel extends JPanel {

    public KPIWidgetPanel(String title, String value, Color color) {

        setLayout(null);
        setBackground(color);
        setSize(200, 120);

        JLabel titleLbl = new JLabel(title);
        titleLbl.setBounds(10, 10, 180, 20);
        titleLbl.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel valueLbl = new JLabel(value);
        valueLbl.setBounds(10, 50, 180, 40);
        valueLbl.setFont(new Font("Arial", Font.BOLD, 22));

        add(titleLbl);
        add(valueLbl);
    }
}