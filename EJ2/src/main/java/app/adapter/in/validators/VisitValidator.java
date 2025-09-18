package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class VisitValidator extends SimpleValidator {

    public String bloodPressureValidator(String value) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("La presión arterial no puede estar vacía.");
        }
        // Validación básica formato: "120/80"
        if (!value.matches("\\d{2,3}/\\d{2,3}")) {
            throw new IllegalArgumentException("La presión arterial debe tener el formato ##/## (ejemplo: 120/80).");
        }
        return value;
    }

    public double temperatureValidator(String value) throws Exception {
        double temp = doubleValidator("temperatura", value);
        if (temp < 30.0 || temp > 45.0) {
            throw new IllegalArgumentException("La temperatura debe estar entre 30.0°C y 45.0°C.");
        }
        return temp;
    }

    public int pulseValidator(String value) throws Exception {
        int pulse = intValidator("pulso", value);
        if (pulse < 30 || pulse > 200) {
            throw new IllegalArgumentException("El pulso debe estar entre 30 y 200.");
        }
        return pulse;
    }

    public int oxygenLevelValidator(String value) throws Exception {
        int oxygen = intValidator("nivel de oxígeno", value);
        if (oxygen < 50 || oxygen > 100) {
            throw new IllegalArgumentException("El nivel de oxígeno debe estar entre 50 y 100%.");
        }
        return oxygen;
    }

    public String observationsValidator(String value) throws Exception {
        return stringValidator("observaciones", value);
    }
}
