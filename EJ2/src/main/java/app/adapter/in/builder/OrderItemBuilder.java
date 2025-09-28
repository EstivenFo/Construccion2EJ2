package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapter.in.validators.OrderItemValidator;
import app.domain.model.OrderItem;


@Component

public class OrderItemBuilder {

	@Autowired

	private OrderItemValidator orderItemValidator;

	public OrderItem builder(String id, String type, String description, String details) throws Exception {

		OrderItem item = new OrderItem();

		item.setIdOrderItem(orderItemValidator.longValidator("ID del ítem", id));
		item.setType(orderItemValidator.typeValidator(type));
		item.setDescription(orderItemValidator.descriptionValidator(description));
		item.setDetails(orderItemValidator.detailsValidator(details));
		return item;

	}

}
