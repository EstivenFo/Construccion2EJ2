package app.domain.model;

import java.time.LocalDate;

public class Invoice {
	private long invoiceId;
	private String patientName;
	private long patientAge;
	private long patientIdCard;
	private String doctorName;
	private String insuranceName;
	private String policyNumber;
	private LocalDate date;
	private double totalAmount;
	private Order order;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}