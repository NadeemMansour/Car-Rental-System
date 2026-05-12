package model;

public class Branch {

    private static int branchId;
    private int counter = 0;
    private String branchName;
    private String location;
    private String phone;

    public Branch() {}

    public Branch(String branchName, String location, String phone) {
        this.branchName = branchName;
        this.location = location;
        this.phone = phone;
        branchId = counter++;
    }

    public int getBranchId() {
        return branchId;
    }


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Branch [counter=" + counter + ", branchName=" + branchName + ", location=" + location + ", phone="
                + phone + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Branch other = (Branch) obj;
        if (counter != other.counter)
            return false;
        if (branchName == null) {
            if (other.branchName != null)
                return false;
        } else if (!branchName.equals(other.branchName))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        return true;
    }

    // Getters & Setters
}