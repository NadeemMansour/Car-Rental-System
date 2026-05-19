package model;

import java.time.LocalDate;

public class Maintenance {

    private int maintenanceId;
    private int carId;
    private LocalDate serviceDate;
    private String description;
    private double cost;

    public Maintenance() {
    }

    public Maintenance(int maintenanceId, int carId, LocalDate serviceDate, String description, double cost) {

        this.maintenanceId = maintenanceId;
        this.carId = carId;
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
    }

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId=" + maintenanceId +
                ", carId=" + carId +
                ", serviceDate=" + serviceDate +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}