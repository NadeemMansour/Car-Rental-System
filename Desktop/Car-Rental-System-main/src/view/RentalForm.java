package view;

import controller.RentalController;
import model.RentalContract;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class RentalForm extends JFrame {

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel titleLabel;

    private JLabel selectedCarLabel;
    private JLabel customerIdLabel;
    private JLabel carIdLabel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JLabel totalAmountLabel;
    private JLabel depositLabel;
    private JLabel discountLabel;
    private JLabel statusLabel;

    private JTextField selectedCarField;
    private JTextField customerIdField;
    private JTextField carIdField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField totalAmountField;
    private JTextField depositField;
    private JTextField discountField;
    private JTextField statusField;

    private JButton createButton;
    private JButton updateButton;
    private JButton cancelButton;
    private JButton loadButton;
    private JButton backButton;

    private JTextArea rentalsArea;

    private JScrollPane scrollPane;

    private final RentalController rentalController =
            new RentalController();

    public RentalForm() {

        initializeFrame();

        initializeLeftPanel();

        initializeRightPanel();

        initializeActions();

        setVisible(true);
    }

    // FRAME
    // =========================
    private void initializeFrame() {

        setTitle("Rental Management");

        ImageIcon icon =
                new ImageIcon("src/image/LeftIcon.png");

        setIconImage(icon.getImage());

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        setResizable(true);
    }

    // LEFT PANEL
    // =========================
    private void initializeLeftPanel() {

        leftPanel = new JPanel(new BorderLayout());

        leftPanel.setPreferredSize(
                new Dimension(520, 860)
        );

        leftPanel.setBackground(Color.BLACK);

        ImageIcon imageIcon =
                new ImageIcon("src/image/LeftIcon.png");

        Image image = imageIcon.getImage().getScaledInstance(
                520,
                860,
                Image.SCALE_SMOOTH
        );

        JLabel imageLabel =
                new JLabel(new ImageIcon(image));

        leftPanel.add(imageLabel, BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);
    }

    // RIGHT PANEL
    // =========================
    private void initializeRightPanel() {

        rightPanel = new JPanel(new GridBagLayout());

        rightPanel.setBackground(new Color(7, 12, 28));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 15, 10, 15);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.anchor = GridBagConstraints.WEST;

        // TITLE
        titleLabel = new JLabel("Rental Management");

        titleLabel.setForeground(new Color(255, 215, 0));

        titleLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 40)
        );

        titleLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2;

        rightPanel.add(titleLabel, gbc);

        // LABELS
        selectedCarLabel = createLabel("Selected Car");

        customerIdLabel = createLabel("Customer ID");

        carIdLabel = createLabel("Car ID");

        startDateLabel = createLabel("Start Date");

        endDateLabel = createLabel("End Date");

        totalAmountLabel = createLabel("Total Amount");

        depositLabel = createLabel("Deposit");

        discountLabel = createLabel("Discount");

        statusLabel = createLabel("Status");

        // FIELDS
        selectedCarField = createTextField();

        selectedCarField.setEditable(false);

        customerIdField = createTextField();

        carIdField = createTextField();

        startDateField = createTextField();

        endDateField = createTextField();

        totalAmountField = createTextField();

        depositField = createTextField();

        discountField = createTextField();

        statusField = createTextField();

        // ADD FORM ROWS
        addRow(
                rightPanel,
                gbc,
                1,
                selectedCarLabel,
                selectedCarField
        );

        addRow(
                rightPanel,
                gbc,
                2,
                customerIdLabel,
                customerIdField
        );

        addRow(
                rightPanel,
                gbc,
                3,
                carIdLabel,
                carIdField
        );

        addRow(
                rightPanel,
                gbc,
                4,
                startDateLabel,
                startDateField
        );

        addRow(
                rightPanel,
                gbc,
                5,
                endDateLabel,
                endDateField
        );

        addRow(
                rightPanel,
                gbc,
                6,
                totalAmountLabel,
                totalAmountField
        );

        addRow(
                rightPanel,
                gbc,
                7,
                depositLabel,
                depositField
        );

        addRow(
                rightPanel,
                gbc,
                8,
                discountLabel,
                discountField
        );

        addRow(
                rightPanel,
                gbc,
                9,
                statusLabel,
                statusField
        );

        // BUTTONS
        createButton = createButton("Create");

        updateButton = createButton("Update");

        cancelButton = createButton("Cancel");

        loadButton = createButton("Rentals");

        backButton = createButton("Back");

        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        20,
                        10
                )
        );

        buttonPanel.setOpaque(false);

        buttonPanel.add(createButton);

        buttonPanel.add(updateButton);

        buttonPanel.add(cancelButton);

        buttonPanel.add(loadButton);

        buttonPanel.add(backButton);

        gbc.gridx = 0;

        gbc.gridy = 10;

        gbc.gridwidth = 2;

        rightPanel.add(buttonPanel, gbc);

        // TEXT AREA
        rentalsArea = new JTextArea(5, 40);

        rentalsArea.setBackground(
                new Color(18, 25, 45)
        );

        rentalsArea.setForeground(Color.WHITE);

        rentalsArea.setCaretColor(Color.WHITE);

        rentalsArea.setFont(
                new Font("Consolas", Font.PLAIN, 14)
        );

        rentalsArea.setBorder(
                new LineBorder(
                        new Color(0, 191, 255),
                        2
                )
        );

        rentalsArea.setEditable(false);

        scrollPane = new JScrollPane(rentalsArea);

        scrollPane.setBorder(null);

        gbc.gridx = 0;

        gbc.gridy = 11;

        gbc.gridwidth = 2;

        gbc.weightx = 1;

        gbc.weighty = 1;

        gbc.fill = GridBagConstraints.BOTH;

        rightPanel.add(scrollPane, gbc);

        add(rightPanel, BorderLayout.CENTER);
    }

    // ADD ROW
    // =========================
    private void addRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            JLabel label,
            JTextField field
    ) {

        gbc.gridx = 0;

        gbc.gridy = row;

        gbc.gridwidth = 1;

        gbc.weightx = 0;

        gbc.fill = GridBagConstraints.HORIZONTAL;

        panel.add(label, gbc);

        gbc.gridx = 1;

        gbc.weightx = 1;

        panel.add(field, gbc);
    }

    // LABEL
    // =========================
    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setForeground(Color.WHITE);

        label.setFont(
                new Font("Segoe UI", Font.BOLD, 17)
        );

        return label;
    }

    // TEXT FIELD
    // =========================
    private JTextField createTextField() {

        JTextField field = new JTextField();

        field.setPreferredSize(
                new Dimension(450, 42)
        );

        field.setBackground(new Color(18, 25, 45));

        field.setForeground(Color.WHITE);

        field.setCaretColor(Color.WHITE);

        field.setFont(
                new Font("Segoe UI", Font.PLAIN, 16)
        );

        field.setBorder(
                new LineBorder(
                        new Color(0, 191, 255),
                        2
                )
        );

        return field;
    }

    // BUTTON
    // =========================
    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setPreferredSize(
                new Dimension(140, 45)
        );

        button.setFont(
                new Font("Segoe UI", Font.BOLD, 15)
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.setBackground(new Color(25, 35, 60));

        button.setForeground(Color.WHITE);

        button.setBorder(
                new LineBorder(
                        new Color(0, 191, 255),
                        1
                )
        );

        return button;
    }

    // ACTIONS
    // =========================
    private void initializeActions() {

        createButton.addActionListener(
                e -> createRental()
        );

        updateButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Update Feature Coming Soon"
                )
        );

        cancelButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Rental Cancelled"
                )
        );

        loadButton.addActionListener(
                e -> loadRentals()
        );

        backButton.addActionListener(e -> {

            dispose();

            new Dashboard().setVisible(true);
        });
    }

    // CREATE RENTAL
    // =========================
    private void createRental() {

        RentalContract rental =
                new RentalContract();

        rental.setCustomerId(
                Integer.parseInt(
                        customerIdField.getText()
                )
        );

        rental.setCarId(
                Integer.parseInt(
                        carIdField.getText()
                )
        );

        rental.setStartDate(
                LocalDate.parse(
                        startDateField.getText()
                )
        );

        rental.setEndDate(
                LocalDate.parse(
                        endDateField.getText()
                )
        );

        rental.setTotalAmount(
                Double.parseDouble(
                        totalAmountField.getText()
                )
        );

        rental.setDeposit(
                Double.parseDouble(
                        depositField.getText()
                )
        );

        rental.setDiscount(
                Double.parseDouble(
                        discountField.getText()
                )
        );

        rental.setContractStatus(
                statusField.getText()
        );

        String result =
                rentalController.createRental(rental);

        JOptionPane.showMessageDialog(this, result);

        loadRentals();
    }

    // LOAD RENTALS
    // =========================
    private void loadRentals() {

        List<RentalContract> rentals =
                rentalController.getAllRentals();

        rentalsArea.setText("");

        for (RentalContract rental : rentals) {

            rentalsArea.append(
                    "Rental ID : "
                            + rental.getRentalId()
                            + " | Customer : "
                            + rental.getCustomerId()
                            + " | Car : "
                            + rental.getCarId()
                            + " | Status : "
                            + rental.getContractStatus()
                            + "\n"
            );
        }
    }

    // SET CAR DATA
    // =========================
    public void setCarData(
            String carName,
            String carPrice
    ) {

        String cleanPrice = carPrice
                .replace("$", "")
                .replace("/ Day", "")
                .trim();

        selectedCarField.setText(carName);

        totalAmountField.setText(cleanPrice);

        statusField.setText("Reserved");
    }
}
