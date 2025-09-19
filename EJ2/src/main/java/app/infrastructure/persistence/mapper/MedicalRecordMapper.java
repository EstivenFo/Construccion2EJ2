package app.infrastructure.persistence.mapper;

import app.domain.model.MedicalRecord;
import app.infrastructure.persistence.entities.MedicalRecordEntity;

public class MedicalRecordMapper {

    // Dominio → Entidad
    public static MedicalRecordEntity toEntity(MedicalRecord domain) {
        if (domain == null) return null;

        MedicalRecordEntity entity = new MedicalRecordEntity();
        entity.setCreationDate(domain.getCreationDate());
        entity.setPatientId(domain.getPatientId());
        entity.setDoctorId(domain.getDoctorId());
        entity.setConsultationReason(domain.getConsultationReason());
        entity.setSymptoms(domain.getSymptoms());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setTreatment(domain.getTreatment());
        return entity;
    }

    // Entidad → Dominio
    public static MedicalRecord toDomain(MedicalRecordEntity entity) {
        if (entity == null) return null;

        MedicalRecord domain = new MedicalRecord();
        domain.setCreationDate(entity.getCreationDate());
        domain.setPatientId(entity.getPatientId());
        domain.setDoctorId(entity.getDoctorId());
        domain.setConsultationReason(entity.getConsultationReason());
        domain.setSymptoms(entity.getSymptoms());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setTreatment(entity.getTreatment());
        return domain;
    }
}
