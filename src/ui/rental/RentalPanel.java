package ui.rental;

import controller.RentalController;
import model.RentalContract;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RentalPanel extends JPanel {

    private RentalController controller = new RentalController();
    private RentalTablePanel tablePanel;

    public RentalPanel() {

        setLayout(new BorderLayout());

        //  Top Panel
        JPanel top = new JPanel();

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        JButton addBtn = new JButton("New Rental");
        JButton refreshBtn = new JButton("Refresh");

        top.add(searchField);
        top.add(searchBtn);
        top.add(addBtn);
        top.add(refreshBtn);

        add(top, BorderLayout.NORTH);

        //  Table
        tablePanel = new RentalTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        loadData();

        //  New Rental
        addBtn.addActionListener(e -> {
            new RentalFormDialog(null);
            loadData();
        });

        //  Refresh
        refreshBtn.addActionListener(e -> loadData());

        //  Search
        searchBtn.addActionListener(e -> {

            String key = searchField.getText().toLowerCase();

            List<RentalContract> filtered = controller.getAllRentals()
                    .stream()
                    .filter(r -> String.valueOf(r.getContractId()).contains(key))
                    .toList();

            tablePanel.setData(filtered);
        });
    }

    private void loadData() {

        List<RentalContract> list = controller.getAllRentals();
        tablePanel.setData(list);
    }
}