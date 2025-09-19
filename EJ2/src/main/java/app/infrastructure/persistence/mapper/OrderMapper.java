package app.infrastructure.persistence.mapper;

import java.util.stream.Collectors;
import app.domain.model.Order;
import app.infrastructure.persistence.entities.OrderEntity;
import app.infrastructure.persistence.entities.OrderItemEntity;

public class OrderMapper {

    // Dominio → Entidad
    public static OrderEntity toEntity(Order domain) {
        if (domain == null) return null;

        OrderEntity entity = new OrderEntity();
        entity.setOrderNumber(domain.getOrderNumber());
        entity.setPatientId(domain.getPatientId());
        entity.setDoctorId(domain.getDoctorId());
        entity.setCreationDate(domain.getCreationDate());

        // Mapear los items
        entity.setItems(domain.getItems().stream()
                .map(item -> {
                    OrderItemEntity itemEntity = OrderItemMapper.toEntity(item);
                    itemEntity.setOrder(entity); // vínculo con la orden
                    return itemEntity;
                })
                .collect(Collectors.toList()));

        return entity;
    }

    // Entidad → Dominio
    public static Order toDomain(OrderEntity entity) {
        if (entity == null) return null;

        Order domain = new Order();
        domain.setOrderNumber(entity.getOrderNumber());
        domain.setPatientId(entity.getPatientId());
        domain.setDoctorId(entity.getDoctorId());
        domain.setCreationDate(entity.getCreationDate());

        // Mapear los items
        entity.getItems().forEach(itemEntity ->
            domain.addItem(OrderItemMapper.toDomain(itemEntity))
        );

        return domain;
    }
}
