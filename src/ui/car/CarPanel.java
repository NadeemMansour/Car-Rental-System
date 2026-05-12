package ui.car;

import controller.CarController;
import controller.Response;
import model.Car;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarPanel extends JPanel {

    private CarController controller = new CarController();
    private CarTablePanel tablePanel;

    public CarPanel() {

        setLayout(new BorderLayout());

        // Top Panel (Buttons)
        JPanel top = new JPanel();

        JButton addBtn = new JButton("Add Car");
        JButton refreshBtn = new JButton("Refresh");

        top.add(addBtn);
        top.add(refreshBtn);

        add(top, BorderLayout.NORTH);

        //  Table
        tablePanel = new CarTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        loadData();

        //  Add Car
        addBtn.addActionListener(e -> {
            new CarFormDialog(null);
            loadData();
        });

        // Refresh
        refreshBtn.addActionListener(e -> loadData());
    }

    private void loadData() {
    Response<List<Car>> response = controller.getAllCars();
    List<Car> cars = response.getData();  // Or response.getData(), depending on Response implementation
    tablePanel.setData(cars);
}
}