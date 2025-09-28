package app.domain.ports;
 
import java.util.List;
import app.domain.model.OrderItem;
 
public interface OrderItemPort {
 
    public void save(OrderItem item) throws Exception;
 
    OrderItem searchById(long id) throws Exception;
 
    List<OrderItem> findAll() throws Exception;
 
    public void update(OrderItem item) throws Exception;
 
    public void delete(long id) throws Exception;
}