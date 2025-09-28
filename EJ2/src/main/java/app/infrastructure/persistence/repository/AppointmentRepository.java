package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.AppointmentEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    // ✅ Busca todas las citas por el id del paciente
    List<AppointmentEntity> findByPatient_Id(Long patientId);

    // ✅ Busca todas las citas por el id del doctor
    List<AppointmentEntity> findByDoctor_Id(Long doctorId);
}
