package app.infrastructure.persistence.mapper;

import app.domain.model.User;
import app.infrastructure.persistence.entities.UserEntity;

public class UserMapper {

    // Dominio → Entidad
    public static UserEntity toEntity(User domain) {
        if (domain == null) return null;

        UserEntity entity = new UserEntity();
        entity.setIdCard(domain.getIdCard());  // lo tomo como ID
        entity.setFullName(domain.getFullName());
        entity.setEmail(domain.getEmail());
        entity.setPhone(domain.getPhone());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAddress(domain.getAddress());
        entity.setRole(domain.getRole());
        entity.setGender(domain.getGender());

        return entity;
    }

    // Entidad → Dominio
    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        User domain = new User();
        domain.setIdCard(entity.getIdCard());
        domain.setFullName(entity.getFullName());
        domain.setEmail(entity.getEmail());
        domain.setPhone(entity.getPhone());
        domain.setBirthDate(entity.getBirthDate());
        domain.setAddress(entity.getAddress());
        domain.setRole(entity.getRole());
        domain.setGender(entity.getGender());

        return domain;
    }
}
