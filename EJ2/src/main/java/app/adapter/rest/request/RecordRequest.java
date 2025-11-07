package app.adapter.rest.request;

import java.util.List;

public class RecordRequest {

    private String creationDate;          // Fecha de creación (por ejemplo: "2025-11-06")
    private String doctorId;              // ID o documento del médico responsable
    private String dateTime;              // Fecha y hora de la atención ("2025-11-06T14:30")
    private String diagnosis;             // Diagnóstico del paciente
    private String treatment;             // Tratamiento prescrito
    private List<String> tests;           // Lista de pruebas realizadas o solicitadas
    private List<String> prescriptions;   // Lista de medicamentos o recetas
    private String notes;                 // Observaciones adicionales

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public List<String> getTests() {
        return tests;
    }

    public void setTests(List<String> tests) {
        this.tests = tests;
    }

    public List<String> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<String> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
