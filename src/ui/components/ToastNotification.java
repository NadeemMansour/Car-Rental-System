package ui.components;

import javax.swing.*;
import java.awt.*;

public class ToastNotification extends JWindow {

    public ToastNotification(String message) {

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(message);
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        panel.add(label, BorderLayout.CENTER);

        add(panel);

        setSize(250, 50);
        setLocationRelativeTo(null);

        setVisible(true);

        new Timer(2000, e -> dispose()).start();
    }

    public static void show(String message) {
        new ToastNotification(message);
    }
}