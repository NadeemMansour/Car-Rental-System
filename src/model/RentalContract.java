package model;

import java.time.LocalDate;

public class RentalContract {

    private int contractId;

    private int customerId;
    private int carId;

    private LocalDate startDate;
    private LocalDate endDate;

    private double totalAmount;
    private double deposit;
    private double discount;

    private String contractStatus;

    // ======================
    // GETTERS & SETTERS
    // ======================

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }
}


// package model;

// import java.time.LocalDate;

// public class RentalContract {

//     private int rentalId;
//     private int customerId;
//     private int carId;

//     private LocalDate startDate;
//     private LocalDate endDate;

//     private double totalAmount;
//     private double deposit;
//     private double discount;

//     private String contractStatus;

//     public int getRentalId() { return rentalId; }
//     public void setRentalId(int rentalId) { this.rentalId = rentalId; }

//     public int getCustomerId() { return customerId; }
//     public void setCustomerId(int customerId) { this.customerId = customerId; }

//     public int getCarId() { return carId; }
//     public void setCarId(int carId) { this.carId = carId; }

//     public LocalDate getStartDate() { return startDate; }
//     public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

//     public LocalDate getEndDate() { return endDate; }
//     public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

//     public double getTotalAmount() { return totalAmount; }
//     public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

//     public double getDeposit() { return deposit; }
//     public void setDeposit(double deposit) { this.deposit = deposit; }

//     public double getDiscount() { return discount; }
//     public void setDiscount(double discount) { this.discount = discount; }

//     public String getContractStatus() { return contractStatus; }
//     public void setContractStatus(String contractStatus) { this.contractStatus = contractStatus; }
// }