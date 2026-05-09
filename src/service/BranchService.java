package service;

import dao.BranchDAO;
import model.Branch;

import java.util.List;

public class BranchService {

    private BranchDAO dao = new BranchDAO();

    public void addBranch(Branch b) {
        dao.insert(b);
    }

    public void updateBranch(Branch b) {
        dao.update(b);
    }

    public void deleteBranch(int id) {
        dao.delete(id);
    }

    public List<Branch> getAllBranches() {
        return dao.findAll();
    }

    public Branch getById(int id) {
        return dao.findById(id);
    }
}