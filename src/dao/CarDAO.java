package dao;

import model.Car;
import java.util.List;

public class CarDAO {

    public void insert(Car car) {
        // SQL INSERT
    }

    public void update(Car car) {
        // SQL UPDATE
    }

    public void delete(int carId) {
        // SQL DELETE
    }

    public Car findById(int carId) {
        return null;
    }

    public List<Car> findAll() {
        return null;
    }

    public List<Car> findByStatus(String status) {
        return null;
    }

    public List<Car> findByBrand(String brand) {
        return null;
    }

    public List<Car> findByModel(String model) {
        return null;
    }

    public Car findByPlateNumber(String plateNumber) {
        return null;
    }

    public List<Car> findByYear(int year) {
        return null;
    }

    public List<Car> findByPriceRange(double min, double max) {
        return null;
    }

    public boolean exists(int carId) {
        return false;
    }

    public long countByStatus(String status) {
        return 0;
    }

    public double getAverageDailyPrice() {
        return 0;
    }
}