package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class OrderValidator extends SimpleValidator {

    public int orderNumberValidator(String value) throws Exception {
        return intValidator("número de la orden", value);
    }

    public long patientIdValidator(String value) throws Exception {
        return longValidator("ID del paciente", value);
    }

    public long doctorIdValidator(String value) throws Exception {
        return longValidator("ID del doctor", value);
    }

    public java.time.LocalDate creationDateValidator(String value) throws Exception {
        return localDateValidator("fecha de creación", value);
    }
}
