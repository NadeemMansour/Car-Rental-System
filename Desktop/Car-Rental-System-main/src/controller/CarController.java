package controller;

import model.Car;
import service.CarService;

import java.util.List;

public class CarController {

    private final CarService carService = new CarService();

    // ADD CAR
    // =========================
    public String addCar(Car car) {

        if (car == null) {
            return "Invalid Car Data";
        }

        carService.addCar(car);
        return "Car Added Successfully";
    }

    // UPDATE CAR
    // =========================
    public String updateCar(Car car) {

        if (car == null || car.getCarId() <= 0) {
            return "Invalid Car Data";
        }

        carService.updateCar(car);
        return "Car Updated Successfully";
    }

    // DELETE CAR
    // =========================
    public String deleteCar(int carId) {

        if (carId <= 0) {
            return "Invalid Car ID";
        }

        carService.deleteCar(carId);
        return "Car Deleted Successfully";
    }

    // GET CAR BY ID
    // =========================
    public Car getCarById(int carId) {
        return carService.getCarById(carId);
    }

    // GET ALL CARS
    // =========================
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // GET AVAILABLE CARS
    // =========================
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

    // SEARCH BY BRAND
    // =========================
    public List<Car> searchByBrand(String brand) {
        return carService.searchByBrand(brand);
    }

    // SEARCH BY MODEL
    // =========================
    public List<Car> searchByModel(String model) {
        return carService.searchByModel(model);
    }

    // MARK AS RENTED
    // =========================
    public void markAsRented(int carId) {
        carService.markAsRented(carId);
    }

    // MARK AS AVAILABLE
    // =========================
    public void markAsAvailable(int carId) {
        carService.markAsAvailable(carId);
    }

    // SEND TO MAINTENANCE
    // =========================
    public void sendToMaintenance(int carId) {
        carService.sendToMaintenance(carId);
    }

    // CLEAR FORM
    // =========================
    public Car clearForm() {
        return new Car();
    }
}