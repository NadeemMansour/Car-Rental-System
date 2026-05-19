package dao;

import model.Car;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    // =========================
    // INSERT CAR
    // =========================
    public void insert(Car car) {

        String sql = """
                INSERT INTO Car
                (PlateNumber, ChassisNumber, Brand, Model, Year, Color, Status, DailyPrice)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, car.getPlateNumber());
            statement.setString(2, car.getChassisNumber());
            statement.setString(3, car.getBrand());
            statement.setString(4, car.getModel());
            statement.setInt(5, car.getYear());
            statement.setString(6, car.getColor());
            statement.setString(7, car.getStatus());
            statement.setDouble(8, car.getDailyPrice());

            statement.executeUpdate();

            System.out.println("Car Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Car Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE CAR
    // =========================
    public void update(Car car) {

        String sql = """
                UPDATE Car
                SET PlateNumber = ?,
                    ChassisNumber = ?,
                    Brand = ?,
                    Model = ?,
                    Year = ?,
                    Color = ?,
                    Status = ?,
                    DailyPrice = ?
                WHERE Car_ID = ?
                """;

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, car.getPlateNumber());
            statement.setString(2, car.getChassisNumber());
            statement.setString(3, car.getBrand());
            statement.setString(4, car.getModel());
            statement.setInt(5, car.getYear());
            statement.setString(6, car.getColor());
            statement.setString(7, car.getStatus());
            statement.setDouble(8, car.getDailyPrice());
            statement.setInt(9, car.getCarId());

            statement.executeUpdate();

            System.out.println("Car Updated Successfully!");

        } catch (SQLException e) {

            System.out.println("Update Car Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE CAR
    // =========================
    public void delete(int carId) {

        String sql = "DELETE FROM Car WHERE Car_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, carId);

            statement.executeUpdate();

            System.out.println("Car Deleted Successfully!");

        } catch (SQLException e) {

            System.out.println("Delete Car Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // FIND CAR BY ID
    // =========================
    public Car findById(int carId) {

        String sql = "SELECT * FROM Car WHERE Car_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, carId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Car car = new Car();

                car.setCarId(resultSet.getInt("Car_ID"));
                car.setPlateNumber(resultSet.getString("PlateNumber"));
                car.setChassisNumber(resultSet.getString("ChassisNumber"));
                car.setBrand(resultSet.getString("Brand"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setStatus(resultSet.getString("Status"));
                car.setDailyPrice(resultSet.getDouble("DailyPrice"));

                return car;
            }

        } catch (SQLException e) {

            System.out.println("Find Car Failed!");
            e.printStackTrace();
        }

        return null;
    }

    // =========================
    // FIND ALL CARS
    // =========================
    public List<Car> findAll() {

        List<Car> cars = new ArrayList<>();

        String sql = "SELECT * FROM Car";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Car car = new Car();

                car.setCarId(resultSet.getInt("Car_ID"));
                car.setPlateNumber(resultSet.getString("PlateNumber"));
                car.setChassisNumber(resultSet.getString("ChassisNumber"));
                car.setBrand(resultSet.getString("Brand"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setStatus(resultSet.getString("Status"));
                car.setDailyPrice(resultSet.getDouble("DailyPrice"));

                cars.add(car);
            }

        } catch (SQLException e) {

            System.out.println("Find All Cars Failed!");
            e.printStackTrace();
        }

        return cars;
    }

    // =========================
    // FIND BY STATUS
    // =========================
    public List<Car> findByStatus(String status) {

        List<Car> cars = new ArrayList<>();

        String sql = "SELECT * FROM Car WHERE Status = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, status);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Car car = new Car();

                car.setCarId(resultSet.getInt("Car_ID"));
                car.setPlateNumber(resultSet.getString("PlateNumber"));
                car.setChassisNumber(resultSet.getString("ChassisNumber"));
                car.setBrand(resultSet.getString("Brand"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setStatus(resultSet.getString("Status"));
                car.setDailyPrice(resultSet.getDouble("DailyPrice"));

                cars.add(car);
            }

        } catch (SQLException e) {

            System.out.println("Find Cars By Status Failed!");
            e.printStackTrace();
        }

        return cars;
    }

    // =========================
    // FIND BY BRAND
    // =========================
    public List<Car> findByBrand(String brand) {

        List<Car> cars = new ArrayList<>();

        String sql = "SELECT * FROM Car WHERE Brand = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, brand);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Car car = new Car();

                car.setCarId(resultSet.getInt("Car_ID"));
                car.setPlateNumber(resultSet.getString("PlateNumber"));
                car.setChassisNumber(resultSet.getString("ChassisNumber"));
                car.setBrand(resultSet.getString("Brand"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setStatus(resultSet.getString("Status"));
                car.setDailyPrice(resultSet.getDouble("DailyPrice"));

                cars.add(car);
            }

        } catch (SQLException e) {

            System.out.println("Find Cars By Brand Failed!");
            e.printStackTrace();
        }

        return cars;
    }

    // =========================
    // FIND BY MODEL
    // =========================
    public List<Car> findByModel(String model) {

        List<Car> cars = new ArrayList<>();

        String sql = "SELECT * FROM Car WHERE Model = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, model);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Car car = new Car();

                car.setCarId(resultSet.getInt("Car_ID"));
                car.setPlateNumber(resultSet.getString("PlateNumber"));
                car.setChassisNumber(resultSet.getString("ChassisNumber"));
                car.setBrand(resultSet.getString("Brand"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setStatus(resultSet.getString("Status"));
                car.setDailyPrice(resultSet.getDouble("DailyPrice"));

                cars.add(car);
            }

        } catch (SQLException e) {

            System.out.println("Find Cars By Model Failed!");
            e.printStackTrace();
        }

        return cars;
    }

    // =========================
    // FIND BY PLATE NUMBER
    // =========================
    public Car findByPlateNumber(String plateNumber) {

        String sql = "SELECT * FROM Car WHERE PlateNumber = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, plateNumber);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Car car = new Car();

                car.setCarId(resultSet.getInt("Car_ID"));
                car.setPlateNumber(resultSet.getString("PlateNumber"));
                car.setChassisNumber(resultSet.getString("ChassisNumber"));
                car.setBrand(resultSet.getString("Brand"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setStatus(resultSet.getString("Status"));
                car.setDailyPrice(resultSet.getDouble("DailyPrice"));

                return car;
            }

        } catch (SQLException e) {

            System.out.println("Find Car By Plate Number Failed!");
            e.printStackTrace();
        }

        return null;
    }

    // =========================
    // FIND BY YEAR
    // =========================
    public List<Car> findByYear(int year) {

        List<Car> cars = new ArrayList<>();

        String sql = "SELECT * FROM Car WHERE Year = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, year);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Car car = new Car();

                car.setCarId(resultSet.getInt("Car_ID"));
                car.setPlateNumber(resultSet.getString("PlateNumber"));
                car.setChassisNumber(resultSet.getString("ChassisNumber"));
                car.setBrand(resultSet.getString("Brand"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setStatus(resultSet.getString("Status"));
                car.setDailyPrice(resultSet.getDouble("DailyPrice"));

                cars.add(car);
            }

        } catch (SQLException e) {

            System.out.println("Find Cars By Year Failed!");
            e.printStackTrace();
        }

        return cars;
    }

    // =========================
    // FIND BY PRICE RANGE
    // =========================
    public List<Car> findByPriceRange(double min, double max) {

        List<Car> cars = new ArrayList<>();

        String sql = "SELECT * FROM Car WHERE DailyPrice BETWEEN ? AND ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDouble(1, min);
            statement.setDouble(2, max);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Car car = new Car();

                car.setCarId(resultSet.getInt("Car_ID"));
                car.setPlateNumber(resultSet.getString("PlateNumber"));
                car.setChassisNumber(resultSet.getString("ChassisNumber"));
                car.setBrand(resultSet.getString("Brand"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setStatus(resultSet.getString("Status"));
                car.setDailyPrice(resultSet.getDouble("DailyPrice"));

                cars.add(car);
            }

        } catch (SQLException e) {

            System.out.println("Find Cars By Price Range Failed!");
            e.printStackTrace();
        }

        return cars;
    }

    // =========================
    // CHECK CAR EXISTS
    // =========================
    public boolean exists(int carId) {

        String sql = "SELECT * FROM Car WHERE Car_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, carId);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            System.out.println("Check Car Exists Failed!");
            e.printStackTrace();
        }

        return false;
    }

    // =========================
    // COUNT BY STATUS
    // =========================
    public int countByStatus(String status) {

        String sql = "SELECT COUNT(*) FROM Car WHERE Status = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, status);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt(1);
            }

        } catch (SQLException e) {

            System.out.println("Count Cars By Status Failed!");
            e.printStackTrace();
        }

        return 0;
    }

    // =========================
    // GET AVERAGE DAILY PRICE
    // =========================
    public double getAverageDailyPrice() {

        String sql = "SELECT AVG(DailyPrice) FROM Car";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getDouble(1);
            }

        } catch (SQLException e) {

            System.out.println("Get Average Daily Price Failed!");
            e.printStackTrace();
        }

        return 0;
    }
}