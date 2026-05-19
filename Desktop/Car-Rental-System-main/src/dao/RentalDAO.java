package dao;

import model.RentalContract;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO {

    // =========================
    // INSERT RENTAL
    // =========================
    public void insert(RentalContract rental) {

        String sql = "INSERT INTO RentalContract (Customer_ID, Car_ID, StartDate, EndDate, TotalAmount, Deposit, Discount, ContractStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, rental.getCustomerId());
            statement.setInt(2, rental.getCarId());
            statement.setDate(3, Date.valueOf(rental.getStartDate()));
            statement.setDate(4, Date.valueOf(rental.getEndDate()));
            statement.setDouble(5, rental.getTotalAmount());
            statement.setDouble(6, rental.getDeposit());
            statement.setDouble(7, rental.getDiscount());
            statement.setString(8, rental.getContractStatus());

            statement.executeUpdate();
            System.out.println("Rental Added Successfully!");
        } catch (SQLException e) {
            System.out.println("Insert Rental Failed!");
            e.printStackTrace();
        }
    }

    // UPDATE RENTAL
    // =========================
    public void update(RentalContract rental) {

        String sql = "UPDATE RentalContract SET Customer_ID = ?, Car_ID = ?, StartDate = ?, EndDate = ?, TotalAmount = ?, Deposit = ?, Discount = ?, ContractStatus = ? WHERE Rental_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, rental.getCustomerId());
            statement.setInt(2, rental.getCarId());
            statement.setDate(3, Date.valueOf(rental.getStartDate()));
            statement.setDate(4, Date.valueOf(rental.getEndDate()));
            statement.setDouble(5, rental.getTotalAmount());
            statement.setDouble(6, rental.getDeposit());
            statement.setDouble(7, rental.getDiscount());
            statement.setString(8, rental.getContractStatus());
            statement.setInt(9, rental.getRentalId());

            statement.executeUpdate();
            System.out.println("Rental Updated Successfully!");
        } catch (SQLException e) {
            System.out.println("Update Rental Failed!");
            e.printStackTrace();
        }
    }

    // DELETE RENTAL
    // =========================
    public void delete(int rentalId) {

        String sql = "DELETE FROM RentalContract WHERE Rental_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, rentalId);
            statement.executeUpdate();

            System.out.println("Rental Deleted Successfully!");
        } catch (SQLException e) {
            System.out.println("Delete Rental Failed!");
            e.printStackTrace();
        }
    }

    // FIND RENTAL BY ID
    // =========================
    public RentalContract findById(int rentalId) {

        RentalContract rental = null;
        String sql = "SELECT * FROM RentalContract WHERE Rental_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, rentalId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                rental = new RentalContract();

                rental.setRentalId(resultSet.getInt("Rental_ID"));
                rental.setCustomerId(resultSet.getInt("Customer_ID"));
                rental.setCarId(resultSet.getInt("Car_ID"));
                rental.setStartDate(resultSet.getDate("StartDate").toLocalDate());
                rental.setEndDate(resultSet.getDate("EndDate").toLocalDate());
                rental.setTotalAmount(resultSet.getDouble("TotalAmount"));
                rental.setDeposit(resultSet.getDouble("Deposit"));
                rental.setDiscount(resultSet.getDouble("Discount"));
                rental.setContractStatus(resultSet.getString("ContractStatus"));
            }

        } catch (SQLException e) {
            System.out.println("Find Rental Failed!");
            e.printStackTrace();
        }
        return rental;
    }

    // FIND ALL RENTALS
    // =========================
    public List<RentalContract> findAll() {

        List<RentalContract> rentals = new ArrayList<>();
        String sql = "SELECT * FROM RentalContract";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RentalContract rental = new RentalContract();
                rental.setRentalId(resultSet.getInt("Rental_ID"));
                rental.setCustomerId(resultSet.getInt("Customer_ID"));
                rental.setCarId(resultSet.getInt("Car_ID"));
                rental.setStartDate(resultSet.getDate("StartDate").toLocalDate());
                rental.setEndDate(resultSet.getDate("EndDate").toLocalDate());
                rental.setTotalAmount(resultSet.getDouble("TotalAmount"));
                rental.setDeposit(resultSet.getDouble("Deposit"));
                rental.setDiscount(resultSet.getDouble("Discount"));
                rental.setContractStatus(resultSet.getString("ContractStatus"));

                rentals.add(rental);
            }
        } catch (SQLException e) {
            System.out.println("Find All Rentals Failed!");
            e.printStackTrace();
        }
        return rentals;
    }

    // FIND ACTIVE RENTALS
    // =========================
    public List<RentalContract> findActive() {

        List<RentalContract> rentals = new ArrayList<>();
        String sql = "SELECT * FROM RentalContract WHERE ContractStatus = 'ACTIVE'";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RentalContract rental = new RentalContract();
                rental.setRentalId(resultSet.getInt("Rental_ID"));
                rental.setCustomerId(resultSet.getInt("Customer_ID"));
                rental.setCarId(resultSet.getInt("Car_ID"));
                rental.setStartDate(resultSet.getDate("StartDate").toLocalDate());
                rental.setEndDate(resultSet.getDate("EndDate").toLocalDate());
                rental.setTotalAmount(resultSet.getDouble("TotalAmount"));
                rental.setDeposit(resultSet.getDouble("Deposit"));
                rental.setDiscount(resultSet.getDouble("Discount"));
                rental.setContractStatus(resultSet.getString("ContractStatus"));

                rentals.add(rental);
            }
        } catch (SQLException e) {
            System.out.println("Find Active Rentals Failed!");
            e.printStackTrace();
        }
        return rentals;
    }

    // FIND RENTALS BY CUSTOMER
    // =========================
    public List<RentalContract> findByCustomer(int customerId) {

        List<RentalContract> rentals = new ArrayList<>();
        String sql = "SELECT * FROM RentalContract WHERE Customer_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RentalContract rental = new RentalContract();
                rental.setRentalId(resultSet.getInt("Rental_ID"));
                rental.setCustomerId(resultSet.getInt("Customer_ID"));
                rental.setCarId(resultSet.getInt("Car_ID"));
                rental.setStartDate(resultSet.getDate("StartDate").toLocalDate());
                rental.setEndDate(resultSet.getDate("EndDate").toLocalDate());
                rental.setTotalAmount(resultSet.getDouble("TotalAmount"));
                rental.setDeposit(resultSet.getDouble("Deposit"));
                rental.setDiscount(resultSet.getDouble("Discount"));
                rental.setContractStatus(resultSet.getString("ContractStatus"));

                rentals.add(rental);
            }
        } catch (SQLException e) {
            System.out.println("Find Rentals By Customer Failed!");
            e.printStackTrace();
        }
        return rentals;
    }
}