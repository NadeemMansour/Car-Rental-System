package service;

import dao.CarDAO;
import dao.RentalDAO;
import model.Car;
import model.RentalContract;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class RentalService {

    private final RentalDAO rentalDAO = new RentalDAO();

    private final CarDAO carDAO = new CarDAO();

    // =========================
    // CREATE RENTAL
    // =========================
    public void createRental(RentalContract rental) {

        if (rental == null) {
            throw new IllegalArgumentException("Rental cannot be null");
        }

        if (rental.getCustomerId() <= 0) {
            throw new IllegalArgumentException("Invalid Customer ID");
        }

        if (rental.getCarId() <= 0) {
            throw new IllegalArgumentException("Invalid Car ID");
        }

        if (rental.getStartDate() == null || rental.getEndDate() == null) {
            throw new IllegalArgumentException("Rental dates are required");
        }

        if (rental.getStartDate().isAfter(rental.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        if (!isCarAvailable(rental.getCarId())) {
            throw new IllegalArgumentException("Car is not available");
        }

        if (rental.getDeposit() < 0 || rental.getDiscount() < 0) {
            throw new IllegalArgumentException("Invalid financial values");
        }

        rentalDAO.insert(rental);
    }

    // =========================
    // UPDATE RENTAL
    // =========================
    public void updateRental(RentalContract rental) {

        if (rental == null) {
            throw new IllegalArgumentException("Rental cannot be null");
        }

        rentalDAO.update(rental);
    }

    // =========================
    // DELETE RENTAL
    // =========================
    public void deleteRental(int rentalId) {

        if (rentalId <= 0) {
            throw new IllegalArgumentException("Invalid Rental ID");
        }

        rentalDAO.delete(rentalId);
    }

    // =========================
    // CANCEL RENTAL
    // =========================
    public void cancelRental(int rentalId) {

        if (rentalId <= 0) {
            throw new IllegalArgumentException("Invalid Rental ID");
        }

        rentalDAO.delete(rentalId);
    }

    // =========================
    // GET RENTAL BY ID
    // =========================
    public RentalContract getRentalById(int rentalId) {

        if (rentalId <= 0) {
            throw new IllegalArgumentException("Invalid Rental ID");
        }

        return rentalDAO.findById(rentalId);
    }

    // =========================
    // GET ALL RENTALS
    // =========================
    public List<RentalContract> getAllRentals() {
        return rentalDAO.findAll();
    }

    // =========================
    // GET ACTIVE RENTALS
    // =========================
    public List<RentalContract> getActiveRentals() {
        return rentalDAO.findActive();
    }

    // =========================
    // GET RENTALS BY CUSTOMER
    // =========================
    public List<RentalContract> getRentalsByCustomer(int customerId) {

        if (customerId <= 0) {
            throw new IllegalArgumentException("Invalid Customer ID");
        }

        return rentalDAO.findByCustomer(customerId);
    }

    // =========================
    // CALCULATE RENTAL DAYS
    // =========================
    public long calculateDays(LocalDate startDate, LocalDate endDate) {

        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Invalid dates");
        }

        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    // =========================
    // CALCULATE TOTAL AMOUNT
    // =========================
    public double calculateTotalAmount(double dailyPrice, long days) {

        if (dailyPrice < 0 || days < 0) {
            throw new IllegalArgumentException("Invalid values");
        }

        return dailyPrice * days;
    }

    // =========================
    // CHECK CAR AVAILABILITY
    // =========================
    public boolean isCarAvailable(int carId) {

        Car car = carDAO.findById(carId);

        if (car == null) {
            return false;
        }

        return car.getStatus().equalsIgnoreCase("AVAILABLE");
    }

    // =========================
    // EXTEND RENTAL
    // =========================
    public void extendRental(int rentalId, LocalDate newEndDate) {

        RentalContract rental = rentalDAO.findById(rentalId);

        if (rental == null) {
            throw new IllegalArgumentException("Rental not found");
        }

        if (newEndDate == null) {
            throw new IllegalArgumentException("New end date cannot be null");
        }

        if (newEndDate.isBefore(rental.getEndDate())) {
            throw new IllegalArgumentException("Invalid new end date");
        }

        rental.setEndDate(newEndDate);

        rentalDAO.update(rental);
    }

    // =========================
    // FINISH RENTAL
    // =========================
    public void finishRental(int rentalId) {

        RentalContract rental = rentalDAO.findById(rentalId);

        if (rental == null) {
            throw new IllegalArgumentException("Rental not found");
        }

        rental.setContractStatus("FINISHED");

        rentalDAO.update(rental);
    }
}