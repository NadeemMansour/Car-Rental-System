package model;

import java.util.Date;

public class CarDelivery {

    private static int deliveryId;
    private int counter = 0;
    private int rentalId;
    private Date deliveryDate;
    private String condition;
    private int employeeId;


    public CarDelivery(int rentalId, Date deliveryDate, String condition, int employeeId) {
        this.rentalId = rentalId;
        this.deliveryDate = deliveryDate;
        this.condition = condition;
        this.employeeId = employeeId;
        deliveryId = counter++;
    }

    public CarDelivery() {
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
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
        return "CarDelivery [counter=" + counter + ", rentalId=" + rentalId + ", deliveryDate=" + deliveryDate
                + ", condition=" + condition + ", employeeId=" + employeeId + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarDelivery other = (CarDelivery) obj;
        if (counter != other.counter)
            return false;
        if (rentalId != other.rentalId)
            return false;
        if (deliveryDate == null) {
            if (other.deliveryDate != null)
                return false;
        } else if (!deliveryDate.equals(other.deliveryDate))
            return false;
        if (condition == null) {
            if (other.condition != null)
                return false;
        } else if (!condition.equals(other.condition))
            return false;
        if (employeeId != other.employeeId)
            return false;
        return true;
    }

}