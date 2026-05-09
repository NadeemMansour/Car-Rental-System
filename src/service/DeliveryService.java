package service;

import dao.CarDeliveryDAO;
import model.CarDelivery;

import java.util.List;

public class DeliveryService {

    private CarDeliveryDAO dao = new CarDeliveryDAO();

    public void deliverCar(CarDelivery d) {
        dao.insert(d);
    }

    public List<CarDelivery> getAllDeliveries() {
        return dao.findAll();
    }
}