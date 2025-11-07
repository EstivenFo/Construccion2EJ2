package app.adapter.rest.request;

public class AppointmentRequest {

	private String patientDocument;
	private String doctorDocument;
	private String date; // Se usa String porque llega como texto en JSON
	private String reason;
	private String status;

	public String getPatientDocument() {
		return patientDocument;
	}

	public void setPatientDocument(String patientDocument) {
		this.patientDocument = patientDocument;
	}

	public String getDoctorDocument() {
		return doctorDocument;
	}

	public void setDoctorDocument(String doctorDocument) {
		this.doctorDocument = doctorDocument;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
