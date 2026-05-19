package dao;

import model.CarDelivery;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {

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

            System.out.println("Delivery Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Delivery Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE DELIVERY
    // =========================
    public void update(CarDelivery delivery) {

        String sql = "UPDATE CarDelivery SET Rental_ID = ?, DeliveryDate = ?, CarCondition = ?, Employee_ID = ? WHERE Delivery_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, delivery.getRentalId());

            statement.setDate(2, Date.valueOf(delivery.getDeliveryDate()));

            statement.setString(3, delivery.getCondition());

            statement.setInt(4, delivery.getEmployeeId());

            statement.setInt(5, delivery.getDeliveryId());

            statement.executeUpdate();

            System.out.println("Delivery Updated Successfully!");

        } catch (SQLException e) {

            System.out.println("Update Delivery Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE DELIVERY
    // =========================
    public void delete(int deliveryId) {

        String sql = "DELETE FROM CarDelivery WHERE Delivery_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, deliveryId);

            statement.executeUpdate();

            System.out.println("Delivery Deleted Successfully!");

        } catch (SQLException e) {

            System.out.println("Delete Delivery Failed!");
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

                delivery = new CarDelivery();

                delivery.setDeliveryId(resultSet.getInt("Delivery_ID"));

                delivery.setRentalId(resultSet.getInt("Rental_ID"));

                delivery.setDeliveryDate(resultSet.getDate("DeliveryDate").toLocalDate());

                delivery.setCondition(resultSet.getString("CarCondition"));

                delivery.setEmployeeId(resultSet.getInt("Employee_ID"));
            }

        } catch (SQLException e) {

            System.out.println("Find Delivery Failed!");
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

                CarDelivery delivery = new CarDelivery();

                delivery.setDeliveryId(resultSet.getInt("Delivery_ID"));

                delivery.setRentalId(resultSet.getInt("Rental_ID"));

                delivery.setDeliveryDate(resultSet.getDate("DeliveryDate").toLocalDate());

                delivery.setCondition(resultSet.getString("CarCondition"));

                delivery.setEmployeeId(resultSet.getInt("Employee_ID"));

                deliveries.add(delivery);
            }

        } catch (SQLException e) {

            System.out.println("Find All Deliveries Failed!");
            e.printStackTrace();
        }

        return deliveries;
    }

    // =========================
    // FIND DELIVERY BY RENTAL
    // =========================
    public CarDelivery findByRental(int rentalId) {

        CarDelivery delivery = null;

        String sql = "SELECT * FROM CarDelivery WHERE Rental_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, rentalId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                delivery = new CarDelivery();

                delivery.setDeliveryId(resultSet.getInt("Delivery_ID"));

                delivery.setRentalId(resultSet.getInt("Rental_ID"));

                delivery.setDeliveryDate(resultSet.getDate("DeliveryDate").toLocalDate());

                delivery.setCondition(resultSet.getString("CarCondition"));

                delivery.setEmployeeId(resultSet.getInt("Employee_ID"));
            }

        } catch (SQLException e) {

            System.out.println("Find Delivery By Rental Failed!");
            e.printStackTrace();
        }

        return delivery;
    }

    // =========================
    // CHECK DELIVERY EXISTS
    // =========================
    public boolean exists(int deliveryId) {

        String sql = "SELECT * FROM CarDelivery WHERE Delivery_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, deliveryId);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            System.out.println("Check Delivery Exists Failed!");
            e.printStackTrace();
        }

        return false;
    }
}