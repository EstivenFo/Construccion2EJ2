package app.adapter.in.client;
 
import java.util.Scanner;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 
import app.application.usecases.NurseUseCase;
import app.domain.model.Order;
import app.domain.model.OrderItem;
import app.domain.model.Patient;
import app.domain.model.Visit;
 
@Controller
public class NurseClient {
 
    private static final String MENU = """
            Ingrese una de las opciones:
            1. Registrar visita
            2. Buscar paciente
            3. Buscar órdenes por paciente
            4. Salir
            """;
 
    private static final Scanner reader = new Scanner(System.in);
 
    @Autowired
    private NurseUseCase nurseUseCase;
 
    public void session() {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }
 
    private boolean menu() {
        try {
            System.out.println(MENU);
            String option = reader.nextLine();
            switch (option) {
                case "1" -> {
                    Visit visit = readVisit();
                    nurseUseCase.createVisit(visit);
                    return true;
                }
                case "2" -> {
                    Patient patient = readPatient();
                    nurseUseCase.searchPatient(patient);
                    return true;
                }
                case "3" -> {
                    Patient patient = readPatient();
                    nurseUseCase.searchOrdenByPatient(patient);
                    return true;
                }
                case "4" -> {
                    System.out.println("Hasta luego. Cerrando sesión...");
                    return false;
                }
                default -> {
                    System.out.println("Ingrese una opción válida.");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
            return true;
        }
    }
 
    // === Métodos auxiliares ===
 
    private Visit readVisit() {
        Visit visit = new Visit();
 
        System.out.println("Ingrese la presión arterial (ej: 120/80):");
        visit.setBloodPressure(reader.nextLine());
 
        System.out.println("Ingrese la temperatura (°C):");
        visit.setTemperature(Double.parseDouble(reader.nextLine()));
 
        System.out.println("Ingrese el pulso (lpm):");
        visit.setPulse(Integer.parseInt(reader.nextLine()));
 
        System.out.println("Ingrese el nivel de oxígeno (%):");
        visit.setOxygenLevel(Integer.parseInt(reader.nextLine()));
 
        System.out.println("Ingrese las observaciones de la visita:");
        visit.setObservations(reader.nextLine());
 
        return visit;
    }
 
    private Patient readPatient() {
        Patient patient = new Patient();
 
        System.out.println("Ingrese el ID del paciente:");
        patient.setPatientId(Long.parseLong(reader.nextLine()));
 
        System.out.println("Ingrese el nombre completo:");
        patient.setFullName(reader.nextLine());
 
        return patient;
    }
 
    private Order readOrder() {
        Order order = new Order();
 
        System.out.println("Ingrese el ID del paciente:");
        order.setPatientId(reader.nextLine());
 
        System.out.println("Ingrese el ID del doctor:");
        order.setDoctorId(reader.nextLine());
 
        // La fecha de creación puede asignarse automáticamente en la capa de dominio
 
        boolean addMore = true;
        while (addMore) {
            OrderItem item = readOrderItem();
            order.addItem(item);
 
            System.out.println("¿Desea agregar otro ítem? (s/n):");
            String response = reader.nextLine();
            addMore = response.equalsIgnoreCase("s");
        }
 
        return order;
    }
 
    private OrderItem readOrderItem() {
        System.out.println("Ingrese el tipo de ítem (Medicamento/Procedimiento/Ayuda):");
        String type = reader.nextLine();
 
        System.out.println("Ingrese la descripción del ítem:");
        String description = reader.nextLine();
 
        System.out.println("Ingrese los detalles:");
        String details = reader.nextLine();
 
        return new OrderItem(type, description, details);
    }
}
 