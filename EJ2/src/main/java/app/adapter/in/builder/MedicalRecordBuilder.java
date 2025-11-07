package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.MedicalRecordValidator;
import app.domain.model.MedicalRecord;
import app.domain.model.Person;

@Component
public class MedicalRecordBuilder {

    @Autowired
    private MedicalRecordValidator medicalRecordValidator;

    public MedicalRecord build(
            String creationDate,
            String doctorId,
            String patientId,
            String consultationReason,
            String symptoms,
            String diagnosis,
            String treatment) throws Exception {

        MedicalRecord medicalRecord = new MedicalRecord();
        Person doctor = new Person();
        Person patient = new Person();

        // === VALIDACIONES ===
        medicalRecord.setCreationDate(medicalRecordValidator.creationDateValidator(creationDate));
        doctor.setIdCard(medicalRecordValidator.doctorIdValidator(doctorId));
        patient.setIdCard(medicalRecordValidator.patientIdValidator(patientId));
        medicalRecord.setConsultationReason(medicalRecordValidator.consultationReasonValidator(consultationReason));
        medicalRecord.setSymptoms(medicalRecordValidator.symptomsValidator(symptoms));
        medicalRecord.setDiagnosis(medicalRecordValidator.diagnosisValidator(diagnosis));
        medicalRecord.setTreatment(medicalRecordValidator.treatmentValidator(treatment));

        return medicalRecord;
    }
}
