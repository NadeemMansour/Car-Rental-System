package ui.components;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory {

    public static JButton createPrimaryButton(String text) {

        JButton btn = new JButton(text);

        btn.setBackground(new Color(40, 40, 40));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        return btn;
    }

    public static JButton createDangerButton(String text) {

        JButton btn = new JButton(text);

        btn.setBackground(new Color(200, 50, 50));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);

        return btn;
    }

    public static JButton createSuccessButton(String text) {

        JButton btn = new JButton(text);

        btn.setBackground(new Color(50, 160, 90));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);

        return btn;
    }
}