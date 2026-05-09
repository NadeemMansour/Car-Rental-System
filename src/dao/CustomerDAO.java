package dao;

import model.Customer;
import java.util.List;

public class CustomerDAO {

    public void insert(Customer customer) {}
    public void update(Customer customer) {}
    public void delete(int customerId) {}

    public Customer findById(int id) { return null; }

    public List<Customer> findAll() { return null; }

    public Customer findByNationalId(String nationalId) { return null; }

    public Customer findByPhone(String phone) { return null; }

    public boolean exists(int id) { return false; }
}