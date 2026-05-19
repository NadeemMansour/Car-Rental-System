package controller;

import model.Customer;
import service.CustomerService;

import java.util.List;

public class CustomerController {

    private final CustomerService customerService = new CustomerService();

    // =========================
    // ADD CUSTOMER
    // =========================
    public String addCustomer(Customer customer) {

        if (customer == null) {
            return "Invalid Customer";
        }

        customerService.addCustomer(customer);

        return "Customer Added Successfully";
    }

    // =========================
    // UPDATE CUSTOMER
    // =========================
    public String updateCustomer(Customer customer) {

        if (customer == null) {
            return "Invalid Customer";
        }

        customerService.updateCustomer(customer);

        return "Customer Updated Successfully";
    }

    // =========================
    // DELETE CUSTOMER
    // =========================
    public String deleteCustomer(int customerId) {

        if (customerId <= 0) {
            return "Invalid Customer ID";
        }

        customerService.deleteCustomer(customerId);

        return "Customer Deleted Successfully";
    }

    // =========================
    // GET CUSTOMER BY ID
    // =========================
    public Customer getCustomerById(int customerId) {

        return customerService.getCustomerById(customerId);
    }

    // =========================
    // GET ALL CUSTOMERS
    // =========================
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    // =========================
    // SEARCH BY NATIONAL ID
    // =========================
    public Customer searchByNationalId(String nationalId) {

        return customerService.findByNationalId(nationalId);
    }

    // =========================
    // SEARCH BY PHONE
    // =========================
    public Customer searchByPhone(String phone) {

        return customerService.findByPhone(phone);
    }

    // =========================
    // CLEAR FORM
    // =========================
    public Customer clearForm() {

        return new Customer();
    }
}