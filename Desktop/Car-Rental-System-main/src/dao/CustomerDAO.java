package dao;

import model.Customer;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // =========================
    // INSERT CUSTOMER
    // =========================
    public void insert(Customer customer) {

        String personSql = "INSERT INTO Person (FullName, Phone, Address, National) VALUES (?, ?, ?, ?)";
        String customerSql = "INSERT INTO Customer (Person_ID, LicenseNumber) VALUES (?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            // INSERT INTO PERSON
            PreparedStatement personStatement = connection.prepareStatement(
                    personSql,
                    Statement.RETURN_GENERATED_KEYS
            );

            personStatement.setString(1, customer.getFullName());
            personStatement.setString(2, customer.getPhone());
            personStatement.setString(3, customer.getAddress());
            personStatement.setString(4, customer.getNationalId());

            personStatement.executeUpdate();

            // GET GENERATED PERSON ID
            ResultSet generatedKeys = personStatement.getGeneratedKeys();

            int personId = 0;

            if (generatedKeys.next()) {

                personId = generatedKeys.getInt(1);
            }

            // INSERT INTO CUSTOMER
            PreparedStatement customerStatement = connection.prepareStatement(customerSql);

            customerStatement.setInt(1, personId);
            customerStatement.setString(2, customer.getLicenseNumber());

            customerStatement.executeUpdate();

            System.out.println("Customer Added Successfully!");

        } catch (SQLException e) {

            System.out.println("Insert Customer Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE CUSTOMER
    // =========================
    public void update(Customer customer) {

        String personSql = "UPDATE Person SET FullName = ?, Phone = ?, Address = ?, National = ? WHERE Person_ID = ?";
        String customerSql = "UPDATE Customer SET LicenseNumber = ? WHERE Customer_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            // UPDATE PERSON
            PreparedStatement personStatement = connection.prepareStatement(personSql);

            personStatement.setString(1, customer.getFullName());
            personStatement.setString(2, customer.getPhone());
            personStatement.setString(3, customer.getAddress());
            personStatement.setString(4, customer.getNationalId());
            personStatement.setInt(5, customer.getPersonId());

            personStatement.executeUpdate();

            // UPDATE CUSTOMER
            PreparedStatement customerStatement = connection.prepareStatement(customerSql);

            customerStatement.setString(1, customer.getLicenseNumber());
            customerStatement.setInt(2, customer.getCustomerId());

            customerStatement.executeUpdate();

            System.out.println("Customer Updated Successfully!");

        } catch (SQLException e) {

            System.out.println("Update Customer Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE CUSTOMER
    // =========================
    public void delete(int customerId) {

        String findPersonSql = "SELECT Person_ID FROM Customer WHERE Customer_ID = ?";
        String deleteCustomerSql = "DELETE FROM Customer WHERE Customer_ID = ?";
        String deletePersonSql = "DELETE FROM Person WHERE Person_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            // FIND PERSON ID
            PreparedStatement findStatement = connection.prepareStatement(findPersonSql);

            findStatement.setInt(1, customerId);

            ResultSet resultSet = findStatement.executeQuery();

            int personId = 0;

            if (resultSet.next()) {

                personId = resultSet.getInt("Person_ID");
            }

            // DELETE CUSTOMER
            PreparedStatement customerStatement = connection.prepareStatement(deleteCustomerSql);

            customerStatement.setInt(1, customerId);

            customerStatement.executeUpdate();

            // DELETE PERSON
            PreparedStatement personStatement = connection.prepareStatement(deletePersonSql);

            personStatement.setInt(1, personId);

            personStatement.executeUpdate();

            System.out.println("Customer Deleted Successfully!");

        } catch (SQLException e) {

            System.out.println("Delete Customer Failed!");
            e.printStackTrace();
        }
    }

    // =========================
    // FIND CUSTOMER BY ID
    // =========================
    public Customer findById(int customerId) {

        String sql = """
                SELECT *
                FROM Customer c
                JOIN Person p
                ON c.Person_ID = p.Person_ID
                WHERE c.Customer_ID = ?
                """;

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, customerId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(resultSet.getInt("Customer_ID"));
                customer.setPersonId(resultSet.getInt("Person_ID"));
                customer.setFullName(resultSet.getString("FullName"));
                customer.setPhone(resultSet.getString("Phone"));
                customer.setAddress(resultSet.getString("Address"));
                customer.setNationalId(resultSet.getString("National"));
                customer.setLicenseNumber(resultSet.getString("LicenseNumber"));

                return customer;
            }

        } catch (SQLException e) {

            System.out.println("Find Customer Failed!");
            e.printStackTrace();
        }

        return null;
    }

    // =========================
    // FIND ALL CUSTOMERS
    // =========================
    public List<Customer> findAll() {

        List<Customer> customers = new ArrayList<>();

        String sql = """
                SELECT *
                FROM Customer c
                JOIN Person p
                ON c.Person_ID = p.Person_ID
                """;

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(resultSet.getInt("Customer_ID"));
                customer.setPersonId(resultSet.getInt("Person_ID"));
                customer.setFullName(resultSet.getString("FullName"));
                customer.setPhone(resultSet.getString("Phone"));
                customer.setAddress(resultSet.getString("Address"));
                customer.setNationalId(resultSet.getString("National"));
                customer.setLicenseNumber(resultSet.getString("LicenseNumber"));

                customers.add(customer);
            }

        } catch (SQLException e) {

            System.out.println("Find All Customers Failed!");
            e.printStackTrace();
        }

        return customers;
    }

    // =========================
    // CHECK CUSTOMER EXISTS
    // =========================
    public boolean exists(int customerId) {

        String sql = "SELECT * FROM Customer WHERE Customer_ID = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, customerId);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            System.out.println("Check Customer Exists Failed!");
            e.printStackTrace();
        }

        return false;
    }

    // =========================
// FIND CUSTOMER BY NATIONAL ID
// =========================
public Customer findByNationalId(String nationalId) {

    String sql = """
            SELECT *
            FROM Customer c
            JOIN Person p
            ON c.Person_ID = p.Person_ID
            WHERE p.National = ?
            """;

    try {

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, nationalId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            Customer customer = new Customer();

            customer.setCustomerId(resultSet.getInt("Customer_ID"));

            customer.setPersonId(resultSet.getInt("Person_ID"));

            customer.setFullName(resultSet.getString("FullName"));

            customer.setPhone(resultSet.getString("Phone"));

            customer.setAddress(resultSet.getString("Address"));

            customer.setNationalId(resultSet.getString("National"));

            customer.setLicenseNumber(resultSet.getString("LicenseNumber"));

            return customer;
        }

    } catch (SQLException e) {

        System.out.println("Find Customer By National ID Failed!");
        e.printStackTrace();
    }

    return null;
}

// =========================
// FIND CUSTOMER BY PHONE
// =========================
public Customer findByPhone(String phone) {

    String sql = """
            SELECT *
            FROM Customer c
            JOIN Person p
            ON c.Person_ID = p.Person_ID
            WHERE p.Phone = ?
            """;

    try {

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, phone);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            Customer customer = new Customer();

            customer.setCustomerId(resultSet.getInt("Customer_ID"));

            customer.setPersonId(resultSet.getInt("Person_ID"));

            customer.setFullName(resultSet.getString("FullName"));

            customer.setPhone(resultSet.getString("Phone"));

            customer.setAddress(resultSet.getString("Address"));

            customer.setNationalId(resultSet.getString("National"));

            customer.setLicenseNumber(resultSet.getString("LicenseNumber"));

            return customer;
        }

    } catch (SQLException e) {

        System.out.println("Find Customer By Phone Failed!");
        e.printStackTrace();
    }

    return null;
}
}