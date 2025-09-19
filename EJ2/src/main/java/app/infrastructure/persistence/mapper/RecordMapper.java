package app.infrastructure.persistence.mapper;

import app.domain.model.Record;
import app.infrastructure.persistence.entities.RecordEntity;

public class RecordMapper {

    // Dominio → Entidad
    public static RecordEntity toEntity(Record domain) {
        if (domain == null) return null;

        RecordEntity entity = new RecordEntity();
        entity.setCreationDate(domain.getCreationDate());
        entity.setDoctorId(domain.getDoctorId());
        entity.setDateTime(domain.getDateTime());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setTreatment(domain.getTreatment());
        entity.setTests(domain.getTests());
        entity.setPrescriptions(domain.getPrescriptions());
        entity.setNotes(domain.getNotes());
        return entity;
    }

    // Entidad → Dominio
    public static Record toDomain(RecordEntity entity) {
        if (entity == null) return null;

        Record domain = new Record();
        domain.setCreationDate(entity.getCreationDate());
        domain.setDoctorId(entity.getDoctorId());
        domain.setDateTime(entity.getDateTime());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setTreatment(entity.getTreatment());
        domain.setTests(entity.getTests());
        domain.setPrescriptions(entity.getPrescriptions());
        domain.setNotes(entity.getNotes());
        return domain;
    }
}
