package app.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private long orderNumber;
	private long patientId;
	private long doctorId;
	private LocalDate creationDate;
	private List<OrderItem> items = new ArrayList<>();

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		this.items.add(item);
	}
}
