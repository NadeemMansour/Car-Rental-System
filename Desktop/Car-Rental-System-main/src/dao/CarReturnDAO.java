package dao;

import model.CarReturn;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarReturnDAO {

    // =========================
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

            System.out.println("Car Return Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Car Return Failed!");
            e.printStackTrace();
        }
    }

    // =========================
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

                carReturn = extractReturn(resultSet);
            }

        } catch (SQLException e) {

            System.out.println("Find Car Return Failed!");
            e.printStackTrace();
        }

        return carReturn;
    }

    // =========================
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

                returns.add(extractReturn(resultSet));
            }

        } catch (SQLException e) {

            System.out.println("Find All Returns Failed!");
            e.printStackTrace();
        }

        return returns;
    }

    // =========================
    // EXTRACT RETURN
    // =========================
    private CarReturn extractReturn(ResultSet resultSet) throws SQLException {

        CarReturn carReturn = new CarReturn();

        carReturn.setReturnId(resultSet.getInt("Return_ID"));

        carReturn.setRentalId(resultSet.getInt("Rental_ID"));

        carReturn.setReturnDate(resultSet.getDate("ReturnDate").toLocalDate());

        carReturn.setCondition(resultSet.getString("CarCondition"));

        carReturn.setEmployeeId(resultSet.getInt("Employee_ID"));

        return carReturn;
    }
}