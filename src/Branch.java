class Branch {
    private int branchID;
    private String name;
    private String location;
    
    public Branch(int branchID, String name, String location) {
        this.branchID = branchID;
        this.name = name;
        this.location = location;
    }

    public int getBranchID() {
        return branchID;
    }
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
}