package service;

import dao.PaymentDAO;
import model.Payment;

import java.util.List;

public class PaymentService {

    private final PaymentDAO paymentDAO = new PaymentDAO();

    // =========================
    // PROCESS PAYMENT
    // =========================
    public void processPayment(Payment payment) {

        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }

        paymentDAO.insert(payment);
    }

    // =========================
    // UPDATE PAYMENT
    // =========================
    public void updatePayment(Payment payment) {

        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }

        paymentDAO.update(payment);
    }

    // =========================
    // DELETE PAYMENT
    // =========================
    public void deletePayment(int paymentId) {

        if (paymentId <= 0) {
            throw new IllegalArgumentException("Invalid Payment ID");
        }

        paymentDAO.delete(paymentId);
    }

    // =========================
    // GET PAYMENT BY ID
    // =========================
    public Payment getPaymentById(int paymentId) {

        if (paymentId <= 0) {
            throw new IllegalArgumentException("Invalid Payment ID");
        }

        return paymentDAO.findById(paymentId);
    }

    // =========================
    // GET PAYMENTS BY RENTAL
    // =========================
    public List<Payment> getPaymentsByRental(int rentalId) {

        if (rentalId <= 0) {
            throw new IllegalArgumentException("Invalid Rental ID");
        }

        return paymentDAO.findByRental(rentalId);
    }

    // =========================
    // GET ALL PAYMENTS
    // =========================
    public List<Payment> getAllPayments() {

        return paymentDAO.findAll();
    }

    // =========================
    // CHECK PAYMENT EXISTS
    // =========================
    public boolean paymentExists(int paymentId) {

        if (paymentId <= 0) {
            return false;
        }

        return paymentDAO.exists(paymentId);
    }

    // =========================
    // CALCULATE TOTAL PAYMENTS
    // =========================
    public double calculateTotalPayments() {

        return paymentDAO.getTotalPayments();
    }

    // =========================
    // CALCULATE RENTAL PAYMENTS
    // =========================
    public double calculateRentalPayments(int rentalId) {

        if (rentalId <= 0) {
            throw new IllegalArgumentException("Invalid Rental ID");
        }

        return paymentDAO.getTotalPaymentsByRental(rentalId);
    }
}