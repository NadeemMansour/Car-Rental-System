package ui.rental;

import model.RentalContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RentalTablePanel extends JPanel {

    private DefaultTableModel model;
    private JTable table;

    public RentalTablePanel() {

        setLayout(new BorderLayout());

        String[] cols = {
                "ID",
                "Customer",
                "Car",
                "Start Date",
                "End Date",
                "Total",
                "Status"
        };

        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);

        add(scroll, BorderLayout.CENTER);
    }

    // 🔄 Load Data
    public void setData(List<RentalContract> rentals) {

        model.setRowCount(0);

        for (RentalContract r : rentals) {

            model.addRow(new Object[]{
                    r.getContractId(),
                    r.getCustomerId(),
                    r.getCarId(),
                    r.getStartDate(),
                    r.getEndDate(),
                    r.getTotalAmount(),
                    r.getContractStatus()
            });
        }
    }

    public JTable getTable() {
        return table;
    }
}