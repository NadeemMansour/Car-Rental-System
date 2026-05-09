package controller;

import model.Car;
import service.CarService;

import java.util.List;

public class CarController {

    private final CarService carService = new CarService();

    // ➕ Add Car
    public Response<String> addCar(Car car) {

        if (car == null) {
            return Response.error("Invalid Car Data");
        }

        carService.addCar(car);
        return Response.success("Car Added Successfully", null);
    }

    // ✏️ Update Car
    public Response<String> updateCar(Car car) {

        if (car == null || car.getCarId() <= 0) {
            return Response.error("Invalid Car Data");
        }

        carService.updateCar(car);
        return Response.success("Car Updated Successfully", null);
    }

    // ❌ Delete Car
    public Response<String> deleteCar(int carId) {

        if (carId <= 0) {
            return Response.error("Invalid Car ID");
        }

        carService.deleteCar(carId);
        return Response.success("Car Deleted Successfully", null);
    }

    // 🔍 Get by ID
    public Response<Car> getCarById(int id) {

        Car car = carService.getCarById(id);

        if (car == null) {
            return Response.error("Car Not Found");
        }

        return Response.success("Car Found", car);
    }

    // 📋 Get All Cars
    public Response<List<Car>> getAllCars() {

        List<Car> cars = carService.getAllCars();

        return Response.success("Cars Loaded", cars);
    }

    // 🚗 Available Cars
    public Response<List<Car>> getAvailableCars() {

        List<Car> cars = carService.getAvailableCars();

        return Response.success("Available Cars Loaded", cars);
    }
}


// package controller;

// import model.Car;
// import service.CarService;

// import java.util.List;

// public class CarController {

//     private CarService carService = new CarService();

//     public String addCar(Car car) {
//         if (car == null) return "Invalid Car Data";

//         carService.addCar(car);
//         return "Car Added Successfully";
//     }

//     public String updateCar(Car car) {
//         if (car == null || car.getCarId() <= 0)
//             return "Invalid Car Data";

//         carService.updateCar(car);
//         return "Car Updated Successfully";
//     }

//     public String deleteCar(int carId) {
//         if (carId <= 0) return "Invalid ID";

//         carService.deleteCar(carId);
//         return "Car Deleted Successfully";
//     }

//     public Car getCarById(int id) {
//         return carService.getCarById(id);
//     }

//     public List<Car> getAllCars() {
//         return carService.getAllCars();
//     }

//     public List<Car> getAvailableCars() {
//         return carService.getAvailableCars();
//     }
// }