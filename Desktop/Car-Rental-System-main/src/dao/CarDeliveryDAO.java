package dao;

import model.CarDelivery;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDeliveryDAO {

    // =========================
    // INSERT DELIVERY
    // =========================
    public void insert(CarDelivery delivery) {

        String sql = "INSERT INTO CarDelivery (Rental_ID, DeliveryDate, CarCondition, Employee_ID) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, delivery.getRentalId());

            statement.setDate(2, Date.valueOf(delivery.getDeliveryDate()));

            statement.setString(3, delivery.getCondition());

            statement.setInt(4, delivery.getEmployeeId());

            statement.executeUpdate();

            System.out.println("Car Delivery Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Car Delivery Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // FIND DELIVERY BY ID
    // =========================
    public CarDelivery findById(int deliveryId) {

        CarDelivery delivery = null;

        String sql = "SELECT * FROM CarDelivery WHERE Delivery_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, deliveryId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                delivery = extractDelivery(resultSet);
            }

        } catch (SQLException e) {

            System.out.println("Find Car Delivery Failed!");
            e.printStackTrace();
        }

        return delivery;
    }

    // =========================
    // FIND ALL DELIVERIES
    // =========================
    public List<CarDelivery> findAll() {

        List<CarDelivery> deliveries = new ArrayList<>();

        String sql = "SELECT * FROM CarDelivery";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                deliveries.add(extractDelivery(resultSet));
            }

        } catch (SQLException e) {

            System.out.println("Find All Deliveries Failed!");
            e.printStackTrace();
        }

        return deliveries;
    }

    // =========================
    // EXTRACT DELIVERY
    // =========================
    private CarDelivery extractDelivery(ResultSet resultSet) throws SQLException {

        CarDelivery delivery = new CarDelivery();

        delivery.setDeliveryId(resultSet.getInt("Delivery_ID"));

        delivery.setRentalId(resultSet.getInt("Rental_ID"));

        delivery.setDeliveryDate(resultSet.getDate("DeliveryDate").toLocalDate());

        delivery.setCondition(resultSet.getString("CarCondition"));

        delivery.setEmployeeId(resultSet.getInt("Employee_ID"));

        return delivery;
    }
}