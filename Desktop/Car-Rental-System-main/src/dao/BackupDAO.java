package dao;

import model.BackupLog;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BackupDAO {

    // =========================
    // INSERT BACKUP
    // =========================
    public void insert(BackupLog backup) {

        String sql = "INSERT INTO BackupLog (BackupDate, Description, PerformedBy) VALUES (?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setTimestamp(1, Timestamp.valueOf(backup.getBackupDate()));

            statement.setString(2, backup.getDescription());

            statement.setInt(3, backup.getPerformedBy());

            statement.executeUpdate();

            System.out.println("Backup Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Backup Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE BACKUP
    // =========================
    public void delete(int backupId) {

        String sql = "DELETE FROM BackupLog WHERE Backup_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, backupId);

            statement.executeUpdate();

            System.out.println("Backup Deleted Successfully!");

        } catch (SQLException e) {

            System.out.println("Delete Backup Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // FIND BACKUP BY ID
    // =========================
    public BackupLog findById(int backupId) {

        BackupLog backup = null;

        String sql = "SELECT * FROM BackupLog WHERE Backup_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, backupId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                backup = new BackupLog();

                backup.setBackupId(resultSet.getInt("Backup_ID"));

                backup.setBackupDate(resultSet.getTimestamp("BackupDate").toLocalDateTime());

                backup.setDescription(resultSet.getString("Description"));

                backup.setPerformedBy(resultSet.getInt("PerformedBy"));
            }

        } catch (SQLException e) {

            System.out.println("Find Backup Failed!");
            e.printStackTrace();
        }

        return backup;
    }

    // =========================
    // FIND ALL BACKUPS
    // =========================
    public List<BackupLog> findAll() {

        List<BackupLog> backups = new ArrayList<>();

        String sql = "SELECT * FROM BackupLog";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                BackupLog backup = new BackupLog();

                backup.setBackupId(resultSet.getInt("Backup_ID"));

                backup.setBackupDate(resultSet.getTimestamp("BackupDate").toLocalDateTime());

                backup.setDescription(resultSet.getString("Description"));

                backup.setPerformedBy(resultSet.getInt("PerformedBy"));

                backups.add(backup);
            }

        } catch (SQLException e) {

            System.out.println("Find All Backups Failed!");
            e.printStackTrace();
        }

        return backups;
    }

    // =========================
    // FIND BACKUPS BY EMPLOYEE
    // =========================
    public List<BackupLog> findByEmployee(int employeeId) {

        List<BackupLog> backups = new ArrayList<>();

        String sql = "SELECT * FROM BackupLog WHERE PerformedBy = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                BackupLog backup = new BackupLog();

                backup.setBackupId(resultSet.getInt("Backup_ID"));

                backup.setBackupDate(resultSet.getTimestamp("BackupDate").toLocalDateTime());

                backup.setDescription(resultSet.getString("Description"));

                backup.setPerformedBy(resultSet.getInt("PerformedBy"));

                backups.add(backup);
            }

        } catch (SQLException e) {

            System.out.println("Find Backups By Employee Failed!");
            e.printStackTrace();
        }

        return backups;
    }

    // =========================
    // CHECK BACKUP EXISTS
    // =========================
    public boolean exists(int backupId) {

        String sql = "SELECT * FROM BackupLog WHERE Backup_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, backupId);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            System.out.println("Check Backup Exists Failed!");
            e.printStackTrace();
        }

        return false;
    }

    // =========================
    // COUNT BACKUPS
    // =========================
    public long countBackups() {

        String sql = "SELECT COUNT(*) FROM BackupLog";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getLong(1);
            }

        } catch (SQLException e) {

            System.out.println("Count Backups Failed!");
            e.printStackTrace();
        }

        return 0;
    }
}