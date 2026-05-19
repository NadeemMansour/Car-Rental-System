package service;

import dao.MaintenanceDAO;
import model.Maintenance;

import java.util.List;

public class MaintenanceService {

    private final MaintenanceDAO maintenanceDAO = new MaintenanceDAO();

    // =========================
    // ADD MAINTENANCE
    // =========================
    public void addMaintenance(Maintenance maintenance) {

        if (maintenance == null) {
            throw new IllegalArgumentException("Maintenance cannot be null");
        }

        maintenanceDAO.insert(maintenance);
    }

    // =========================
    // UPDATE MAINTENANCE
    // =========================
    public void updateMaintenance(Maintenance maintenance) {

        if (maintenance == null) {
            throw new IllegalArgumentException("Maintenance cannot be null");
        }

        maintenanceDAO.update(maintenance);
    }

    // =========================
    // DELETE MAINTENANCE
    // =========================
    public void deleteMaintenance(int maintenanceId) {

        if (maintenanceId <= 0) {
            throw new IllegalArgumentException("Invalid Maintenance ID");
        }

        maintenanceDAO.delete(maintenanceId);
    }

    // =========================
    // GET MAINTENANCE BY ID
    // =========================
    public Maintenance getMaintenanceById(int maintenanceId) {

        if (maintenanceId <= 0) {
            throw new IllegalArgumentException("Invalid Maintenance ID");
        }

        return maintenanceDAO.findById(maintenanceId);
    }

    // =========================
    // GET ALL MAINTENANCE
    // =========================
    public List<Maintenance> getAllMaintenance() {

        return maintenanceDAO.findAll();
    }

    // =========================
    // GET MAINTENANCE BY CAR
    // =========================
    public List<Maintenance> getMaintenanceByCar(int carId) {

        if (carId <= 0) {
            throw new IllegalArgumentException("Invalid Car ID");
        }

        return maintenanceDAO.findByCar(carId);
    }

    // =========================
    // CALCULATE MAINTENANCE COST
    // =========================
    public double calculateMaintenanceCost(List<Maintenance> maintenanceList) {

        double total = 0;

        if (maintenanceList != null) {

            for (Maintenance maintenance : maintenanceList) {

                total += maintenance.getCost();
            }
        }

        return total;
    }

    // =========================
    // CHECK MAINTENANCE EXISTS
    // =========================
    public boolean maintenanceExists(int maintenanceId) {

        if (maintenanceId <= 0) {
            return false;
        }

        return maintenanceDAO.exists(maintenanceId);
    }
}