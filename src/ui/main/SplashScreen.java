package ui.main;

import ui.auth.LoginFrame;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    private JProgressBar progressBar;

    public SplashScreen() {

        setTitle("Loading System...");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(null);

        //  Background Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setBounds(0, 0, 500, 300);
        panel.setLayout(null);

        //  Title
        JLabel title = new JLabel("Car Rental System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(140, 80, 300, 30);

        //  Progress Bar
        progressBar = new JProgressBar();
        progressBar.setBounds(100, 200, 300, 20);
        progressBar.setStringPainted(true);

        panel.add(title);
        panel.add(progressBar);

        add(panel);

        setVisible(true);

        loadSystem();
    }

    //  Simulate Loading
    private void loadSystem() {

        new Thread(() -> {

            try {
                for (int i = 0; i <= 100; i++) {

                    Thread.sleep(30);
                    progressBar.setValue(i);
                }

                dispose();

                // بعد التحميل → فتح Login
                new LoginFrame().setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }

    public static void main(String[] args) {
        new SplashScreen();
    }
}