package controller;

import model.RentalContract;
import service.RentalService;

import java.time.LocalDate;
import java.util.List;

public class RentalController {

    private final RentalService rentalService = new RentalService();

    // =========================
    // CREATE RENTAL
    // =========================
    public String createRental(RentalContract rental) {

        if (rental == null) {
            return "Invalid Rental Data";
        }

        rentalService.createRental(rental);

        return "Rental Created Successfully";
    }

    // =========================
    // UPDATE RENTAL
    // =========================
    public String updateRental(RentalContract rental) {

        if (rental == null) {
            return "Invalid Rental Data";
        }

        rentalService.updateRental(rental);

        return "Rental Updated Successfully";
    }

    // =========================
    // CANCEL RENTAL
    // =========================
    public String cancelRental(int rentalId) {

        if (rentalId <= 0) {
            return "Invalid Rental ID";
        }

        rentalService.cancelRental(rentalId);

        return "Rental Cancelled Successfully";
    }

    // =========================
    // FINISH RENTAL
    // =========================
    public String finishRental(int rentalId) {

        if (rentalId <= 0) {
            return "Invalid Rental ID";
        }

        rentalService.finishRental(rentalId);

        return "Rental Finished Successfully";
    }

    // =========================
    // EXTEND RENTAL
    // =========================
    public String extendRental(int rentalId, LocalDate newEndDate) {

        if (rentalId <= 0 || newEndDate == null) {
            return "Invalid Rental Data";
        }

        rentalService.extendRental(rentalId, newEndDate);

        return "Rental Extended Successfully";
    }

    // =========================
    // GET RENTAL BY ID
    // =========================
    public RentalContract getRentalById(int rentalId) {

        return rentalService.getRentalById(rentalId);
    }

    // =========================
    // GET ALL RENTALS
    // =========================
    public List<RentalContract> getAllRentals() {

        return rentalService.getAllRentals();
    }

    // =========================
    // GET ACTIVE RENTALS
    // =========================
    public List<RentalContract> getActiveRentals() {

        return rentalService.getActiveRentals();
    }

    // =========================
    // GET CUSTOMER RENTALS
    // =========================
    public List<RentalContract> getCustomerRentals(int customerId) {

        return rentalService.getRentalsByCustomer(customerId);
    }

    // =========================
    // CALCULATE RENTAL AMOUNT
    // =========================
    public double calculateRentalAmount(double dailyPrice, int days) {

        return rentalService.calculateTotalAmount(dailyPrice, days);
    }

    // =========================
    // CLEAR FORM
    // =========================
    public RentalContract clearForm() {

        return new RentalContract();
    }
}