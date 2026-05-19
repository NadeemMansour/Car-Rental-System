package dao;

import model.Payment;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    // INSERT PAYMENT
    // =========================
    public void insert(Payment payment) {

        String sql = "INSERT INTO Payment (Rental_ID, Amount, PaymentDate, PaymentMethod) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, payment.getRentalId());

            statement.setDouble(2, payment.getAmount());
            statement.setDate(3, Date.valueOf(payment.getPaymentDate()));
            statement.setString(4, payment.getPaymentMethod());

            statement.executeUpdate();
            System.out.println("Payment Added Successfully!");
        } catch (SQLException e) {
            System.out.println("Insert Payment Failed!");
            e.printStackTrace();
        }
    }

    // UPDATE PAYMENT
    // =========================
    public void update(Payment payment) {

        String sql = "UPDATE Payment SET Rental_ID = ?, Amount = ?, PaymentDate = ?, PaymentMethod = ? WHERE Payment_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, payment.getRentalId());

            statement.setDouble(2, payment.getAmount());
            statement.setDate(3, Date.valueOf(payment.getPaymentDate()));
            statement.setString(4, payment.getPaymentMethod());

            statement.setInt(5, payment.getPaymentId());
            statement.executeUpdate();
            System.out.println("Payment Updated Successfully!");
        } catch (SQLException e) {
            System.out.println("Update Payment Failed!");
            e.printStackTrace();
        }
    }

    // DELETE PAYMENT
    // =========================
    public void delete(int paymentId) {

        String sql = "DELETE FROM Payment WHERE Payment_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paymentId);

            statement.executeUpdate();
            System.out.println("Payment Deleted Successfully!");
        } catch (SQLException e) {
            System.out.println("Delete Payment Failed!");
            e.printStackTrace();
        }
    }

    // FIND PAYMENT BY ID
    // =========================
    public Payment findById(int paymentId) {

        Payment payment = null;
        String sql = "SELECT * FROM Payment WHERE Payment_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paymentId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                payment = extractPayment(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Find Payment Failed!");
            e.printStackTrace();
        }
        return payment;
    }

    // FIND ALL PAYMENTS
    // =========================
    public List<Payment> findAll() {

        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payment";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                payments.add(extractPayment(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Find All Payments Failed!");
            e.printStackTrace();
        }
        return payments;
    }

    // FIND PAYMENTS BY RENTAL
    // =========================
    public List<Payment> findByRental(int rentalId) {

        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payment WHERE Rental_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, rentalId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                payments.add(extractPayment(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Find Payments By Rental Failed!");
            e.printStackTrace();
        }
        return payments;
    }

    // CHECK PAYMENT EXISTS
    // =========================
    public boolean exists(int paymentId) {

        String sql = "SELECT * FROM Payment WHERE Payment_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paymentId);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Check Payment Exists Failed!");
            e.printStackTrace();
        }
        return false;
    }

    // GET TOTAL PAYMENTS
    // =========================
    public double getTotalPayments() {

        double total = 0;
        String sql = "SELECT SUM(Amount) FROM Payment";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                total = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Calculate Total Payments Failed!");
            e.printStackTrace();
        }
        return total;
    }

    // GET TOTAL PAYMENTS BY RENTAL
    // =========================
    public double getTotalPaymentsByRental(int rentalId) {

        double total = 0;
        String sql = "SELECT SUM(Amount) FROM Payment WHERE Rental_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, rentalId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Calculate Rental Payments Failed!");
            e.printStackTrace();
        }
        return total;
    }

    // EXTRACT PAYMENT
    // =========================
    private Payment extractPayment(ResultSet resultSet) throws SQLException {

        Payment payment = new Payment();
        payment.setPaymentId(resultSet.getInt("Payment_ID"));
        payment.setRentalId(resultSet.getInt("Rental_ID"));

        payment.setAmount(resultSet.getDouble("Amount"));
        payment.setPaymentDate(resultSet.getDate("PaymentDate").toLocalDate());
        payment.setPaymentMethod(resultSet.getString("PaymentMethod"));

        return payment;
    }
}