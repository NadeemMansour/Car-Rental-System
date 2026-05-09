package service;

import dao.RentalDAO;
import model.RentalContract;

import java.time.LocalDate;
import java.util.List;

public class RentalService {

    private final RentalDAO rentalDAO = new RentalDAO();

    // ➕ Create Rental
    public void createRental(RentalContract r) {

        // 🔥 Validation (Business Rules)
        if (r == null) {
            throw new IllegalArgumentException("Rental cannot be null");
        }

        if (r.getStartDate() == null || r.getEndDate() == null) {
            throw new IllegalArgumentException("Dates are required");
        }

        if (r.getStartDate().isAfter(r.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        if (r.getCustomerId() <= 0 || r.getCarId() <= 0) {
            throw new IllegalArgumentException("Invalid Customer or Car ID");
        }

        if (r.getDeposit() < 0 || r.getTotalAmount() < 0) {
            throw new IllegalArgumentException("Invalid financial values");
        }

        // 💾 Save
        rentalDAO.insert(r);
    }

    // ✏️ Update Rental
    public void updateRental(RentalContract r) {

        if (r == null) {
            throw new IllegalArgumentException("Rental cannot be null");
        }

        rentalDAO.update(r);
    }

    // ❌ Cancel Rental
    public void cancelRental(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Invalid rental ID");
        }

        rentalDAO.delete(id);
    }

    // 🔍 Get by ID
    public RentalContract getRentalById(int id) {
        return rentalDAO.findById(id);
    }

    // 📋 Get all
    public List<RentalContract> getAllRentals() {
        return rentalDAO.findAll();
    }

    // 🚀 Active rentals
    public List<RentalContract> getActiveRentals() {
        return rentalDAO.findActive();
    }

    // 👤 By customer
    public List<RentalContract> getRentalsByCustomer(int customerId) {
        return rentalDAO.findByCustomer(customerId);
    }

    // 📊 Calculate days (LOCALDATE FIXED)
    public long calculateDays(LocalDate start, LocalDate end) {

        if (start == null || end == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }

        return java.time.temporal.ChronoUnit.DAYS.between(start, end);
    }
}