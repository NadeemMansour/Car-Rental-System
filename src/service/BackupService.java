package service;

import dao.BackupDAO;
import model.BackupLog;

import java.util.List;

public class BackupService {

    private BackupDAO dao = new BackupDAO();

    public void createBackup(BackupLog b) {
        dao.insert(b);
    }

    public List<BackupLog> getAllBackups() {
        return dao.findAll();
    }
}