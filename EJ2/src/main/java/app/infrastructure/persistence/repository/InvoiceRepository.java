package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.InvoiceEntity;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    // Buscar facturas por cédula del paciente
    InvoiceEntity findByPatientIdCard(Long patientIdCard);

    // Buscar facturas por nombre del doctor
    InvoiceEntity findByDoctorName(String doctorName);
}
