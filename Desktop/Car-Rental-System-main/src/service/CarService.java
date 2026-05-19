package service;

import dao.CarDAO;
import model.Car;
import util.Constants;

import java.util.List;

public class CarService {

    private final CarDAO carDAO = new CarDAO();

    // =========================
    // ADD CAR
    // =========================
    public void addCar(Car car) {

        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }

        carDAO.insert(car);
    }

    // =========================
    // UPDATE CAR
    // =========================
    public void updateCar(Car car) {

        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }

        carDAO.update(car);
    }

    // =========================
    // DELETE CAR
    // =========================
    public void deleteCar(int carId) {

        if (carId <= 0) {
            throw new IllegalArgumentException("Invalid Car ID");
        }

        carDAO.delete(carId);
    }

    // =========================
    // GET CAR BY ID
    // =========================
    public Car getCarById(int carId) {

        if (carId <= 0) {
            throw new IllegalArgumentException("Invalid Car ID");
        }

        return carDAO.findById(carId);
    }

    // =========================
    // GET ALL CARS
    // =========================
    public List<Car> getAllCars() {

        return carDAO.findAll();
    }

    // =========================
    // GET AVAILABLE CARS
    // =========================
    public List<Car> getAvailableCars() {

        return carDAO.findByStatus(Constants.AVAILABLE);
    }

    // =========================
    // SEARCH BY BRAND
    // =========================
    public List<Car> searchByBrand(String brand) {

        return carDAO.findByBrand(brand);
    }

    // =========================
    // SEARCH BY MODEL
    // =========================
    public List<Car> searchByModel(String model) {

        return carDAO.findByModel(model);
    }

    // =========================
    // MARK AS RENTED
    // =========================
    public void markAsRented(int carId) {

        Car car = carDAO.findById(carId);

        if (car != null) {

            car.setStatus(Constants.RENTED);

            carDAO.update(car);
        }
    }

    // =========================
    // MARK AS AVAILABLE
    // =========================
    public void markAsAvailable(int carId) {

        Car car = carDAO.findById(carId);

        if (car != null) {

            car.setStatus(Constants.AVAILABLE);

            carDAO.update(car);
        }
    }

    // =========================
    // SEND TO MAINTENANCE
    // =========================
    public void sendToMaintenance(int carId) {

        Car car = carDAO.findById(carId);

        if (car != null) {

            car.setStatus(Constants.MAINTENANCE);

            carDAO.update(car);
        }
    }

    // =========================
    // CHECK CAR AVAILABLE
    // =========================
    public boolean isCarAvailable(int carId) {

        Car car = carDAO.findById(carId);

        return car != null &&
                Constants.AVAILABLE.equalsIgnoreCase(car.getStatus());
    }
}