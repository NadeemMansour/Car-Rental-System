package controller;

import model.Customer;
import service.CustomerService;

import java.util.List;

public class CustomerController {

    private final CustomerService service = new CustomerService();

    // =========================
    // ➕ CREATE CUSTOMER
    // =========================
    public Response<String> addCustomer(Customer c) {

        if (!isValidCustomer(c)) {
            return Response.error("Invalid Customer Data");
        }

        service.addCustomer(c);
        return Response.success("Customer Added Successfully", null);
    }

    // =========================
    // ✏️ UPDATE CUSTOMER
    // =========================
    public Response<String> updateCustomer(Customer c) {

        if (c == null || c.getCustomerId() <= 0) {
            return Response.error("Invalid Customer Data");
        }

        service.updateCustomer(c);
        return Response.success("Customer Updated Successfully", null);
    }

    // =========================
    // ❌ DELETE CUSTOMER
    // =========================
    public Response<String> deleteCustomer(int id) {

        if (id <= 0) {
            return Response.error("Invalid Customer ID");
        }

        service.deleteCustomer(id);
        return Response.success("Customer Deleted Successfully", null);
    }

    // =========================
    // 🔍 GET BY ID
    // =========================
    public Response<Customer> getById(int id) {

        if (id <= 0) {
            return Response.error("Invalid Customer ID");
        }

        Customer customer = service.getCustomerById(id);

        if (customer == null) {
            return Response.error("Customer Not Found");
        }

        return Response.success("Customer Found", customer);
    }

    // =========================
    // 📋 GET ALL
    // =========================
    public Response<List<Customer>> getAllCustomers() {

        List<Customer> list = service.getAllCustomers();

        return Response.success("Customers Loaded Successfully", list);
    }

    // =========================
    // 🧠 VALIDATION
    // =========================
    private boolean isValidCustomer(Customer c) {

        return c != null
                && c.getFullName() != null
                && !c.getFullName().isBlank()
                && c.getPhone() != null
                && !c.getPhone().isBlank();
    }
}

// package controller;

// import model.Customer;
// import service.CustomerService;

// import java.util.List;

// public class CustomerController {

//     private CustomerService service = new CustomerService();

//     public String addCustomer(Customer c) {
//         if (c == null) return "Invalid Customer";

//         service.addCustomer(c);
//         return "Customer Added Successfully";
//     }

//     public String updateCustomer(Customer c) {
//         service.updateCustomer(c);
//         return "Customer Updated";
//     }

//     public String deleteCustomer(int id) {
//         service.deleteCustomer(id);
//         return "Customer Deleted";
//     }

//     public Customer getById(int id) {
//         return service.getCustomerById(id);
//     }

//     public List<Customer> getAll() {
//         return service.getAllCustomers();
//     }
// }