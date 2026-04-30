class Customer extends Person {
    private String nationalID;
    private String address;
    private String licenseNumber;

    public Customer(String nationalID, String address, String licenseNumber) {
        this.nationalID = nationalID;
        this.address = address;
        this.licenseNumber = licenseNumber;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

}