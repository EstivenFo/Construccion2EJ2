package app.adapter.rest.request;

public class OrderItemRequest {

    private String idOrderItem;   // Se recibe como texto
    private String type;          // Ej: "Medicamento", "Procedimiento", "Ayuda"
    private String description;   // Ej: "Paracetamol 500mg"
    private String details;       // Ej: "Cada 8 horas vía oral"

    public String getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(String idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
