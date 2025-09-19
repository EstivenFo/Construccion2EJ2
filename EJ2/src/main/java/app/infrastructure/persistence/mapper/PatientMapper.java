package app.infrastructure.persistence.mapper;

import app.domain.model.Patient;
import app.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    // Dominio → Entidad
    public static PatientEntity toEntity(Patient domain) {
        if (domain == null) return null;

        PatientEntity entity = new PatientEntity();
        entity.setPatientId(domain.getPatientId());
        entity.setFullName(domain.getFullName());
        entity.setBirthDate(domain.getBirthDate());
        entity.setGender(domain.getGender());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setEmail(domain.getEmail());
        entity.setEmergencyContact(domain.getEmergencyContact());
        entity.setEmergencyContactRelationship(domain.getEmergencyContactRelationship());
        entity.setEmergencyContactNumber(domain.getEmergencyContactNumber());

        // Relación con User (se delega al mapper)
        entity.setUser(UserMapper.toEntity(domain.getUser()));

        return entity;
    }

    // Entidad → Dominio
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;

        Patient domain = new Patient();
        domain.setPatientId(entity.getPatientId());
        domain.setFullName(entity.getFullName());
        domain.setBirthDate(entity.getBirthDate());
        domain.setGender(entity.getGender());
        domain.setAddress(entity.getAddress());
        domain.setPhone(entity.getPhone());
        domain.setEmail(entity.getEmail());
        domain.setEmergencyContact(entity.getEmergencyContact());
        domain.setEmergencyContactRelationship(entity.getEmergencyContactRelationship());
        domain.setEmergencyContactNumber(entity.getEmergencyContactNumber());

        // Relación con User
        domain.setUser(UserMapper.toDomain(entity.getUser()));

        return domain;
    }
}
