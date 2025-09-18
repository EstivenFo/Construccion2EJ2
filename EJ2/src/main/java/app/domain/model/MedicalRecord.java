package app.domain.model;

public class MedicalRecord {
	private String date;
	private long doctorId;
	private String consultationReason;
	private String symptoms;
	private String diagnosis;
	private String Treatment;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getConsultationReason() {
		return consultationReason;
	}

	public void setConsultationReason(String consultationReason) {
		this.consultationReason = consultationReason;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return Treatment;
	}

	public void setTreatment(String treatment) {
		Treatment = treatment;
	}

}
