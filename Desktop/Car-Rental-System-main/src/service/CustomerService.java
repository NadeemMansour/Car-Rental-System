package service;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAO();

    // ADD CUSTOMER
    // =========================
    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        customerDAO.insert(customer);
    }

    // UPDATE CUSTOMER
    // =========================
    public void updateCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        customerDAO.update(customer);
    }

    // DELETE CUSTOMER
    // =========================
    public void deleteCustomer(int customerId) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Invalid Customer ID");
        }
        customerDAO.delete(customerId);
    }

    // GET CUSTOMER BY ID
    // =========================
    public Customer getCustomerById(int customerId) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Invalid Customer ID");
        }
        return customerDAO.findById(customerId);
    }

    // GET ALL CUSTOMERS
    // =========================
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    // FIND BY NATIONAL ID
    // =========================
    public Customer findByNationalId(String nationalId) {
        return customerDAO.findByNationalId(nationalId);
    }

    // FIND BY PHONE
    // =========================
    public Customer findByPhone(String phone) {
        return customerDAO.findByPhone(phone);
    }

    // CUSTOMER EXISTS
    // =========================
    public boolean customerExists(int customerId) {
        if (customerId <= 0) {
            return false;
        }
        return customerDAO.exists(customerId);
    }
}