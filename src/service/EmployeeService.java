package service;

import dao.EmployeeDAO;
import model.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();

    public void addEmployee(Employee e) {
        dao.insert(e);
    }

    public void updateEmployee(Employee e) {
        dao.update(e);
    }

    public void deleteEmployee(int id) {
        dao.delete(id);
    }

    public List<Employee> getAll() {
        return dao.findAll();
    }

    public List<Employee> getByBranch(int branchId) {
        return dao.findByBranch(branchId);
    }
}