package app.adapter.rest.response;

public class OrderItemResponse {
    private long idOrderItem;
    private String type;          // "Medicamento", "Procedimiento", "Ayuda"
    private String description;   // Descripción general (ej: "Paracetamol 500mg")
    private String details;       // Detalle (ej: "Cada 8 horas vía oral")

    // --- Getters y Setters ---
    public long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(long idOrderItem) {
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
