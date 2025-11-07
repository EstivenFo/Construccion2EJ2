package app.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import app.domain.model.Person;
import app.infrastructure.persistence.entities.UserEntity;

@Component
public class UserMapper {

    // Dominio → Entidad
    public static UserEntity toEntity(Person domain) {
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
    public static Person toDomain(UserEntity entity) {
        if (entity == null) return null;

        Person domain = new Person();
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
