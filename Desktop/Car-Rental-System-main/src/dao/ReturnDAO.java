package dao;

import model.CarReturn;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReturnDAO {

    // INSERT RETURN
    // =========================
    public void insert(CarReturn carReturn) {

        String sql = "INSERT INTO CarReturn (Rental_ID, ReturnDate, CarCondition, Employee_ID) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, carReturn.getRentalId());
            statement.setDate(2, Date.valueOf(carReturn.getReturnDate()));

            statement.setString(3, carReturn.getCondition());
            statement.setInt(4, carReturn.getEmployeeId());
            statement.executeUpdate();

            System.out.println("Return Added Successfully!");
        } catch (SQLException e) {
            System.out.println("Insert Return Failed!");
            e.printStackTrace();
        }
    }

    // UPDATE RETURN
    // =========================
    public void update(CarReturn carReturn) {

        String sql = "UPDATE CarReturn SET Rental_ID = ?, ReturnDate = ?, CarCondition = ?, Employee_ID = ? WHERE Return_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, carReturn.getRentalId());
            statement.setDate(2, Date.valueOf(carReturn.getReturnDate()));
            statement.setString(3, carReturn.getCondition());

            statement.setInt(4, carReturn.getEmployeeId());
            statement.setInt(5, carReturn.getReturnId());
            statement.executeUpdate();

            System.out.println("Return Updated Successfully!");
        } catch (SQLException e) {
            System.out.println("Update Return Failed!");
            e.printStackTrace();
        }
    }

    // DELETE RETURN
    // =========================
    public void delete(int returnId) {

        String sql = "DELETE FROM CarReturn WHERE Return_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, returnId);

            statement.executeUpdate();
            System.out.println("Return Deleted Successfully!");
        } catch (SQLException e) {
            System.out.println("Delete Return Failed!");
            e.printStackTrace();
        }
    }

    // FIND RETURN BY ID
    // =========================
    public CarReturn findById(int returnId) {

        CarReturn carReturn = null;
        String sql = "SELECT * FROM CarReturn WHERE Return_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, returnId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                carReturn = new CarReturn();
                carReturn.setReturnId(resultSet.getInt("Return_ID"));
                carReturn.setRentalId(resultSet.getInt("Rental_ID"));

                carReturn.setReturnDate(resultSet.getDate("ReturnDate").toLocalDate());
                carReturn.setCondition(resultSet.getString("CarCondition"));
                carReturn.setEmployeeId(resultSet.getInt("Employee_ID"));
            }
        } catch (SQLException e) {
            System.out.println("Find Return Failed!");
            e.printStackTrace();
        }
        return carReturn;
    }

    // FIND ALL RETURNS
    // =========================
    public List<CarReturn> findAll() {

        List<CarReturn> returns = new ArrayList<>();
        String sql = "SELECT * FROM CarReturn";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CarReturn carReturn = new CarReturn();
                carReturn.setReturnId(resultSet.getInt("Return_ID"));
                carReturn.setRentalId(resultSet.getInt("Rental_ID"));

                carReturn.setReturnDate(resultSet.getDate("ReturnDate").toLocalDate());
                carReturn.setCondition(resultSet.getString("CarCondition"));
                carReturn.setEmployeeId(resultSet.getInt("Employee_ID"));
                returns.add(carReturn);
            }
        } catch (SQLException e) {
            System.out.println("Find All Returns Failed!");
            e.printStackTrace();
        }
        return returns;
    }

    // FIND RETURN BY RENTAL
    // =========================
    public CarReturn findByRental(int rentalId) {

        CarReturn carReturn = null;
        String sql = "SELECT * FROM CarReturn WHERE Rental_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, rentalId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                carReturn = new CarReturn();
                carReturn.setReturnId(resultSet.getInt("Return_ID"));
                carReturn.setRentalId(resultSet.getInt("Rental_ID"));

                carReturn.setReturnDate(resultSet.getDate("ReturnDate").toLocalDate());
                carReturn.setCondition(resultSet.getString("CarCondition"));
                carReturn.setEmployeeId(resultSet.getInt("Employee_ID"));
            }
        } catch (SQLException e) {
            System.out.println("Find Return By Rental Failed!");
            e.printStackTrace();
        }
        return carReturn;
    }

    // CHECK RETURN EXISTS
    // =========================
    public boolean exists(int returnId) {

        String sql = "SELECT * FROM CarReturn WHERE Return_ID = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, returnId);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Check Return Exists Failed!");
            e.printStackTrace();
        }
        return false;
    }
}