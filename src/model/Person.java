package model;

public class Person {

    private int personId;
    private String fullName;
    private String phone;
    private String address;
    private String nationalId;

    public Person() {}

    public Person(int personId, String fullName, String phone, String address, String nationalId) {
        this.personId = personId;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.nationalId = nationalId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    // Getters & Setters
}