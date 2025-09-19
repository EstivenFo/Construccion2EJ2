package app.infrastructure.persistence.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private long invoiceId;

    @Column(nullable = false, length = 100)
    private String patientName;

    @Column(nullable = false)
    private long patientAge;

    @Column(nullable = false, unique = true)
    private long patientIdCard;

    @Column(nullable = false, length = 100)
    private String doctorName;

    @Column(length = 100)
    private String insuranceName;

    @Column(length = 50)
    private String policyNumber;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private double totalAmount;

    // Relación con Order (si tienes tabla OrderEntity)
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    // Getters y Setters
    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public long getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(long patientAge) {
        this.patientAge = patientAge;
    }

    public long getPatientIdCard() {
        return patientIdCard;
    }

    public void setPatientIdCard(long patientIdCard) {
        this.patientIdCard = patientIdCard;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
