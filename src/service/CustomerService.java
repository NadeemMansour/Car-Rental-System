package service;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();

    public void addCustomer(Customer customer) {
        customerDAO.insert(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }

    public void deleteCustomer(int customerId) {
        customerDAO.delete(customerId);
    }

    public Customer getCustomerById(int id) {
        return customerDAO.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public Customer searchByNationalId(String nationalId) {
        return customerDAO.findByNationalId(nationalId);
    }

    public Customer searchByPhone(String phone) {
        return customerDAO.findByPhone(phone);
    }

    public boolean isCustomerExists(int id) {
        return customerDAO.exists(id);
    }
}