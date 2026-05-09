package service;

import dao.ExpenseDAO;
import model.Expense;

import java.util.List;

public class ExpenseService {

    private ExpenseDAO dao = new ExpenseDAO();

    public void addExpense(Expense e) {
        dao.insert(e);
    }

    public List<Expense> getByBranch(int branchId) {
        return dao.findByBranch(branchId);
    }

    public List<Expense> getAll() {
        return dao.findAll();
    }
}