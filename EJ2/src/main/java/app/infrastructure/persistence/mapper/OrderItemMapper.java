package app.infrastructure.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

import app.domain.model.OrderItem;
import app.infrastructure.persistence.entities.OrderItemEntity;

public class OrderItemMapper {

    // De dominio a entidad
    public static OrderItemEntity toEntity(OrderItem orderItem) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setType(orderItem.getType());
        entity.setDescription(orderItem.getDescription());
        entity.setDetails(orderItem.getDetails());
        return entity;
    }

    // De entidad a dominio
    public static OrderItem toDomain(OrderItemEntity entity) {
        return new OrderItem(
            entity.getType(),
            entity.getDescription(),
            entity.getDetails()
        );
    }

    // Lista dominio -> lista entidad
    public static List<OrderItemEntity> toEntityList(List<OrderItem> items) {
        return items.stream().map(OrderItemMapper::toEntity).collect(Collectors.toList());
    }

    // Lista entidad -> lista dominio
    public static List<OrderItem> toDomainList(List<OrderItemEntity> entities) {
        return entities.stream().map(OrderItemMapper::toDomain).collect(Collectors.toList());
    }
}
