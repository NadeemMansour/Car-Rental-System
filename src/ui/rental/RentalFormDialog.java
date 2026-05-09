package ui.rental;

import controller.RentalController;
import model.RentalContract;

import javax.swing.*;
import java.time.LocalDate;

public class RentalFormDialog extends JDialog {

    private JTextField customerIdField;
    private JTextField carIdField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField depositField;
    private JTextField totalField;

    private RentalController controller = new RentalController();

    public RentalFormDialog(JFrame parent) {

        super(parent, "Create Rental Contract", true);

        setSize(450, 400);
        setLocationRelativeTo(parent);
        setLayout(null);

        createForm();

        setVisible(true);
    }

    private void createForm() {

        JLabel customerLbl = new JLabel("Customer ID:");
        customerLbl.setBounds(30, 30, 120, 25);

        customerIdField = new JTextField();
        customerIdField.setBounds(160, 30, 220, 25);

        JLabel carLbl = new JLabel("Car ID:");
        carLbl.setBounds(30, 70, 120, 25);

        carIdField = new JTextField();
        carIdField.setBounds(160, 70, 220, 25);

        JLabel startLbl = new JLabel("Start Date:");
        startLbl.setBounds(30, 110, 120, 25);

        startDateField = new JTextField("2026-01-01");
        startDateField.setBounds(160, 110, 220, 25);

        JLabel endLbl = new JLabel("End Date:");
        endLbl.setBounds(30, 150, 120, 25);

        endDateField = new JTextField("2026-01-10");
        endDateField.setBounds(160, 150, 220, 25);

        JLabel depositLbl = new JLabel("Deposit:");
        depositLbl.setBounds(30, 190, 120, 25);

        depositField = new JTextField();
        depositField.setBounds(160, 190, 220, 25);

        JLabel totalLbl = new JLabel("Total:");
        totalLbl.setBounds(30, 230, 120, 25);

        totalField = new JTextField();
        totalField.setBounds(160, 230, 220, 25);

        JButton saveBtn = new JButton("Create Contract");
        saveBtn.setBounds(160, 280, 180, 35);

        saveBtn.addActionListener(e -> saveRental());

        add(customerLbl);
        add(customerIdField);
        add(carLbl);
        add(carIdField);
        add(startLbl);
        add(startDateField);
        add(endLbl);
        add(endDateField);
        add(depositLbl);
        add(depositField);
        add(totalLbl);
        add(totalField);
        add(saveBtn);
    }

    private void saveRental() {

        RentalContract r = new RentalContract();

        r.setCustomerId(Integer.parseInt(customerIdField.getText()));
        r.setCarId(Integer.parseInt(carIdField.getText()));
        r.setStartDate(LocalDate.parse(startDateField.getText()));
        r.setEndDate(LocalDate.parse(endDateField.getText()));
        r.setDeposit(Double.parseDouble(depositField.getText()));
        r.setTotalAmount(Double.parseDouble(totalField.getText()));
        r.setContractStatus("ACTIVE");

        controller.createRental(r);

        JOptionPane.showMessageDialog(this, "Rental Created Successfully");

        dispose();
    }
}