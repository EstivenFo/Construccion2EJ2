package app.adapter.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.PatientRepository;

@Service
public class PatientAdapter implements PatientPort {

    @Autowired
    private PatientRepository patientRepository;
    
    

    @Override
    public void save(Patient patient) throws Exception {
        PatientEntity entity = PatientMapper.toEntity(patient);
        patientRepository.save(entity);
    }
    @Override
    public Patient search(Patient patient) throws Exception {
        PatientEntity entity = patientRepository.findById(patient.getPatientId());
        return PatientMapper.toDomain(entity);
    }

    @Override
    public List<Patient> searchPatient(Patient patient) throws Exception {
        List<PatientEntity> entities = patientRepository.findByFullNameContainingIgnoreCase(patient.getFullName());
        return entities.stream().map(PatientMapper::toDomain).toList();
    }

    @Override
    public void search(long patientId) throws Exception {
        patientRepository.findById(patientId);
    }

    @Override
    public Patient findById(Patient patient) throws Exception {
        PatientEntity entity = patientRepository.findById(patient.getPatientId());
        return PatientMapper.toDomain(entity);
    }
}
