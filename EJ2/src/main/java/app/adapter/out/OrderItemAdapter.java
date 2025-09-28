package app.adapter.out;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.stereotype.Repository;
 
import app.domain.model.OrderItem;
import app.domain.ports.OrderItemPort;
 
@Repository
public class OrderItemAdapter implements OrderItemPort {
 
    private final Map<Long, OrderItem> database = new HashMap<>();
    private long sequence = 1L; // Simulación de autoincrement
 
    @Override
    public void save(OrderItem item) throws Exception {
        // asigna un id si no tiene
        if (item.getIdOrderItem() == 0) {
            item.setIdOrderItem(sequence++);
        }
        database.put(item.getIdOrderItem(), item);
        System.out.println("Item guardado con id: " + item.getIdOrderItem());
    }
 
    @Override
    public OrderItem searchById(long id) throws Exception {
        return database.get(id);
    }
 
    @Override
    public List<OrderItem> findAll() throws Exception {
        return new ArrayList<>(database.values());
    }
 
    @Override
    public void update(OrderItem item) throws Exception {
        if (!database.containsKey(item.getIdOrderItem())) {
            throw new Exception("Item con id " + item.getIdOrderItem() + " no existe");
        }
        database.put(item.getIdOrderItem(), item);
        System.out.println("Item actualizado con id: " + item.getIdOrderItem());
    }
 
    @Override
    public void delete(long id) throws Exception {
        if (!database.containsKey(id)) {
            throw new Exception("Item con id " + id + " no existe");
        }
        database.remove(id);
        System.out.println("Item eliminado con id: " + id);
    }
}