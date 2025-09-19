package app.infrastructure.persistence.mapper;

import app.domain.model.Appointment;
import app.infrastructure.persistence.entities.AppointmentEntity;

public class AppointmentMapper {

    // Dominio → Entidad
    public static AppointmentEntity toEntity(Appointment domain) {
        if (domain == null) return null;

        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(domain.getId());

        // Relaciones
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));

        // Propiedades simples
        entity.setDate(domain.getDate());
        entity.setReason(domain.getReason());
        entity.setStatus(domain.getStatus());

        return entity;
    }

    // Entidad → Dominio
    public static Appointment toDomain(AppointmentEntity entity) {
        if (entity == null) return null;

        Appointment domain = new Appointment();
        domain.setId(entity.getId());

        // Relaciones
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));

        // Propiedades simples
        domain.setDate(entity.getDate());
        domain.setReason(entity.getReason());
        domain.setStatus(entity.getStatus());

        return domain;
    }
}
