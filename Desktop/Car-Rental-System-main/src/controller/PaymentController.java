package controller;

import model.Payment;
import service.PaymentService;

import java.util.List;

public class PaymentController {

    private final PaymentService paymentService = new PaymentService();

    // =========================
    // PROCESS PAYMENT
    // =========================
    public String processPayment(Payment payment) {

        if (payment == null) {
            return "Invalid Payment Data";
        }

        paymentService.processPayment(payment);

        return "Payment Processed Successfully";
    }

    // =========================
    // UPDATE PAYMENT
    // =========================
    public String updatePayment(Payment payment) {

        if (payment == null) {
            return "Invalid Payment Data";
        }

        paymentService.updatePayment(payment);

        return "Payment Updated Successfully";
    }

    // =========================
    // DELETE PAYMENT
    // =========================
    public String deletePayment(int paymentId) {

        if (paymentId <= 0) {
            return "Invalid Payment ID";
        }

        paymentService.deletePayment(paymentId);

        return "Payment Deleted Successfully";
    }

    // =========================
    // GET PAYMENT BY ID
    // =========================
    public Payment getPaymentById(int paymentId) {

        return paymentService.getPaymentById(paymentId);
    }

    // =========================
    // GET ALL PAYMENTS
    // =========================
    public List<Payment> getAllPayments() {

        return paymentService.getAllPayments();
    }

    // =========================
    // GET PAYMENTS BY RENTAL
    // =========================
    public List<Payment> getPaymentsByRental(int rentalId) {

        return paymentService.getPaymentsByRental(rentalId);
    }

    // =========================
    // CALCULATE TOTAL PAYMENTS
    // =========================
    public double calculateTotalPayments() {

        return paymentService.calculateTotalPayments();
    }

    // =========================
    // PRINT RECEIPT
    // =========================
    public String printReceipt(int paymentId) {

        Payment payment = paymentService.getPaymentById(paymentId);

        if (payment == null) {
            return "Payment Not Found";
        }

        return """
                ===== PAYMENT RECEIPT =====
                Payment ID : %d
                Rental ID  : %d
                Amount      : %.2f
                Date        : %s
                Method      : %s
                ==========================
                """.formatted(
                payment.getPaymentId(),
                payment.getRentalId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getPaymentMethod()
        );
    }

    // =========================
    // CLEAR FORM
    // =========================
    public Payment clearForm() {

        return new Payment();
    }
}