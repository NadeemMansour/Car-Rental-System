package ui.payment;

import controller.PaymentController;
import model.Payment;
import javax.swing.*;
import java.time.LocalDate;

public class PaymentFormDialog extends JDialog {

    private JTextField contractIdField;
    private JTextField amountField;
    private JTextField dateField;
    private JComboBox<String> methodBox;

    private PaymentController controller = new PaymentController();

    public PaymentFormDialog(JFrame parent) {

        super(parent, "Payment Form", true);

        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(null);

        createForm();

        setVisible(true);
    }

    private void createForm() {

        JLabel contractLbl = new JLabel("Contract ID:");
        contractLbl.setBounds(30, 30, 120, 25);

        contractIdField = new JTextField();
        contractIdField.setBounds(150, 30, 200, 25);

        JLabel amountLbl = new JLabel("Amount:");
        amountLbl.setBounds(30, 70, 120, 25);

        amountField = new JTextField();
        amountField.setBounds(150, 70, 200, 25);

        JLabel dateLbl = new JLabel("Date:");
        dateLbl.setBounds(30, 110, 120, 25);

        dateField = new JTextField(LocalDate.now().toString());
        dateField.setBounds(150, 110, 200, 25);

        JLabel methodLbl = new JLabel("Method:");
        methodLbl.setBounds(30, 150, 120, 25);

        methodBox = new JComboBox<>(new String[]{"CASH", "CARD"});
        methodBox.setBounds(150, 150, 200, 25);

        JButton saveBtn = new JButton("Save Payment");
        saveBtn.setBounds(150, 200, 150, 30);

        saveBtn.addActionListener(e -> savePayment());

        add(contractLbl);
        add(contractIdField);
        add(amountLbl);
        add(amountField);
        add(dateLbl);
        add(dateField);
        add(methodLbl);
        add(methodBox);
        add(saveBtn);
    }

    private void savePayment() {

        Payment p = new Payment();

        p.setContractId(Integer.parseInt(contractIdField.getText()));
        p.setAmount(Double.parseDouble(amountField.getText()));
        p.setPaymentDate(LocalDate.parse(dateField.getText()));
        p.setPaymentMethod(methodBox.getSelectedItem().toString());

        controller.addPayment(p);

        JOptionPane.showMessageDialog(this, "Payment Saved Successfully");

        dispose();
    }
}