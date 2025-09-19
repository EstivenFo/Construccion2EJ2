package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    // Buscar paciente por email
    PatientEntity findByEmail(String email);

    // Buscar paciente por número de documento del usuario asociado
    PatientEntity findByUser_IdCard(Long idCard);
}
