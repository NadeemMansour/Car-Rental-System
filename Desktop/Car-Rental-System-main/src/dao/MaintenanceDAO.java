package dao;

import model.Maintenance;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO {

    // =========================
    // INSERT MAINTENANCE
    // =========================
    public void insert(Maintenance maintenance) {

        String sql = "INSERT INTO Maintenance (Car_ID, ServiceDate, Description, Cost) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, maintenance.getCarId());

            statement.setDate(2, Date.valueOf(maintenance.getServiceDate()));

            statement.setString(3, maintenance.getDescription());

            statement.setDouble(4, maintenance.getCost());

            statement.executeUpdate();

            System.out.println("Maintenance Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Maintenance Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE MAINTENANCE
    // =========================
    public void update(Maintenance maintenance) {

        String sql = "UPDATE Maintenance SET Car_ID = ?, ServiceDate = ?, Description = ?, Cost = ? WHERE Maintenance_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, maintenance.getCarId());

            statement.setDate(2, Date.valueOf(maintenance.getServiceDate()));

            statement.setString(3, maintenance.getDescription());

            statement.setDouble(4, maintenance.getCost());

            statement.setInt(5, maintenance.getMaintenanceId());

            statement.executeUpdate();

            System.out.println("Maintenance Updated Successfully!");

        } catch (SQLException e) {

            System.out.println("Update Maintenance Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE MAINTENANCE
    // =========================
    public void delete(int maintenanceId) {

        String sql = "DELETE FROM Maintenance WHERE Maintenance_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, maintenanceId);

            statement.executeUpdate();

            System.out.println("Maintenance Deleted Successfully!");

        } catch (SQLException e) {

            System.out.println("Delete Maintenance Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // FIND MAINTENANCE BY ID
    // =========================
    public Maintenance findById(int maintenanceId) {

        Maintenance maintenance = null;

        String sql = "SELECT * FROM Maintenance WHERE Maintenance_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, maintenanceId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                maintenance = new Maintenance();

                maintenance.setMaintenanceId(resultSet.getInt("Maintenance_ID"));

                maintenance.setCarId(resultSet.getInt("Car_ID"));

                maintenance.setServiceDate(resultSet.getDate("ServiceDate").toLocalDate());

                maintenance.setDescription(resultSet.getString("Description"));

                maintenance.setCost(resultSet.getDouble("Cost"));
            }

        } catch (SQLException e) {

            System.out.println("Find Maintenance Failed!");
            e.printStackTrace();
        }

        return maintenance;
    }

    // =========================
    // FIND ALL MAINTENANCE
    // =========================
    public List<Maintenance> findAll() {

        List<Maintenance> maintenanceList = new ArrayList<>();

        String sql = "SELECT * FROM Maintenance";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Maintenance maintenance = new Maintenance();

                maintenance.setMaintenanceId(resultSet.getInt("Maintenance_ID"));

                maintenance.setCarId(resultSet.getInt("Car_ID"));

                maintenance.setServiceDate(resultSet.getDate("ServiceDate").toLocalDate());

                maintenance.setDescription(resultSet.getString("Description"));

                maintenance.setCost(resultSet.getDouble("Cost"));

                maintenanceList.add(maintenance);
            }

        } catch (SQLException e) {

            System.out.println("Find All Maintenance Failed!");
            e.printStackTrace();
        }

        return maintenanceList;
    }

    // =========================
    // FIND MAINTENANCE BY CAR
    // =========================
    public List<Maintenance> findByCar(int carId) {

        List<Maintenance> maintenanceList = new ArrayList<>();

        String sql = "SELECT * FROM Maintenance WHERE Car_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, carId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Maintenance maintenance = new Maintenance();

                maintenance.setMaintenanceId(resultSet.getInt("Maintenance_ID"));

                maintenance.setCarId(resultSet.getInt("Car_ID"));

                maintenance.setServiceDate(resultSet.getDate("ServiceDate").toLocalDate());

                maintenance.setDescription(resultSet.getString("Description"));

                maintenance.setCost(resultSet.getDouble("Cost"));

                maintenanceList.add(maintenance);
            }

        } catch (SQLException e) {

            System.out.println("Find Maintenance By Car Failed!");
            e.printStackTrace();
        }

        return maintenanceList;
    }

    // =========================
    // CHECK MAINTENANCE EXISTS
    // =========================
    public boolean exists(int maintenanceId) {

        String sql = "SELECT * FROM Maintenance WHERE Maintenance_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, maintenanceId);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            System.out.println("Check Maintenance Exists Failed!");
            e.printStackTrace();
        }

        return false;
    }
}