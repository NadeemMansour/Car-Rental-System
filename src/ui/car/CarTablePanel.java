package ui.car;

import model.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CarTablePanel extends JPanel {

    private DefaultTableModel model;
    private JTable table;

    public CarTablePanel() {

        setLayout(new BorderLayout());

        String[] cols = {"ID", "Brand", "Model", "Year", "Status", "Price"};

        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    //  Load Data
    public void setData(List<Car> cars) {

        model.setRowCount(0);

        for (Car c : cars) {
            model.addRow(new Object[]{
                    c.getCarId(),
                    c.getBrand(),
                    c.getModel(),
                    c.getYear(),
                    c.getStatus(),
                    c.getDailyPrice()
            });
        }
    }

    public JTable getTable() {
        return table;
    }
}