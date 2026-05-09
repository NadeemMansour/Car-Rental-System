package controller;

import model.RentalContract;
import service.RentalService;

import java.util.List;

public class RentalController {

    private RentalService service = new RentalService();

    public String createRental(RentalContract r) {
        service.createRental(r);
        return "Rental Created Successfully";
    }

    public List<RentalContract> getAllRentals() {
        return service.getAllRentals();
    }

    public List<RentalContract> getActiveRentals() {
        return service.getActiveRentals();
    }
}