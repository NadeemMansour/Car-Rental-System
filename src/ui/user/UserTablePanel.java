package ui.user;

import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserTablePanel extends JPanel {

    private DefaultTableModel model;
    private JTable table;

    public UserTablePanel() {

        setLayout(new BorderLayout());

        String[] cols = {
                "ID",
                "Username",
                "Full Name",
                "Role",
                "Status"
        };

        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);

        add(scroll, BorderLayout.CENTER);
    }

    // 🔄 Load Data
    public void setData(List<User> users) {

        model.setRowCount(0);

        for (User u : users) {

            model.addRow(new Object[]{
                    u.getUserId(),
                    u.getUsername(),
                    u.getFullName(),
                    u.getRole(),
                    u.getStatus()
            });
        }
    }

    public JTable getTable() {
        return table;
    }
}