package model;

public class Customer extends Person {

    private int customerId;
    private String licenseNumber;

    public Customer() {
    }

    public Customer(int customerId, String licenseNumber,int personId, String fullName,String phone, String address,String nationalId) {

        super(personId, fullName, phone, address, nationalId);

        this.customerId = customerId;
        this.licenseNumber = licenseNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fullName='" + getFullName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}