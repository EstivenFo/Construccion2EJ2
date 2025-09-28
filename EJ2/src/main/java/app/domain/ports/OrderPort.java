package app.domain.ports;

import app.domain.model.Order;
import app.domain.model.Patient;

import java.util.List;

public interface OrderPort {

	void save(Order order) throws Exception;

	Order searchById(long orderNumber) throws Exception;

	List<Order> findAll() throws Exception;

	void update(Order order) throws Exception;

	void delete(long orderNumber) throws Exception;

	public List<Order> search(Patient patient) throws Exception;

}
