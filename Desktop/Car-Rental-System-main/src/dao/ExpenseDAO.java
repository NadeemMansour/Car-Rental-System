package dao;

import model.Expense;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    // =========================
    // INSERT EXPENSE
    // =========================
    public void insert(Expense expense) {

        String sql = "INSERT INTO Expense (Branch_ID, Cost, Description, ExpenseDate) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, expense.getBranchId());

            statement.setDouble(2, expense.getCost());

            statement.setString(3, expense.getDescription());

            statement.setDate(4, Date.valueOf(expense.getDate()));

            statement.executeUpdate();

            System.out.println("Expense Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Expense Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE EXPENSE
    // =========================
    public void update(Expense expense) {

        String sql = "UPDATE Expense SET Branch_ID = ?, Cost = ?, Description = ?, ExpenseDate = ? WHERE Expense_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, expense.getBranchId());

            statement.setDouble(2, expense.getCost());

            statement.setString(3, expense.getDescription());

            statement.setDate(4, Date.valueOf(expense.getDate()));

            statement.setInt(5, expense.getExpenseId());

            statement.executeUpdate();

            System.out.println("Expense Updated Successfully!");

        } catch (SQLException e) {

            System.out.println("Update Expense Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE EXPENSE
    // =========================
    public void delete(int expenseId) {

        String sql = "DELETE FROM Expense WHERE Expense_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, expenseId);

            statement.executeUpdate();

            System.out.println("Expense Deleted Successfully!");

        } catch (SQLException e) {

            System.out.println("Delete Expense Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // FIND EXPENSE BY ID
    // =========================
    public Expense findById(int expenseId) {

        Expense expense = null;

        String sql = "SELECT * FROM Expense WHERE Expense_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, expenseId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                expense = new Expense();

                expense.setExpenseId(resultSet.getInt("Expense_ID"));

                expense.setBranchId(resultSet.getInt("Branch_ID"));

                expense.setCost(resultSet.getDouble("Cost"));

                expense.setDescription(resultSet.getString("Description"));

                expense.setDate(resultSet.getDate("ExpenseDate").toLocalDate());
            }

        } catch (SQLException e) {

            System.out.println("Find Expense Failed!");
            e.printStackTrace();
        }

        return expense;
    }

    // =========================
    // FIND ALL EXPENSES
    // =========================
    public List<Expense> findAll() {

        List<Expense> expenses = new ArrayList<>();

        String sql = "SELECT * FROM Expense";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Expense expense = new Expense();

                expense.setExpenseId(resultSet.getInt("Expense_ID"));

                expense.setBranchId(resultSet.getInt("Branch_ID"));

                expense.setCost(resultSet.getDouble("Cost"));

                expense.setDescription(resultSet.getString("Description"));

                expense.setDate(resultSet.getDate("ExpenseDate").toLocalDate());

                expenses.add(expense);
            }

        } catch (SQLException e) {

            System.out.println("Find All Expenses Failed!");
            e.printStackTrace();
        }

        return expenses;
    }

    // =========================
    // FIND EXPENSES BY BRANCH
    // =========================
    public List<Expense> findByBranch(int branchId) {

        List<Expense> expenses = new ArrayList<>();

        String sql = "SELECT * FROM Expense WHERE Branch_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, branchId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Expense expense = new Expense();

                expense.setExpenseId(resultSet.getInt("Expense_ID"));

                expense.setBranchId(resultSet.getInt("Branch_ID"));

                expense.setCost(resultSet.getDouble("Cost"));

                expense.setDescription(resultSet.getString("Description"));

                expense.setDate(resultSet.getDate("ExpenseDate").toLocalDate());

                expenses.add(expense);
            }

        } catch (SQLException e) {

            System.out.println("Find Expenses By Branch Failed!");
            e.printStackTrace();
        }

        return expenses;
    }

    // =========================
    // CHECK EXPENSE EXISTS
    // =========================
    public boolean exists(int expenseId) {

        String sql = "SELECT * FROM Expense WHERE Expense_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, expenseId);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            System.out.println("Check Expense Exists Failed!");
            e.printStackTrace();
        }

        return false;
    }

    // =========================
// GET TOTAL EXPENSES
// =========================
public double getTotalExpenses() {

    double total = 0;

    String sql = "SELECT SUM(Amount) FROM Expense";

    try {

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            total = resultSet.getDouble(1);
        }

    } catch (SQLException e) {

        System.out.println("Calculate Total Expenses Failed!");
        e.printStackTrace();
    }

    return total;
}
}