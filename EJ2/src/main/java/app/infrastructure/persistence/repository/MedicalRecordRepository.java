package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.MedicalRecordEntity;
import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordEntity, Long> {

    // Buscar todas las historias de un paciente
    List<MedicalRecordEntity> findByPatientId(long patientId);

    // Buscar todas las historias atendidas por un doctor
    List<MedicalRecordEntity> findByDoctorId(long doctorId);
}
