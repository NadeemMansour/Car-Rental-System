package view;

import controller.CarController;
import model.Car;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class CarManagementUI extends JFrame {

    private JPanel leftImagePanel;
    private JPanel rightFormPanel;
    private JLabel pageTitleLabel;

    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel yearLabel;
    private JLabel colorLabel;
    private JLabel plateNumberLabel;
    private JLabel dailyPriceLabel;
    private JLabel statusLabel;

    private JTextField brandTextField;
    private JTextField modelTextField;
    private JTextField yearTextField;
    private JTextField colorTextField;
    private JTextField plateNumberTextField;
    private JTextField dailyPriceTextField;
    private JTextField statusTextField;

    private JButton addCarButton;
    private JButton updateCarButton;
    private JButton deleteCarButton;
    private JButton loadCarsButton;
    private JButton backToDashboardButton;

    private JTextArea carsDisplayArea;
    private JScrollPane carsScrollPane;

    private final CarController carController = new CarController();

    public CarManagementUI() {
        initializeFrame();
        initializeLeftImagePanel();

        initializeRightFormPanel();
        initializeButtonActions();
        setVisible(true);
    }

    // FRAME
    // =========================
    private void initializeFrame() {

        setTitle("Car Management");
        ImageIcon appIcon = new ImageIcon("src/LocalIcon.png");

        setIconImage(appIcon.getImage());
        setSize(1300, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
    }

    // LEFT IMAGE PANEL
    // =========================
    private void initializeLeftImagePanel() {

        leftImagePanel = new JPanel();
        leftImagePanel.setBounds(0, 0, 520, 760);
        leftImagePanel.setLayout(null);
        leftImagePanel.setBackground(Color.BLACK);

        ImageIcon wallpaperIcon = new ImageIcon("src/image/LeftIcon.png");
        Image wallpaperImage = wallpaperIcon.getImage().getScaledInstance(520, 760, Image.SCALE_SMOOTH);
        JLabel wallpaperLabel = new JLabel(new ImageIcon(wallpaperImage));
        wallpaperLabel.setBounds(0, 0, 520, 760);

        JLabel leftPanelTitle = new JLabel("Luxury Cars");
        leftPanelTitle.setForeground(Color.WHITE);
        leftPanelTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
        leftPanelTitle.setBounds(120, 40, 300, 40);

        leftImagePanel.add(leftPanelTitle);
        leftImagePanel.add(wallpaperLabel);

        add(leftImagePanel);
    }

    // RIGHT FORM PANEL
    // =========================
    private void initializeRightFormPanel() {

        rightFormPanel = new JPanel();
        rightFormPanel.setBounds(520, 0, 780, 760);
        rightFormPanel.setBackground(new Color(12, 17, 33));
        rightFormPanel.setLayout(null);

        pageTitleLabel = new JLabel("Car Management");
        pageTitleLabel.setForeground(new Color(255, 215, 0));
        pageTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
        pageTitleLabel.setBounds(220, 30, 400, 40);

        JPanel titleLinePanel = new JPanel();
        titleLinePanel.setBackground(new Color(255, 215, 0));
        titleLinePanel.setBounds(220, 80, 260, 4);

        brandLabel = createLabel("Brand", 120);

        modelLabel = createLabel("Model", 175);

        yearLabel = createLabel("Year", 230);

        colorLabel = createLabel("Color", 285);

        plateNumberLabel = createLabel("Plate Number", 340);

        dailyPriceLabel = createLabel("Daily Price", 395);

        statusLabel = createLabel("Status", 450);

        brandTextField = createTextField(120);

        modelTextField = createTextField(175);

        yearTextField = createTextField(230);

        colorTextField = createTextField(285);

        plateNumberTextField = createTextField(340);

        dailyPriceTextField = createTextField(395);

        statusTextField = createTextField(450);

        addCarButton = createButton("Add", new Color(0, 191, 255), 40);

        updateCarButton = createButton("Update", new Color(22, 30, 50), 210);

        deleteCarButton = createButton("Delete", new Color(22, 30, 50), 380);

        loadCarsButton = createButton("Cars", new Color(22, 30, 50), 550);

        backToDashboardButton = createButton("Back", new Color(255, 140, 0), 295);

        carsDisplayArea = new JTextArea();

        carsDisplayArea.setBackground(new Color(20, 25, 45));
        carsDisplayArea.setForeground(Color.WHITE);
        carsDisplayArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        carsDisplayArea.setEditable(false);

        carsScrollPane = new JScrollPane(carsDisplayArea);
        carsScrollPane.setBounds(40, 610, 700, 90);
        carsScrollPane.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        rightFormPanel.add(pageTitleLabel);
        rightFormPanel.add(titleLinePanel);
        rightFormPanel.add(brandLabel);
        rightFormPanel.add(modelLabel);
        rightFormPanel.add(yearLabel);
        rightFormPanel.add(colorLabel);
        rightFormPanel.add(plateNumberLabel);
        rightFormPanel.add(dailyPriceLabel);
        rightFormPanel.add(statusLabel);
        rightFormPanel.add(brandTextField);
        rightFormPanel.add(modelTextField);
        rightFormPanel.add(yearTextField);
        rightFormPanel.add(colorTextField);
        rightFormPanel.add(plateNumberTextField);
        rightFormPanel.add(dailyPriceTextField);
        rightFormPanel.add(statusTextField);
        rightFormPanel.add(addCarButton);
        rightFormPanel.add(updateCarButton);
        rightFormPanel.add(deleteCarButton);
        rightFormPanel.add(loadCarsButton);
        rightFormPanel.add(backToDashboardButton);
        rightFormPanel.add(carsScrollPane);

        add(rightFormPanel);
    }

    // LABEL
    // =========================
    private JLabel createLabel(String text, int yPosition) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);

        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label.setBounds(40, yPosition, 150, 30);

        return label;
    }

    // TEXT FIELD
    // =========================
    private JTextField createTextField(int yPosition) {

        JTextField textField = new JTextField();
        textField.setBounds(220, yPosition, 520, 40);
        textField.setBackground(new Color(22, 30, 50));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        return textField;
    }

    // BUTTON
    // =========================
    private JButton createButton(String buttonText, Color backgroundColor, int xPosition) {

        JButton button = new JButton(buttonText);
        button.setBounds(xPosition, 540, 140, 45);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));

        if (!buttonText.equals("Add") && !buttonText.equals("Back")) {
            button.setBackground(new Color(22, 30, 50));
            button.setBorder(new LineBorder(new Color(0, 191, 255), 2));

        } else {
            button.setBorderPainted(false);
        }

        return button;
    }

    // BUTTON ACTIONS
    // =========================
    private void initializeButtonActions() {

        addCarButton.addActionListener(e -> addCar());

        updateCarButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Update Feature Coming Soon"));

        deleteCarButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Delete Feature Coming Soon"));

        loadCarsButton.addActionListener(e -> loadCars());

        backToDashboardButton.addActionListener(e -> {
            new Dashboard().setVisible(true);
            this.dispose();
        });
    }

    // ADD CAR
    // =========================
    private void addCar() {

        Car car = new Car();
        car.setBrand(brandTextField.getText());
        car.setModel(modelTextField.getText());
        car.setYear(Integer.parseInt(yearTextField.getText()));
        car.setColor(colorTextField.getText());
        car.setPlateNumber(plateNumberTextField.getText());
        car.setDailyPrice(Double.parseDouble(dailyPriceTextField.getText()));
        car.setStatus(statusTextField.getText());

        String result = carController.addCar(car);

        JOptionPane.showMessageDialog(this, result);
        loadCars();
    }

    // LOAD CARS
    // =========================
    private void loadCars() {

        List<Car> carsList = carController.getAllCars();

        carsDisplayArea.setText("");

        for (Car car : carsList) {
            carsDisplayArea.append(
                    "ID : "
                            + car.getCarId()
                            + " | Brand : "
                            + car.getBrand()
                            + " | Model : "
                            + car.getModel()
                            + " | Plate : "
                            + car.getPlateNumber()
                            + " | Status : "
                            + car.getStatus()
                            + "\n");
        }
    }
}