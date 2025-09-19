package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

import app.adapter.in.validators.RecordValidator;
import app.domain.model.Record;
import app.domain.model.User;

@Component
public class RecordBuilder {

	@Autowired
	private RecordValidator recordValidator;

	public Record build(String doctorId, String patientId, String patientName, String creationDate,
			String diagnosis, String treatment, List<String> tests, List<String> prescriptions, String notes) throws Exception {

		Record record = new Record();
		User doctor = new User();
		User patient = new User();

		// === VALIDACIONES ===
		doctor.setIdCard(recordValidator.doctorIdValidator(doctorId));
		patient.setIdCard(recordValidator.patientIdValidator(patientId));
		patient.setFullName(recordValidator.patientNameValidator(patientName));
		record.setCreationDate(recordValidator.creationDateValidator(creationDate));
		record.setDiagnosis(recordValidator.diagnosisValidator(diagnosis));
		record.setTreatment(recordValidator.treatmentValidator(treatment));
		record.setTests(recordValidator.testsValidator(tests));
		record.setPrescriptions(recordValidator.prescriptionsValidator(prescriptions));
		record.setNotes(recordValidator.notesValidator(notes));

		return record;
	}
}
