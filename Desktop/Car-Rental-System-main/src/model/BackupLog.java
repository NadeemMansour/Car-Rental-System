package model;

import java.time.LocalDateTime;

public class BackupLog {

    private int backupId;
    private LocalDateTime backupDate;
    private String description;
    private int performedBy;

    public BackupLog() {
    }

    public BackupLog(int backupId,LocalDateTime backupDate,String description,int performedBy) {

        this.backupId = backupId;
        this.backupDate = backupDate;
        this.description = description;
        this.performedBy = performedBy;
    }

    public int getBackupId() {
        return backupId;
    }

    public void setBackupId(int backupId) {
        this.backupId = backupId;
    }

    public LocalDateTime getBackupDate() {
        return backupDate;
    }

    public void setBackupDate(LocalDateTime backupDate) {
        this.backupDate = backupDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(int performedBy) {
        this.performedBy = performedBy;
    }

    @Override
    public String toString() {
        return "BackupLog{" +
                "backupId=" + backupId +
                ", backupDate=" + backupDate +
                ", description='" + description + '\'' +
                ", performedBy=" + performedBy +
                '}';
    }
}