package app.adapter.in.validators;

import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
public class MedicalRecordValidator extends SimpleValidator {

	  public LocalDate dateValidator(String value) throws Exception {
	        return localDateValidator("fecha de la consulta", value);
    }

    public long doctorIdValidator(String value) throws Exception {
        return longValidator("ID del doctor", value);
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
