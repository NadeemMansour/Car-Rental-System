package service;

import dao.MaintenanceDAO;
import model.Maintenance;

import java.util.List;

public class MaintenanceService {

    private MaintenanceDAO maintenanceDAO = new MaintenanceDAO();

    public void addMaintenance(Maintenance m) {
        maintenanceDAO.insert(m);
    }

    public void updateMaintenance(Maintenance m) {
        maintenanceDAO.update(m);
    }

    public List<Maintenance> getCarHistory(int carId) {
        return maintenanceDAO.findByCar(carId);
    }

    public List<Maintenance> getAll() {
        return maintenanceDAO.findAll();
    }
}