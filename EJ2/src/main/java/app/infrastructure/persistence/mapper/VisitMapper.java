package app.infrastructure.persistence.mapper;

import app.domain.model.Visit;
import app.infrastructure.persistence.entities.VisitEntity;

public class VisitMapper {

    public static VisitEntity toEntity(Visit visit) {
        VisitEntity entity = new VisitEntity();
        entity.setBloodPressure(visit.getBloodPressure());
        entity.setTemperature(visit.getTemperature());
        entity.setPulse(visit.getPulse());
        entity.setOxygenLevel(visit.getOxygenLevel());
        entity.setObservations(visit.getObservations());
        entity.setDateTime(visit.getDateTime());
        entity.setPatientId(visit.getPatientId());
        entity.setUserId(visit.getUserId());
        return entity;
    }

    public static Visit toDomain(VisitEntity entity) {
        Visit visit = new Visit();
        visit.setBloodPressure(entity.getBloodPressure());
        visit.setTemperature(entity.getTemperature());
        visit.setPulse(entity.getPulse());
        visit.setOxygenLevel(entity.getOxygenLevel());
        visit.setObservations(entity.getObservations());
        visit.setDateTime(entity.getDateTime());
        visit.setPatientId(entity.getPatientId());
        visit.setUserId(entity.getUserId());
        return visit;
    }
}
