package dao;

import model.Branch;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BranchDAO {

    // =========================
    // INSERT BRANCH
    // =========================
    public void insert(Branch branch) {

        String sql = "INSERT INTO Branch (BranchName, Location, Phone) VALUES (?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, branch.getBranchName());
            statement.setString(2, branch.getLocation());
            statement.setString(3, branch.getPhone());

            statement.executeUpdate();

            System.out.println("Branch Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Branch Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE BRANCH
    // =========================
    public void update(Branch branch) {

        String sql = "UPDATE Branch SET BranchName = ?, Location = ?, Phone = ? WHERE Branch_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, branch.getBranchName());
            statement.setString(2, branch.getLocation());
            statement.setString(3, branch.getPhone());
            statement.setInt(4, branch.getBranchId());

            statement.executeUpdate();

            System.out.println("Branch Updated Successfully!");

        } catch (SQLException e) {

            System.out.println("Update Branch Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE BRANCH
    // =========================
    public void delete(int branchId) {

        String sql = "DELETE FROM Branch WHERE Branch_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, branchId);

            statement.executeUpdate();

            System.out.println("Branch Deleted Successfully!");

        } catch (SQLException e) {

            System.out.println("Delete Branch Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // FIND BRANCH BY ID
    // =========================
    public Branch findById(int branchId) {

        Branch branch = null;

        String sql = "SELECT * FROM Branch WHERE Branch_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, branchId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                branch = new Branch();

                branch.setBranchId(resultSet.getInt("Branch_ID"));
                branch.setBranchName(resultSet.getString("BranchName"));
                branch.setLocation(resultSet.getString("Location"));
                branch.setPhone(resultSet.getString("Phone"));
            }

        } catch (SQLException e) {

            System.out.println("Find Branch Failed!");
            e.printStackTrace();
        }

        return branch;
    }

    // =========================
    // FIND ALL BRANCHES
    // =========================
    public List<Branch> findAll() {

        List<Branch> branches = new ArrayList<>();

        String sql = "SELECT * FROM Branch";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Branch branch = new Branch();

                branch.setBranchId(resultSet.getInt("Branch_ID"));
                branch.setBranchName(resultSet.getString("BranchName"));
                branch.setLocation(resultSet.getString("Location"));
                branch.setPhone(resultSet.getString("Phone"));

                branches.add(branch);
            }

        } catch (SQLException e) {

            System.out.println("Find All Branches Failed!");
            e.printStackTrace();
        }

        return branches;
    }
}