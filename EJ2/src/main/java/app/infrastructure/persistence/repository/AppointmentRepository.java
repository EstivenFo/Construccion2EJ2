package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.AppointmentEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    
    // Aquí puedes definir queries personalizadas si las necesitas
    // Ejemplo: buscar todas las citas por doctor
    // List<AppointmentEntity> findByDoctorId(Long doctorId);
}
