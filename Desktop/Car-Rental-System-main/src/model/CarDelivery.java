package model;

import java.time.LocalDate;

public class CarDelivery {

    private int deliveryId;
    private int rentalId;
    private LocalDate deliveryDate;
    private String condition;
    private int employeeId;

    public CarDelivery() {
    }

    public CarDelivery(int deliveryId,int rentalId,LocalDate deliveryDate,String condition,int employeeId) {

        this.deliveryId = deliveryId;
        this.rentalId = rentalId;
        this.deliveryDate = deliveryDate;
        this.condition = condition;
        this.employeeId = employeeId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "CarDelivery{" +
                "deliveryId=" + deliveryId +
                ", rentalId=" + rentalId +
                ", deliveryDate=" + deliveryDate +
                ", condition='" + condition + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}