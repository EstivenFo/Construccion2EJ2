package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RecordValidator extends SimpleValidator {

    public long doctorIdValidator(String value) throws Exception {
        return longValidator("ID del doctor", value);
    }

    public LocalDate dateTimeValidator(String value) throws Exception {
        return localDateValidator("fecha y hora de la atención", value);
    }

    public String diagnosisValidator(String value) throws Exception {
        return stringValidator("diagnóstico", value);
    }

    public String treatmentValidator(String value) throws Exception {
        return stringValidator("tratamiento", value);
    }

    public List<String> testsValidator(List<String> values) throws Exception {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("La lista de pruebas no puede estar vacía.");
        }
        return values;
    }

    public List<String> prescriptionsValidator(List<String> values) throws Exception {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("La lista de prescripciones no puede estar vacía.");
        }
        return values;
    }

    public String notesValidator(String value) throws Exception {
        return stringValidator("notas", value);
    }
}
