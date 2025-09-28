package app.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import app.domain.model.Patient;
import app.infrastructure.persistence.entities.PatientEntity;

@Component
public class PatientMapper {

    // Domain -> Entity
    public static PatientEntity toEntity(Patient patient) {
        if (patient == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        
        // ⚠️ Ajusta según tu entidad (usa setId si cambiaste el campo)
        entity.setId(patient.getPatientId());
        entity.setFullName(patient.getFullName());
        entity.setBirthDate(patient.getBirthDate());
        entity.setGender(patient.getGender());
        entity.setAddress(patient.getAddress());
        entity.setPhone(patient.getPhone());
        entity.setEmail(patient.getEmail());
        entity.setEmergencyContact(patient.getEmergencyContact());
        entity.setEmergencyContactRelationship(patient.getEmergencyContactRelationship());
        entity.setEmergencyContactNumber(patient.getEmergencyContactNumber());

        // Relación con User
        if (patient.getUser() != null) {
            entity.setUser(UserMapper.toEntity(patient.getUser())); 
        }

        return entity;
    }

    // Entity -> Domain
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        Patient patient = new Patient();
        
        // ⚠️ Ajusta según tu entidad (usa getId si cambiaste el campo)
        patient.setPatientId(entity.getId());
        patient.setFullName(entity.getFullName());
        patient.setBirthDate(entity.getBirthDate());
        patient.setGender(entity.getGender());
        patient.setAddress(entity.getAddress());
        patient.setPhone(entity.getPhone());
        patient.setEmail(entity.getEmail());
        patient.setEmergencyContact(entity.getEmergencyContact());
        patient.setEmergencyContactRelationship(entity.getEmergencyContactRelationship());
        patient.setEmergencyContactNumber(entity.getEmergencyContactNumber());

        // Relación con User
        if (entity.getUser() != null) {
            patient.setUser(UserMapper.toDomain(entity.getUser()));
        }

        return patient;
    }
}

