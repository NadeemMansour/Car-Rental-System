package model;

import java.util.Date;

public class BackupLog {


    private static  int backupId;
    private int counter = 0;
    private Date backupDate;
    private String description;
    private int performedBy;

    public BackupLog() {
    }
    


    public BackupLog(String description, int performedBy) {
        this.description = description;
        this.performedBy = performedBy;
        backupDate = new Date();
        backupId = counter++;
    }



    public int getBackupId() {
        return backupId;
    }


    public Date getBackupDate() {
        return backupDate;
    }

    public void setBackupDate(Date backupDate) {
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
        return "BackupLog [counter=" + counter + ", backupDate=" + backupDate + ", description=" + description
                + ", performedBy=" + performedBy + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BackupLog other = (BackupLog) obj;
        if (counter != other.counter)
            return false;
        if (backupDate == null) {
            if (other.backupDate != null)
                return false;
        } else if (!backupDate.equals(other.backupDate))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (performedBy != other.performedBy)
            return false;
        return true;
    }

}