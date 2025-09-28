package app.adapter.out;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import app.domain.model.Visit;
import app.domain.ports.VisitPort;
import app.infrastructure.persistence.entities.VisitEntity;
import app.infrastructure.persistence.mapper.VisitMapper;
import app.infrastructure.persistence.repository.VisitRepository;

@Component
public class VisitAdapter implements VisitPort {

    @Autowired
    private VisitRepository repository;

    @Override
    public void save(Visit visit) throws Exception {
        VisitEntity entity = VisitMapper.toEntity(visit);
        repository.save(entity);
    }

    @Override
    public Visit findById(long patientId) throws Exception {
        VisitEntity entity = repository.findById(patientId)
                .orElseThrow(() -> new Exception("Visit not found"));
        return VisitMapper.toDomain(entity);
    }

    @Override
    public List<Visit> findAllByPatient(long patientId) throws Exception {
        List<VisitEntity> entities = repository.findByPatientId(patientId);
        return entities.stream().map(VisitMapper::toDomain).collect(Collectors.toList());
    }
}
