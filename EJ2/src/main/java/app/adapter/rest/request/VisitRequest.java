package app.adapter.rest.request;

public class VisitRequest {

    private String userId;          // ID del usuario (médico o enfermero)
    private String patientId;       // ID del paciente
    private String dateTime;        // Fecha y hora de la visita (ej: "2025-11-06T14:30")
    private String bloodPressure;   // Ej: "120/80"
    private String temperature;     // Se recibe como texto (luego se convierte a double)
    private String pulse;           // Pulso en BPM
    private String oxygenLevel;     // Saturación de oxígeno (%)
    private String observations;    // Observaciones generales

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(String oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
