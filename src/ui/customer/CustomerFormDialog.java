package ui.customer;

import controller.CustomerController;
import model.Customer;

import javax.swing.*;


public class CustomerFormDialog extends JDialog {

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField nationalIdField;
    private JTextField licenseField;
    private JTextField addressField;

    private CustomerController controller = new CustomerController();

    public CustomerFormDialog(JFrame parent) {

        super(parent, "Customer Form", true);

        setSize(420, 380);
        setLocationRelativeTo(parent);
        setLayout(null);

        createForm();

        setVisible(true);
    }

    private void createForm() {

        JLabel nameLbl = new JLabel("Full Name:");
        nameLbl.setBounds(30, 30, 120, 25);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 25);

        JLabel phoneLbl = new JLabel("Phone:");
        phoneLbl.setBounds(30, 70, 120, 25);

        phoneField = new JTextField();
        phoneField.setBounds(150, 70, 200, 25);

        JLabel nationalLbl = new JLabel("National ID:");
        nationalLbl.setBounds(30, 110, 120, 25);

        nationalIdField = new JTextField();
        nationalIdField.setBounds(150, 110, 200, 25);

        JLabel licenseLbl = new JLabel("License:");
        licenseLbl.setBounds(30, 150, 120, 25);

        licenseField = new JTextField();
        licenseField.setBounds(150, 150, 200, 25);

        JLabel addressLbl = new JLabel("Address:");
        addressLbl.setBounds(30, 190, 120, 25);

        addressField = new JTextField();
        addressField.setBounds(150, 190, 200, 25);

        JButton saveBtn = new JButton("Save Customer");
        saveBtn.setBounds(150, 250, 160, 35);

        saveBtn.addActionListener(e -> saveCustomer());

        add(nameLbl);
        add(nameField);
        add(phoneLbl);
        add(phoneField);
        add(nationalLbl);
        add(nationalIdField);
        add(licenseLbl);
        add(licenseField);
        add(addressLbl);
        add(addressField);
        add(saveBtn);
    }

    private void saveCustomer() {

        Customer c = new Customer();

        c.setFullName(nameField.getText());
        c.setPhone(phoneField.getText());
        c.setNationalId(nationalIdField.getText());
        c.setLicenseNumber(licenseField.getText());
        c.setAddress(addressField.getText());

        controller.addCustomer(c);

        JOptionPane.showMessageDialog(this, "Customer Saved Successfully");

        dispose();
    }
}