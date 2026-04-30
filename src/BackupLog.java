import java.sql.Date;

class BackupLog {
    private Date backupDate;
    private String description;
    

    public BackupLog(Date backupDate, String description) {
        this.backupDate = backupDate;
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getBackupDate() { return backupDate; }
    public void setBackupDate(Date backupDate) { this.backupDate = backupDate; }

    public void createBackup() {}
    public void restoreBackup() {}
    public void viewLogs() {}
}
