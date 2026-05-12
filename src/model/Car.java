package model;

public class Car {

    private static int carId;
    private int counter = 0;
    private String plateNumber;
    private String chassisNumber;
    private String brand;
    private String model;
    private int year;
    private String status;
    private double dailyPrice;

    public Car() {
    }

    public Car(String plateNumber, String chassisNumber, String brand, String model, int year, String status,
            double dailyPrice) {
        this.plateNumber = plateNumber;
        this.chassisNumber = chassisNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.status = status;
        this.dailyPrice = dailyPrice;
        carId = counter++;
    }

    public int getCarId() {
        return carId;
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
        return "Car [counter=" + counter + ", plateNumber=" + plateNumber + ", chassisNumber=" + chassisNumber
                + ", brand=" + brand + ", model=" + model + ", year=" + year + ", status=" + status + ", dailyPrice="
                + dailyPrice + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (counter != other.counter)
            return false;
        if (plateNumber == null) {
            if (other.plateNumber != null)
                return false;
        } else if (!plateNumber.equals(other.plateNumber))
            return false;
        if (chassisNumber == null) {
            if (other.chassisNumber != null)
                return false;
        } else if (!chassisNumber.equals(other.chassisNumber))
            return false;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (year != other.year)
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (Double.doubleToLongBits(dailyPrice) != Double.doubleToLongBits(other.dailyPrice))
            return false;
        return true;
    }
}