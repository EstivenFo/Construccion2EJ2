package app.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "records")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private long doctorId;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(length = 500)
    private String diagnosis;

    @Column(length = 500)
    private String treatment;

    // Guardamos listas como colecciones de elementos simples
    @ElementCollection
    @CollectionTable(name = "record_tests", joinColumns = @JoinColumn(name = "record_id"))
    @Column(name = "test")
    private List<String> tests;

    @ElementCollection
    @CollectionTable(name = "record_prescriptions", joinColumns = @JoinColumn(name = "record_id"))
    @Column(name = "prescription")
    private List<String> prescriptions;

    @Column(length = 1000)
    private String notes;

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
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
