package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.VisitEntity;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {

    // Buscar visitas por paciente
    List<VisitEntity> findByPatientId(long patientId);

    // Buscar visitas por usuario (doctor/enfermera)
    List<VisitEntity> findByUserId(long userId);
}
