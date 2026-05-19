package controller;

import model.Maintenance;
import service.MaintenanceService;

import java.util.List;

public class MaintenanceController {

    private final MaintenanceService maintenanceService =
            new MaintenanceService();

    // =========================
    // ADD MAINTENANCE
    // =========================
    public String addMaintenance(Maintenance maintenance) {

        if (maintenance == null) {
            return "Invalid Maintenance Data";
        }

        maintenanceService.addMaintenance(maintenance);

        return "Maintenance Added Successfully";
    }

    // =========================
    // UPDATE MAINTENANCE
    // =========================
    public String updateMaintenance(Maintenance maintenance) {

        if (maintenance == null) {
            return "Invalid Maintenance Data";
        }

        maintenanceService.updateMaintenance(maintenance);

        return "Maintenance Updated Successfully";
    }

    // =========================
    // DELETE MAINTENANCE
    // =========================
    public String deleteMaintenance(int maintenanceId) {

        if (maintenanceId <= 0) {
            return "Invalid Maintenance ID";
        }

        maintenanceService.deleteMaintenance(maintenanceId);

        return "Maintenance Deleted Successfully";
    }

    // =========================
    // GET MAINTENANCE BY ID
    // =========================
    public Maintenance getMaintenanceById(int maintenanceId) {

        return maintenanceService.getMaintenanceById(maintenanceId);
    }

    // =========================
    // GET ALL MAINTENANCE
    // =========================
    public List<Maintenance> getAllMaintenance() {

        return maintenanceService.getAllMaintenance();
    }

    // =========================
    // GET MAINTENANCE BY CAR
    // =========================
    public List<Maintenance> getMaintenanceByCar(int carId) {

        return maintenanceService.getMaintenanceByCar(carId);
    }

    // =========================
    // CLEAR FORM
    // =========================
    public void clearForm() {

        System.out.println("Form Cleared");
    }
}