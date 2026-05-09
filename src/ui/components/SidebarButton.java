package ui.components;

import javax.swing.*;
import java.awt.*;

public class SidebarButton extends JButton {

    public SidebarButton(String text) {

        super(text);

        setFocusPainted(false);
        setBackground(new Color(45, 45, 45));
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.PLAIN, 13));

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public void setActive(boolean active) {

        if (active) {
            setBackground(new Color(70, 70, 70));
        } else {
            setBackground(new Color(45, 45, 45));
        }
    }
}