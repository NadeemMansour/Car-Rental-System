package service;

import dao.CarDAO;
import model.Car;
import util.Constants;

import java.util.List;

public class CarService {

    private final CarDAO carDAO = new CarDAO();

    // ➕ Add Car
    public void addCar(Car car) {
        carDAO.insert(car);
    }

    // ✏️ Update Car
    public void updateCar(Car car) {
        carDAO.update(car);
    }

    // ❌ Delete Car (FIXED)
    public void deleteCar(int id) {
        carDAO.delete(id);
    }

    // 🔍 Get by ID
    public Car getCarById(int carId) {
        return carDAO.findById(carId);
    }

    // 📋 Get all cars
    public List<Car> getAllCars() {
        return carDAO.findAll();
    }

    // 🚗 Available cars
    public List<Car> getAvailableCars() {
        return carDAO.findByStatus(Constants.AVAILABLE);
    }

    // 🔧 Mark as rented
    public void markAsRented(int carId) {

        Car car = carDAO.findById(carId);

        if (car != null) {
            car.setStatus(Constants.RENTED);
            carDAO.update(car);
        }
    }

    // 🟢 Mark as available
    public void markAsAvailable(int carId) {

        Car car = carDAO.findById(carId);

        if (car != null) {
            car.setStatus(Constants.AVAILABLE);
            carDAO.update(car);
        }
    }

    // 🛠️ Maintenance
    public void sendToMaintenance(int carId) {

        Car car = carDAO.findById(carId);

        if (car != null) {
            car.setStatus(Constants.MAINTENANCE);
            carDAO.update(car);
        }
    }

    // ✔ Check availability
    public boolean isCarAvailable(int carId) {

        Car car = carDAO.findById(carId);

        return car != null &&
            Constants.AVAILABLE.equals(car.getStatus());
    }
}