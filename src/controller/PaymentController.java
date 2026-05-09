package controller;

import model.Payment;
import service.PaymentService;

import java.util.List;

public class PaymentController {

    private final PaymentService service = new PaymentService();

    // =========================
    // ➕ ADD PAYMENT (الدالة المطلوبة من الـ UI)
    // =========================
    public Response<String> addPayment(Payment p) {

        if (!isValid(p)) {
            return Response.error("Invalid Payment Data");
        }

        try {
            service.processPayment(p);
            return Response.success("Payment Added Successfully", null);

        } catch (Exception e) {
            return Response.error("Payment Failed: " + e.getMessage());
        }
    }

    // =========================
    // 📋 GET ALL PAYMENTS
    // =========================
    public Response<List<Payment>> getAllPayments() {

        List<Payment> list = service.getAllPayments();

        if (list == null || list.isEmpty()) {
            return Response.error("No Payments Found");
        }

        return Response.success("Payments Loaded", list);
    }

    // =========================
    // 📄 GET BY CONTRACT
    // =========================
    public Response<List<Payment>> getByContract(int contractId) {

        if (contractId <= 0) {
            return Response.error("Invalid Contract ID");
        }

        return Response.success(
                "Payments Loaded",
                service.getPaymentsByRental(contractId)
        );
    }

    // =========================
    // 🧠 VALIDATION
    // =========================
    private boolean isValid(Payment p) {

        return p != null
                && p.getContractId() > 0
                && p.getAmount() > 0
                && p.getPaymentDate() != null
                && p.getPaymentMethod() != null
                && !p.getPaymentMethod().isBlank();
    }
}

// package controller;

// import model.Payment;
// import service.PaymentService;

// import java.util.List;

// public class PaymentController {

//     private final PaymentService service = new PaymentService();

//     // =========================
//     // 💳 PROCESS PAYMENT
//     // =========================
//     public Response<String> pay(Payment p) {

//         if (!isValidPayment(p)) {
//             return Response.error("Invalid Payment Data");
//         }

//         try {

//             service.processPayment(p);

//             return Response.success("Payment Successful", null);

//         } catch (Exception e) {

//             return Response.error("Payment Failed: " + e.getMessage());
//         }
//     }

//     // =========================
//     // 📄 GET PAYMENTS BY RENTAL
//     // =========================
//     public Response<List<Payment>> getByRental(int rentalId) {

//         if (rentalId <= 0) {
//             return Response.error("Invalid Rental ID");
//         }

//         List<Payment> payments = service.getPaymentsByRental(rentalId);

//         if (payments == null || payments.isEmpty()) {
//             return Response.error("No Payments Found");
//         }

//         return Response.success("Payments Loaded", payments);
//     }

//     // =========================
//     // 🔍 VALIDATION
//     // =========================
//     private boolean isValidPayment(Payment p) {

//         return p != null
//                 && p.getContractId() > 0
//                 && p.getAmount() > 0
//                 && p.getPaymentDate() != null
//                 && p.getPaymentMethod() != null
//                 && !p.getPaymentMethod().isBlank();
//     }
// }