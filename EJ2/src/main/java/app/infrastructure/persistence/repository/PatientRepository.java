package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    // Buscar por número de documento
    PatientEntity findById(long patientId);

    // Buscar por email
    PatientEntity findByEmail(String email);

    // Buscar por nombre
    List<PatientEntity> findByFullNameContainingIgnoreCase(String fullName);
  
}
