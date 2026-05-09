package ui.report;

import javax.swing.*;
import java.awt.*;

public class ChartPanel extends JPanel {

    public ChartPanel() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel placeholder = new JLabel("Charts Area (Revenue / Rentals / Trends)");
        placeholder.setHorizontalAlignment(SwingConstants.CENTER);
        placeholder.setFont(new Font("Arial", Font.BOLD, 16));

        add(placeholder, BorderLayout.CENTER);
    }
}