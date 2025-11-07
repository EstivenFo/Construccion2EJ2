package app.adapter.rest.request;

import java.util.List;

public class OrderRequest {

    private String orderNumber;        // Se recibe como texto
    private String patientId;          // ID o documento del paciente
    private String doctorId;           // ID o documento del médico
    private String creationDate;       // Fecha en formato "YYYY-MM-DD"
    private List<OrderItemRequest> items;  // Lista de ítems de la orden

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
