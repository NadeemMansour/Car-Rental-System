package model;

import java.time.LocalDate;

public class CarReturn {

    private int returnId;
    private int rentalId;
    private LocalDate returnDate;
    private String condition;
    private int employeeId;

    public CarReturn() {
    }

    public CarReturn(int returnId, int rentalId, LocalDate returnDate, String condition, int employeeId) {

        this.returnId = returnId;
        this.rentalId = rentalId;
        this.returnDate = returnDate;
        this.condition = condition;
        this.employeeId = employeeId;
    }

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
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
        return "CarReturn{" +
                "returnId=" + returnId +
                ", rentalId=" + rentalId +
                ", returnDate=" + returnDate +
                ", condition='" + condition + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

}