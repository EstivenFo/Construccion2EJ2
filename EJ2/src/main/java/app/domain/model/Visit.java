package app.domain.model;

import java.time.LocalDateTime;

public class Visit {
	private long UserId;
	private long PatientId;
	private LocalDateTime dateTime;
	private String bloodPressure;
    private double temperature;
    private int pulse;
    private int oxygenLevel;
    private String observations;
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public long getPatientId() {
		return PatientId;
	}
	public void setPatientId(long patientId) {
		PatientId = patientId;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public int getPulse() {
		return pulse;
	}
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	public int getOxygenLevel() {
		return oxygenLevel;
	}
	public void setOxygenLevel(int oxygenLevel) {
		this.oxygenLevel = oxygenLevel;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
    
}