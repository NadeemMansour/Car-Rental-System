package ui.car;

import model.Car;
import controller.CarController;

import javax.swing.*;


public class CarFormDialog extends JDialog {

    private JTextField brandField;
    private JTextField modelField;
    private JTextField yearField;
    private JTextField priceField;
    private JTextField statusField;

    private CarController controller = new CarController();

    public CarFormDialog(JFrame parent) {

        super(parent, "Car Form", true);

        setSize(400, 350);
        setLocationRelativeTo(parent);
        setLayout(null);

        createForm();

        setVisible(true);
    }

    private void createForm() {

        JLabel brandLbl = new JLabel("Brand:");
        brandLbl.setBounds(30, 30, 100, 25);

        brandField = new JTextField();
        brandField.setBounds(120, 30, 200, 25);

        JLabel modelLbl = new JLabel("Model:");
        modelLbl.setBounds(30, 70, 100, 25);

        modelField = new JTextField();
        modelField.setBounds(120, 70, 200, 25);

        JLabel yearLbl = new JLabel("Year:");
        yearLbl.setBounds(30, 110, 100, 25);

        yearField = new JTextField();
        yearField.setBounds(120, 110, 200, 25);

        JLabel priceLbl = new JLabel("Price:");
        priceLbl.setBounds(30, 150, 100, 25);

        priceField = new JTextField();
        priceField.setBounds(120, 150, 200, 25);

        JLabel statusLbl = new JLabel("Status:");
        statusLbl.setBounds(30, 190, 100, 25);

        statusField = new JTextField("AVAILABLE");
        statusField.setBounds(120, 190, 200, 25);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(120, 240, 120, 30);

        saveBtn.addActionListener(e -> saveCar());

        add(brandLbl);
        add(brandField);
        add(modelLbl);
        add(modelField);
        add(yearLbl);
        add(yearField);
        add(priceLbl);
        add(priceField);
        add(statusLbl);
        add(statusField);
        add(saveBtn);
    }

    private void saveCar() {

        Car car = new Car();

        car.setBrand(brandField.getText());
        car.setModel(modelField.getText());
        car.setYear(Integer.parseInt(yearField.getText()));
        car.setDailyPrice(Double.parseDouble(priceField.getText()));
        car.setStatus(statusField.getText());

        controller.addCar(car);

        JOptionPane.showMessageDialog(this, "Car Saved Successfully");

        dispose();
    }
}