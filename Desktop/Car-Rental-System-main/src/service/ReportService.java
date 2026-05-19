package service;

import dao.CarDAO;
import dao.CustomerDAO;
import dao.ExpenseDAO;
import dao.MaintenanceDAO;
import dao.PaymentDAO;
import dao.RentalDAO;

import model.Car;
import model.Customer;
import model.Expense;
import model.Maintenance;
import model.Payment;
import model.RentalContract;

import java.util.List;

public class ReportService {

    private final RentalDAO rentalDAO = new RentalDAO();

    private final PaymentDAO paymentDAO = new PaymentDAO();

    private final ExpenseDAO expenseDAO = new ExpenseDAO();

    private final CarDAO carDAO = new CarDAO();

    private final CustomerDAO customerDAO = new CustomerDAO();

    private final MaintenanceDAO maintenanceDAO = new MaintenanceDAO();

    // =========================
    // GENERATE RENTAL REPORT
    // =========================
    public List<RentalContract> generateRentalReport() {

        return rentalDAO.findAll();
    }

    // =========================
    // GENERATE PAYMENT REPORT
    // =========================
    public List<Payment> generatePaymentReport() {

        return paymentDAO.findAll();
    }

    // =========================
    // GENERATE CUSTOMER REPORT
    // =========================
    public List<Customer> generateCustomerReport() {

        return customerDAO.findAll();
    }

    // =========================
    // GENERATE CAR REPORT
    // =========================
    public List<Car> generateCarReport() {

        return carDAO.findAll();
    }

    // =========================
    // GENERATE MAINTENANCE REPORT
    // =========================
    public List<Maintenance> generateMaintenanceReport() {

        return maintenanceDAO.findAll();
    }

    // =========================
    // GENERATE EXPENSE REPORT
    // =========================
    public List<Expense> generateExpenseReport() {

        return expenseDAO.findAll();
    }

    // =========================
    // GET TOTAL REVENUE
    // =========================
    public double getTotalRevenue() {

        return paymentDAO.getTotalPayments();
    }

    // =========================
    // GET TOTAL EXPENSES
    // =========================
    public double getTotalExpenses() {

        return expenseDAO.getTotalExpenses();
    }

    // =========================
    // GET NET PROFIT
    // =========================
    public double getNetProfit() {

        return getTotalRevenue() - getTotalExpenses();
    }
}