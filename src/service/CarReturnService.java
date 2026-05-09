package service;

import dao.CarReturnDAO;
import model.CarReturn;

import java.util.List;

public class CarReturnService {

    private final CarReturnDAO dao = new CarReturnDAO();

    // 🔁 تسجيل إرجاع سيارة
    public void returnCar(CarReturn carReturn) {

        // ❌ Validation (أساسي جدًا في الإنتاج)
        if (carReturn == null) {
            throw new IllegalArgumentException("CarReturn cannot be null");
        }

        if (carReturn.getRentalId() <= 0) {
            throw new IllegalArgumentException("Invalid Rental ID");
        }

        if (carReturn.getEmployeeId() <= 0) {
            throw new IllegalArgumentException("Invalid Employee ID");
        }

        if (carReturn.getReturnDate() == null) {
            throw new IllegalArgumentException("Return date is required");
        }

        // 💾 Save to database
        dao.insert(carReturn);
    }

    // 📋 جلب كل الإرجاعات
    public List<CarReturn> getAllReturns() {
        return dao.findAll();
    }

    // 🔍 جلب إرجاع حسب ID
    public CarReturn getById(int id) {
        return dao.findById(id);
    }
}