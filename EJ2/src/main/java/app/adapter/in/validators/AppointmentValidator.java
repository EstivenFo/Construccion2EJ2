package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class AppointmentValidator extends SimpleValidator {

    public long patientIdValidator(String value) throws Exception {
        return longValidator("ID del paciente", value);
    }

    public long doctorIdValidator(String value) throws Exception {
        return longValidator("ID del doctor", value);
    }

    public LocalDate dateValidator(String value) throws Exception {
        return localDateValidator("fecha y hora de la cita", value);
    }

    public String reasonValidator(String value) throws Exception {
        return stringValidator("motivo de la cita", value);
    }

    public String statusValidator(String value) throws Exception {
        return stringValidator("estado de la cita", value);
    }
}
