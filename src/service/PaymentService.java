package service;

import dao.PaymentDAO;
import model.Payment;

import java.util.List;

public class PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAO();

    public void processPayment(Payment payment) {
        paymentDAO.insert(payment);
    }

    public List<Payment> getPaymentsByRental(int rentalId) {
        return paymentDAO.findByRental(rentalId);
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.findAll();
    }
}