package ui.components;

import javax.swing.*;
import java.awt.*;

public class SearchBar extends JPanel {

    public JTextField field;
    public JButton searchBtn;

    public SearchBar() {

        setLayout(new FlowLayout(FlowLayout.LEFT));

        field = new JTextField(20);

        searchBtn = new JButton("Search");
        searchBtn.setBackground(new Color(50, 50, 50));
        searchBtn.setForeground(Color.WHITE);

        add(field);
        add(searchBtn);
    }

    public String getText() {
        return field.getText();
    }
}