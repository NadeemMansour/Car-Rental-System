package ui.payment;

import model.Payment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PaymentTablePanel extends JPanel {

    private DefaultTableModel model;
    private JTable table;

    public PaymentTablePanel() {

        setLayout(new BorderLayout());

        String[] cols = {
                "ID",
                "Contract ID",
                "Amount",
                "Date",
                "Method"
        };

        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Payment> payments) {

        model.setRowCount(0);

        for (Payment p : payments) {

            model.addRow(new Object[]{
                    p.getPaymentId(),
                    p.getContractId(),
                    p.getAmount(),
                    p.getPaymentDate(),
                    p.getPaymentMethod()
            });
        }
    }

    public JTable getTable() {
        return table;
    }
}