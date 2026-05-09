package ui.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableFactory {

    public static JTable createTable(String[] columns) {

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        JTable table = new JTable(model);

        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));

        table.setGridColor(new Color(220, 220, 220));
        table.setSelectionBackground(new Color(200, 220, 255));

        return table;
    }
}