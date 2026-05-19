package dao;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // =========================
    // INSERT EMPLOYEE
    // =========================
    public void insert(Employee employee) {

        String personSql = "INSERT INTO Person (FullName, Phone, Address, National) VALUES (?, ?, ?, ?)";
        String employeeSql = "INSERT INTO Employee (Person_ID, Job, Salary, Branch_ID) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            // INSERT INTO PERSON
            PreparedStatement personStatement = connection.prepareStatement(
                    personSql,
                    Statement.RETURN_GENERATED_KEYS
            );

            personStatement.setString(1, employee.getFullName());
            personStatement.setString(2, employee.getPhone());
            personStatement.setString(3, employee.getAddress());
            personStatement.setString(4, employee.getNationalId());

            personStatement.executeUpdate();

            // GET GENERATED PERSON ID
            ResultSet generatedKeys = personStatement.getGeneratedKeys();

            int personId = 0;

            if (generatedKeys.next()) {

                personId = generatedKeys.getInt(1);
            }

            // INSERT INTO EMPLOYEE
            PreparedStatement employeeStatement = connection.prepareStatement(employeeSql);

            employeeStatement.setInt(1, personId);
            employeeStatement.setString(2, employee.getJob());
            employeeStatement.setDouble(3, employee.getSalary());
            employeeStatement.setInt(4, employee.getBranchId());

            employeeStatement.executeUpdate();

            System.out.println("Employee Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Employee Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE EMPLOYEE
    // =========================
    public void update(Employee employee) {

        String personSql = "UPDATE Person SET FullName = ?, Phone = ?, Address = ?, National = ? WHERE Person_ID = ?";
        String employeeSql = "UPDATE Employee SET Job = ?, Salary = ?, Branch_ID = ? WHERE Employee_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            // UPDATE PERSON
            PreparedStatement personStatement = connection.prepareStatement(personSql);

            personStatement.setString(1, employee.getFullName());
            personStatement.setString(2, employee.getPhone());
            personStatement.setString(3, employee.getAddress());
            personStatement.setString(4, employee.getNationalId());
            personStatement.setInt(5, employee.getPersonId());

            personStatement.executeUpdate();

            // UPDATE EMPLOYEE
            PreparedStatement employeeStatement = connection.prepareStatement(employeeSql);

            employeeStatement.setString(1, employee.getJob());
            employeeStatement.setDouble(2, employee.getSalary());
            employeeStatement.setInt(3, employee.getBranchId());
            employeeStatement.setInt(4, employee.getEmployeeId());

            employeeStatement.executeUpdate();

            System.out.println("Employee Updated Successfully!");

        } catch (SQLException e) {

            System.out.println("Update Employee Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE EMPLOYEE
    // =========================
    public void delete(int employeeId) {

        String findPersonSql = "SELECT Person_ID FROM Employee WHERE Employee_ID = ?";
        String deleteEmployeeSql = "DELETE FROM Employee WHERE Employee_ID = ?";
        String deletePersonSql = "DELETE FROM Person WHERE Person_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            // FIND PERSON ID
            PreparedStatement findStatement = connection.prepareStatement(findPersonSql);

            findStatement.setInt(1, employeeId);

            ResultSet resultSet = findStatement.executeQuery();

            int personId = 0;

            if (resultSet.next()) {

                personId = resultSet.getInt("Person_ID");
            }

            // DELETE EMPLOYEE
            PreparedStatement employeeStatement = connection.prepareStatement(deleteEmployeeSql);

            employeeStatement.setInt(1, employeeId);

            employeeStatement.executeUpdate();

            // DELETE PERSON
            PreparedStatement personStatement = connection.prepareStatement(deletePersonSql);

            personStatement.setInt(1, personId);

            personStatement.executeUpdate();

            System.out.println("Employee Deleted Successfully!");

        } catch (SQLException e) {

            System.out.println("Delete Employee Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // FIND EMPLOYEE BY ID
    // =========================
    public Employee findById(int employeeId) {

        Employee employee = null;

        String sql = "SELECT * FROM Employee e JOIN Person p ON e.Person_ID = p.Person_ID WHERE e.Employee_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                employee = new Employee();

                employee.setEmployeeId(resultSet.getInt("Employee_ID"));
                employee.setPersonId(resultSet.getInt("Person_ID"));
                employee.setFullName(resultSet.getString("FullName"));
                employee.setPhone(resultSet.getString("Phone"));
                employee.setAddress(resultSet.getString("Address"));
                employee.setNationalId(resultSet.getString("National"));
                employee.setJob(resultSet.getString("Job"));
                employee.setSalary(resultSet.getDouble("Salary"));
                employee.setBranchId(resultSet.getInt("Branch_ID"));
            }

        } catch (SQLException e) {

            System.out.println("Find Employee Failed!");
            e.printStackTrace();
        }

        return employee;
    }

    // =========================
    // FIND ALL EMPLOYEES
    // =========================
    public List<Employee> findAll() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM Employee e JOIN Person p ON e.Person_ID = p.Person_ID";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Employee employee = new Employee();

                employee.setEmployeeId(resultSet.getInt("Employee_ID"));
                employee.setPersonId(resultSet.getInt("Person_ID"));
                employee.setFullName(resultSet.getString("FullName"));
                employee.setPhone(resultSet.getString("Phone"));
                employee.setAddress(resultSet.getString("Address"));
                employee.setNationalId(resultSet.getString("National"));
                employee.setJob(resultSet.getString("Job"));
                employee.setSalary(resultSet.getDouble("Salary"));
                employee.setBranchId(resultSet.getInt("Branch_ID"));

                employees.add(employee);
            }

        } catch (SQLException e) {

            System.out.println("Find All Employees Failed!");
            e.printStackTrace();
        }

        return employees;
    }

    // =========================
    // FIND EMPLOYEES BY BRANCH
    // =========================
    public List<Employee> findByBranch(int branchId) {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM Employee e JOIN Person p ON e.Person_ID = p.Person_ID WHERE e.Branch_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, branchId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Employee employee = new Employee();

                employee.setEmployeeId(resultSet.getInt("Employee_ID"));
                employee.setPersonId(resultSet.getInt("Person_ID"));
                employee.setFullName(resultSet.getString("FullName"));
                employee.setPhone(resultSet.getString("Phone"));
                employee.setAddress(resultSet.getString("Address"));
                employee.setNationalId(resultSet.getString("National"));
                employee.setJob(resultSet.getString("Job"));
                employee.setSalary(resultSet.getDouble("Salary"));
                employee.setBranchId(resultSet.getInt("Branch_ID"));

                employees.add(employee);
            }

        } catch (SQLException e) {

            System.out.println("Find Employees By Branch Failed!");
            e.printStackTrace();
        }

        return employees;
    }
}