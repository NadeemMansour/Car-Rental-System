package model;

public class Employee extends Person {

    private int employeeId;
    private String job;
    private double salary;
    private int branchId;

    public Employee() {
    }

    public Employee(int employeeId, String job, double salary, int branchId,int personId, String fullName,String phone, String address,String nationalId) {

        super(personId, fullName, phone, address, nationalId);

        this.employeeId = employeeId;
        this.job = job;
        this.salary = salary;
        this.branchId = branchId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", fullName='" + getFullName() + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", branchId=" + branchId +
                '}';
    }
    
}