package service;

import dao.ExpenseDAO;
import model.Expense;

import java.util.List;

public class ExpenseService {

    private final ExpenseDAO expenseDAO = new ExpenseDAO();

    // =========================
    // ADD EXPENSE
    // =========================
    public void addExpense(Expense expense) {

        if (expense == null) {
            throw new IllegalArgumentException("Expense cannot be null");
        }

        expenseDAO.insert(expense);
    }

    // =========================
    // UPDATE EXPENSE
    // =========================
    public void updateExpense(Expense expense) {

        if (expense == null) {
            throw new IllegalArgumentException("Expense cannot be null");
        }

        expenseDAO.update(expense);
    }

    // =========================
    // DELETE EXPENSE
    // =========================
    public void deleteExpense(int expenseId) {

        if (expenseId <= 0) {
            throw new IllegalArgumentException("Invalid Expense ID");
        }

        expenseDAO.delete(expenseId);
    }

    // =========================
    // GET EXPENSE BY ID
    // =========================
    public Expense getExpenseById(int expenseId) {

        if (expenseId <= 0) {
            throw new IllegalArgumentException("Invalid Expense ID");
        }

        return expenseDAO.findById(expenseId);
    }

    // =========================
    // GET ALL EXPENSES
    // =========================
    public List<Expense> getAllExpenses() {

        return expenseDAO.findAll();
    }

    // =========================
    // GET EXPENSES BY BRANCH
    // =========================
    public List<Expense> getExpensesByBranch(int branchId) {

        if (branchId <= 0) {
            throw new IllegalArgumentException("Invalid Branch ID");
        }

        return expenseDAO.findByBranch(branchId);
    }

    // CALCULATE TOTAL EXPENSES
    // =========================
    public double calculateTotalExpenses() {
        return expenseDAO.getTotalExpenses();
    }

    // =========================
    // CHECK EXPENSE EXISTS
    // =========================
    public boolean expenseExists(int expenseId) {

        if (expenseId <= 0) {
            return false;
        }

        return expenseDAO.exists(expenseId);
    }
}