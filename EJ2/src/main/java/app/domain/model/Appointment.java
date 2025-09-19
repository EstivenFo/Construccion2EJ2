package app.domain.model;

import java.time.LocalDateTime;
import app.domain.model.enums.Status;

public class Appointment {

	private long id;
	private Patient patient;
	private User Doctor;
	private LocalDateTime date;
	private String reason;
	private Status status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public User getDoctor() {
		return Doctor;
	}
	public void setDoctor(User doctor) {
		Doctor = doctor;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	

}
