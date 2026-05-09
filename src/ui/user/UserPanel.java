package ui.user;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserPanel extends JPanel {

    private UserController controller = new UserController();
    private UserTablePanel tablePanel;

    public UserPanel() {

        setLayout(new BorderLayout());

        // 🔝 Top Panel
        JPanel top = new JPanel();

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        JButton addBtn = new JButton("Add User");
        JButton refreshBtn = new JButton("Refresh");

        top.add(searchField);
        top.add(searchBtn);
        top.add(addBtn);
        top.add(refreshBtn);

        add(top, BorderLayout.NORTH);

        // 📊 Table
        tablePanel = new UserTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        loadData();

        // ➕ Add User
        addBtn.addActionListener(e -> {
            new UserFormDialog(null);
            loadData();
        });

        // 🔄 Refresh
        refreshBtn.addActionListener(e -> loadData());

        // 🔍 Search
        searchBtn.addActionListener(e -> {

            String key = searchField.getText().toLowerCase();

            List<User> filtered = controller.getAllUsers()
                    .stream()
                    .filter(u ->
                            u.getUsername().toLowerCase().contains(key) ||
                            u.getFullName().toLowerCase().contains(key))
                    .toList();

            tablePanel.setData(filtered);
        });
    }

    private void loadData() {

        List<User> list = controller.getAllUsers();
        tablePanel.setData(list);
    }
}