package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Buscar usuario por número de cédula
    UserEntity findByIdCard(Long idCard);

    // Buscar usuario por correo electrónico
    UserEntity findByEmail(String email);
}
