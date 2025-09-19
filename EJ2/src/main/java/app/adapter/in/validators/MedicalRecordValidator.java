package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class MedicalRecordValidator extends SimpleValidator {

	public java.time.LocalDate creationDateValidator(String value) throws Exception {
        return localDateValidator("fecha de creación", value);
	}

	public long doctorIdValidator(String value) throws Exception {
		return longValidator("ID del doctor", value);
	}

	public long patientIdValidator(String value) throws Exception {
		return longValidator("ID del patient", value);
	}

	public String consultationReasonValidator(String value) throws Exception {
		return stringValidator("motivo de la consulta", value);
	}

	public String symptomsValidator(String value) throws Exception {
		return stringValidator("síntomas", value);
	}

	public String diagnosisValidator(String value) throws Exception {
		return stringValidator("diagnóstico", value);
	}

	public String treatmentValidator(String value) throws Exception {
		return stringValidator("tratamiento", value);
	}
}
