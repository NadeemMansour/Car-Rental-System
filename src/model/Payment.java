package model;

import java.time.LocalDate;

public class Payment {

    private int paymentId;
    private int contractId;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;

    public Payment() {}

    public Payment(int contractId, double amount, LocalDate paymentDate, String paymentMethod) {
        this.contractId = contractId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = "PENDING";
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

// package model;

// import java.time.LocalDate;

// public class Payment {

//     private int paymentId;
//     private int contractId;
//     private double amount;
//     private LocalDate paymentDate;
//     private String paymentMethod;   // CASH, CARD, TRANSFER
//     private String status;          // SUCCESS, FAILED, PENDING

//     public Payment() {}

//     public Payment(int contractId, double amount, LocalDate paymentDate, String paymentMethod) {
//         this.contractId = contractId;
//         this.amount = amount;
//         this.paymentDate = paymentDate;
//         this.paymentMethod = paymentMethod;
//         this.status = "PENDING";
//     }

//     // Getters & Setters
//     public int getPaymentId() { return paymentId; }

//     public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

//     public int getContractId() { return contractId; }

//     public void setContractId(int contractId) { this.contractId = contractId; }

//     public double getAmount() { return amount; }

//     public void setAmount(double amount) { this.amount = amount; }

//     public LocalDate getPaymentDate() { return paymentDate; }

//     public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

//     public String getPaymentMethod() { return paymentMethod; }

//     public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

//     public String getStatus() { return status; }

//     public void setStatus(String status) { this.status = status; }
// }