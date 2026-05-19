package model;

import java.time.LocalDate;

public class Expense {

    private int expenseId;
    private int branchId;
    private double cost;
    private String description;
    private LocalDate date;

    public Expense() {
    }

    public Expense(int expenseId,int branchId,double cost,String description,LocalDate date) {

        this.expenseId = expenseId;
        this.branchId = branchId;
        this.cost = cost;
        this.description = description;
        this.date = date;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", branchId=" + branchId +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}