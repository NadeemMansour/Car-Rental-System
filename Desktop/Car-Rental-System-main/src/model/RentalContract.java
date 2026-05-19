package model;

import java.time.LocalDate;

public class RentalContract {

    private int rentalId;
    private int customerId;
    private int carId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalAmount;
    private double deposit;
    private double discount;
    private String contractStatus;

    public RentalContract() {
    }

    public RentalContract(int rentalId, int customerId,int carId, LocalDate startDate,LocalDate endDate, double totalAmount,double deposit, double discount,String contractStatus) {

        this.rentalId = rentalId;
        this.customerId = customerId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = totalAmount;
        this.deposit = deposit;
        this.discount = discount;
        this.contractStatus = contractStatus;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
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

    @Override
    public String toString() {
        return "RentalContract{" +
                "rentalId=" + rentalId +
                ", customerId=" + customerId +
                ", carId=" + carId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalAmount=" + totalAmount +
                ", deposit=" + deposit +
                ", discount=" + discount +
                ", contractStatus='" + contractStatus + '\'' +
                '}';
    }
}