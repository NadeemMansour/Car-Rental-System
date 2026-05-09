package ui.dashboard;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel() {

        setLayout(null);
        setBackground(new Color(40, 40, 40));
        setBounds(220, 0, 1080, 60);

        JLabel title = new JLabel("Dashboard");
        title.setForeground(Color.WHITE);
        title.setBounds(20, 15, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel user = new JLabel("Admin");
        user.setForeground(Color.LIGHT_GRAY);
        user.setBounds(900, 15, 100, 30);

        JButton logout = new JButton("Logout");
        logout.setBounds(980, 15, 80, 30);

        logout.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logged out");
            System.exit(0);
        });

        add(title);
        add(user);
        add(logout);
    }
}