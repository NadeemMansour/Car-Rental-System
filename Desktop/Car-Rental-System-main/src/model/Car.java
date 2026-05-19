package model;

public class Car {

    private int carId;
    private String plateNumber;
    private String chassisNumber;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String status;
    private double dailyPrice;

    public Car() {
    }

    public Car(int carId, String plateNumber,String chassisNumber, String brand,String model, int year,String color, String status,double dailyPrice) {

        this.carId = carId;
        this.plateNumber = plateNumber;
        this.chassisNumber = chassisNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.status = status;
        this.dailyPrice = dailyPrice;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", plateNumber='" + plateNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", status='" + status + '\'' +
                ", dailyPrice=" + dailyPrice +
                '}';
    }
}