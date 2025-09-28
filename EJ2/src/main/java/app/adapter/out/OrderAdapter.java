package app.adapter.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import app.domain.model.Order;
import app.domain.model.Patient;
import app.domain.ports.OrderPort;

@Repository  // Spring lo registra como bean
public class OrderAdapter implements OrderPort {

    private final Map<Long, Order> database = new HashMap<>();

    @Override
    public void save(Order order) throws Exception {
        database.put(order.getOrderNumber(), order);
        System.out.println("Orden guardada en memoria con número: " + order.getOrderNumber());
    }

    @Override
    public Order searchById(long orderNumber) throws Exception {
        return database.get(orderNumber);
    }

    @Override
    public List<Order> findAll() throws Exception {
        return new ArrayList<>(database.values());
    }

    @Override
    public void update(Order order) throws Exception {
        if (!database.containsKey(order.getOrderNumber())) {
            throw new Exception("Orden con número " + order.getOrderNumber() + " no existe");
        }
        database.put(order.getOrderNumber(), order);
        System.out.println("Orden actualizada con número: " + order.getOrderNumber());
    }

    @Override
    public void delete(long orderNumber) throws Exception {
        if (!database.containsKey(orderNumber)) {
            throw new Exception("Orden con número " + orderNumber + " no existe");
        }
        database.remove(orderNumber);
        System.out.println("Orden eliminada con número: " + orderNumber);
    }

    @Override
    public List<Order> search(Patient patient) throws Exception {
        List<Order> result = new ArrayList<>();
        for (Order order : database.values()) {
            if (order.getPatientId() == patient.getPatientId()) {
                result.add(order);
            }
        }
        return result;
    }
}

