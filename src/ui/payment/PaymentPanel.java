package ui.payment;

import controller.PaymentController;
import controller.Response;
import model.Payment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentPanel extends JPanel {

    private final PaymentController controller = new PaymentController();
    private PaymentTablePanel tablePanel;

    private List<Payment> cachedPayments = new ArrayList<>();

    public PaymentPanel() {

        setLayout(new BorderLayout());

        // 🔝 Top Panel
        JPanel top = new JPanel();

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        JButton addBtn = new JButton("Add Payment");
        JButton refreshBtn = new JButton("Refresh");

        top.add(searchField);
        top.add(searchBtn);
        top.add(addBtn);
        top.add(refreshBtn);

        add(top, BorderLayout.NORTH);

        // 📊 Table
        tablePanel = new PaymentTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        loadData();

        // ➕ Add Payment
        addBtn.addActionListener(e -> {

            new PaymentFormDialog(null);
            loadData();
        });

        // 🔄 Refresh
        refreshBtn.addActionListener(e -> loadData());

        // 🔍 Search (local filter - fast)
        searchBtn.addActionListener(e -> {

            String key = searchField.getText().toLowerCase().trim();

            List<Payment> filtered = cachedPayments.stream()
                    .filter(p ->
                            String.valueOf(p.getPaymentId()).contains(key)
                                    || String.valueOf(p.getAmount()).contains(key)
                    )
                    .toList();

            tablePanel.setData(filtered);
        });
    }

    // =========================
    // 📥 Load Data
    // =========================
    private void loadData() {

        Response<List<Payment>> response = controller.getAllPayments();

        if (response.isSuccess()) {

            cachedPayments = response.getData();
            tablePanel.setData(cachedPayments);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    response.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

// package ui.payment;

// import controller.PaymentController;
// import model.Payment;

// import javax.swing.*;
// import java.awt.*;
// import java.util.List;

// public class PaymentPanel extends JPanel {

//     private PaymentController controller = new PaymentController();
//     private PaymentTablePanel tablePanel;

//     public PaymentPanel() {

//         setLayout(new BorderLayout());

//         // 🔝 Top Control Panel
//         JPanel top = new JPanel();

//         JTextField searchField = new JTextField(15);
//         JButton searchBtn = new JButton("Search");

//         JButton addBtn = new JButton("Add Payment");
//         JButton refreshBtn = new JButton("Refresh");

//         top.add(searchField);
//         top.add(searchBtn);
//         top.add(addBtn);
//         top.add(refreshBtn);

//         add(top, BorderLayout.NORTH);

//         // 📊 Table
//         tablePanel = new PaymentTablePanel();
//         add(tablePanel, BorderLayout.CENTER);

//         loadData();

//         // ➕ Add Payment
//         addBtn.addActionListener(e -> {
//             new PaymentFormDialog(null);
//             loadData();
//         });

//         // 🔄 Refresh
//         refreshBtn.addActionListener(e -> loadData());

//         // 🔍 Search
//         searchBtn.addActionListener(e -> {

//             String key = searchField.getText().toLowerCase();

//             List<Payment> filtered = controller.getAllPayments()
//                     .stream()
//                     .filter(p ->
//                             String.valueOf(p.getPaymentId()).contains(key) ||
//                             String.valueOf(p.getAmount()).contains(key))
//                     .toList();

//             tablePanel.setData(filtered);
//         });
//     }

//     private void loadData() {

//         List<Payment> list = controller.getAllPayments();
//         tablePanel.setData(list);
//     }
// }