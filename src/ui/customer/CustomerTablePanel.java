package ui.customer;

import model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CustomerTablePanel extends JPanel {

    private DefaultTableModel model;
    private JTable table;

    public CustomerTablePanel() {

        setLayout(new BorderLayout());

        String[] cols = {
                "ID",
                "Full Name",
                "Phone",
                "National ID",
                "License"
        };

        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);

        add(scroll, BorderLayout.CENTER);
    }

    // 🔄 Load Data
    public void setData(List<Customer> customers) {

        model.setRowCount(0);

        for (Customer c : customers) {

            model.addRow(new Object[]{
                    c.getCustomerId(),
                    c.getFullName(),
                    c.getPhone(),
                    c.getNationalId(),
                    c.getLicenseNumber()
            });
        }
    }

    public JTable getTable() {
        return table;
    }
}