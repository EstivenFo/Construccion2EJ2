package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.RecordEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity, Long> {

    // Buscar por doctor
    List<RecordEntity> findByDoctorId(long doctorId);

    // Buscar por fecha de creación
    List<RecordEntity> findByCreationDate(LocalDate creationDate);
}
