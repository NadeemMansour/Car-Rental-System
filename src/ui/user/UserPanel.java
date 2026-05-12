package ui.user;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserPanel extends JPanel {

    private final UserController controller =
            new UserController();

    private final UserTablePanel tablePanel;

    public UserPanel() {

        setLayout(new BorderLayout());

        // TOP PANEL

        JPanel top = new JPanel();

        JTextField searchField =
                new JTextField(15);

        JButton searchBtn =
                new JButton("Search");

        JButton addBtn =
                new JButton("Add User");

        JButton refreshBtn =
                new JButton("Refresh");

        top.add(searchField);

        top.add(searchBtn);

        top.add(addBtn);

        top.add(refreshBtn);

        add(top, BorderLayout.NORTH);

        // TABLE PANEL

        tablePanel = new UserTablePanel();

        add(tablePanel, BorderLayout.CENTER);

        // LOAD DATA

        loadData();

        // ADD USER

        addBtn.addActionListener(e -> {

            new UserFormDialog(null);

            loadData();
        });

        // REFRESH

        refreshBtn.addActionListener(
                e -> loadData()
        );

        // SEARCH

        searchBtn.addActionListener(e -> {

            String key =
                    searchField.getText();

            if (key == null) {

                key = "";
            }

            key = key.toLowerCase();

            List<User> users =
                    controller.getAllUsers();

            if (users == null) {

                users = new ArrayList<>();
            }

            List<User> filtered =
                    new ArrayList<>();

            for (User u : users) {

                if (u.getUsername() != null
                        &&
                        u.getUsername()
                                .toLowerCase()
                                .contains(key)) {

                    filtered.add(u);
                }
            }

            tablePanel.setData(filtered);
        });
    }

    // LOAD ALL USERS

    private void loadData() {

        List<User> list =
                controller.getAllUsers();

        if (list == null) {

            list = new ArrayList<>();
        }

        tablePanel.setData(list);
    }
}

// package ui.user;

// import controller.UserController;
// import model.User;

// import javax.swing.*;
// import java.awt.*;
// import java.util.ArrayList;
// import java.util.List;

// public class UserPanel extends JPanel {

//     private final UserController controller = new UserController();
//     private final UserTablePanel tablePanel;

//     public UserPanel() {

//         setLayout(new BorderLayout());

//         //  Top Panel
//         JPanel top = new JPanel();

//         JTextField searchField = new JTextField(15);
//         JButton searchBtn = new JButton("Search");

//         JButton addBtn = new JButton("Add User");
//         JButton refreshBtn = new JButton("Refresh");

//         top.add(searchField);
//         top.add(searchBtn);
//         top.add(addBtn);
//         top.add(refreshBtn);

//         add(top, BorderLayout.NORTH);

//         //  Table Panel
//         tablePanel = new UserTablePanel();
//         add(tablePanel, BorderLayout.CENTER);

//         //  Load Data
//         loadData();

//         // ➕ Add User
//         addBtn.addActionListener(e -> {
//             new UserFormDialog(null);
//             loadData();
//         });

//         //  Refresh
//         refreshBtn.addActionListener(e -> loadData());

//         //  Search (FIXED - NO STREAMS)
//         searchBtn.addActionListener(e -> {

//             String key = searchField.getText();

//             if (key == null) {
//                 key = "";
//             }

//             key = key.toLowerCase();

//             List<User> users = controller.getAllUsers();

//             if (users == null) {
//                 users = new ArrayList<>();
//             }

//             List<User> filtered = new ArrayList<>();

//             for (User u : users) {

//                 if (u.getUsername() != null &&
//                         u.getUsername().toLowerCase().contains(key)) {

//                     filtered.add(u);
//                 }
//             }

//             tablePanel.setData(filtered);
//         });
//     }

//     //  Load All Users
//     private void loadData() {

//         List<User> list = controller.getAllUsers();

//         if (list == null) {
//             list = new ArrayList<>();
//         }

//         tablePanel.setData(list);
//     }
// }