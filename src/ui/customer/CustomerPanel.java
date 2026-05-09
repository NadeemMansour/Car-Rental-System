package ui.customer;

import controller.CustomerController;
import controller.Response;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerPanel extends JPanel {

    private final CustomerController controller = new CustomerController();
    private CustomerTablePanel tablePanel;

    // 🧠 cache لتقليل استدعاء DB
    private List<Customer> cachedCustomers = new ArrayList<>();

    public CustomerPanel() {

        setLayout(new BorderLayout());

        // 🔝 Top Panel
        JPanel top = new JPanel();

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        JButton addBtn = new JButton("Add Customer");
        JButton refreshBtn = new JButton("Refresh");

        top.add(searchField);
        top.add(searchBtn);
        top.add(addBtn);
        top.add(refreshBtn);

        add(top, BorderLayout.NORTH);

        // 📊 Table
        tablePanel = new CustomerTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        // 📥 Load data
        loadData();

        // ➕ Add Customer
        addBtn.addActionListener(e -> {

            new CustomerFormDialog(null);
            loadData();
        });

        // 🔄 Refresh
        refreshBtn.addActionListener(e -> loadData());

        // 🔍 Search (offline filter - fast)
        searchBtn.addActionListener(e -> {

            String keyword = searchField.getText().toLowerCase().trim();

            List<Customer> filtered = cachedCustomers.stream()
                    .filter(c ->
                            (c.getFullName() != null &&
                                    c.getFullName().toLowerCase().contains(keyword))
                            ||
                            (c.getPhone() != null &&
                                    c.getPhone().contains(keyword))
                    )
                    .toList();

            tablePanel.setData(filtered);
        });
    }

    // =========================
    // 📥 Load Data from Controller
    // =========================
    private void loadData() {

        Response<List<Customer>> response = controller.getAllCustomers();

        if (response.isSuccess()) {

            cachedCustomers = response.getData();

            tablePanel.setData(cachedCustomers);

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

// package ui.customer;

// import controller.CustomerController;
// import model.Customer;

// import javax.swing.*;
// import java.awt.*;
// import java.util.List;

// public class CustomerPanel extends JPanel {

//     private CustomerController controller = new CustomerController();
//     private CustomerTablePanel tablePanel;

//     public CustomerPanel() {

//         setLayout(new BorderLayout());

//         // 🔝 Top Panel
//         JPanel top = new JPanel();

//         JTextField searchField = new JTextField(15);
//         JButton searchBtn = new JButton("Search");

//         JButton addBtn = new JButton("Add Customer");
//         JButton refreshBtn = new JButton("Refresh");

//         top.add(searchField);
//         top.add(searchBtn);
//         top.add(addBtn);
//         top.add(refreshBtn);

//         add(top, BorderLayout.NORTH);

//         // 📊 Table
//         tablePanel = new CustomerTablePanel();
//         add(tablePanel, BorderLayout.CENTER);

//         loadData();

//         // ➕ Add Customer
//         addBtn.addActionListener(e -> {
//             new CustomerFormDialog(null);
//             loadData();
//         });

//         // 🔄 Refresh
//         refreshBtn.addActionListener(e -> loadData());

//         // 🔍 Search
//         searchBtn.addActionListener(e -> {

//             String keyword = searchField.getText().toLowerCase();

//             List<Customer> filtered = controller.getAllCustomers()
//                     .stream()
//                     .filter(c -> c.getFullName().toLowerCase().contains(keyword)
//                             || c.getPhone().contains(keyword))
//                     .toList();

//             tablePanel.setData(filtered);
//         });
//     }

//     private void loadData() {

//         List<Customer> list = controller.getAllCustomers();
//         tablePanel.setData(list);
//     }
// }