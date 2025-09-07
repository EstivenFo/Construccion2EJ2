package app.adapter.in.client;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 
import app.application.usecases.AdminStaffUseCase;
import app.domain.model.Appointment;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Gender;
import app.domain.model.enums.Role;
import app.domain.model.enums.Status;
 
@Controller
public class AdminStaffClient {
 
    private static final String MENU = """
            Ingrese una de las opciones:
            1. Crear paciente
            2. Actualizar paciente
            3. Crear cita
            4. Crear factura
            5. Salir
            """;
 
    private static final Scanner reader = new Scanner(System.in);
 
    @Autowired
    private AdminStaffUseCase adminStaffUseCase;
 
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
                    Patient patient = readPatient();
                    adminStaffUseCase.createPatient(patient);
                    return true;
                }
                case "2" -> {
                    Patient patient = readPatient();
                    adminStaffUseCase.updatePatient(patient);
                    return true;
                }
                case "3" -> {
                    Appointment appointment = readAppointment();
                    if (appointment != null) {
                        adminStaffUseCase.createAppointmet(appointment);
                    }
                    return true;
                }
                case "4" -> {
                    Invoice invoice = readInvoice();
                    adminStaffUseCase.createInvoice(invoice);
                    return true;
                }
                case "5" -> {
                    System.out.println("Hasta luego. Cerrando sesión...");
                    return false;
                }
                default -> {
                    System.out.println("Ingrese una opción válida.");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
    }
 
    // === Métodos auxiliares ===
 
    private Patient readPatient() {
        Patient patient = new Patient();
 
        System.out.println("Ingrese el nombre completo:");
        patient.setFullName(reader.nextLine());
 
        System.out.println("Ingrese la fecha de nacimiento (formato yyyyMMdd):");
        patient.setBirthDate(Long.parseLong(reader.nextLine()));
 
        System.out.println("Ingrese el género (MALE, FEMALE, OTHER):");
        patient.setGender(Gender.valueOf(reader.nextLine().toUpperCase()));
 
        System.out.println("Ingrese la dirección:");
        patient.setAddress(reader.nextLine());
 
        System.out.println("Ingrese el teléfono:");
        patient.setPhone(Long.parseLong(reader.nextLine()));
 
        System.out.println("Ingrese el correo electrónico:");
        patient.setEmail(reader.nextLine());
 
        System.out.println("Ingrese el nombre del contacto de emergencia:");
        patient.setEmergencyContact(reader.nextLine());
 
        System.out.println("Ingrese la relación con el contacto de emergencia:");
        patient.setEmergencyContactRelationship(reader.nextLine());
 
        System.out.println("Ingrese el número del contacto de emergencia:");
        patient.setEmergencyContactNumber(Long.parseLong(reader.nextLine()));
 
        return patient;
    }
 
    private Invoice readInvoice() {
        Invoice invoice = new Invoice();
 
        // invoiceId no se pide porque es autoincrementable
 
        System.out.println("Ingrese el nombre del paciente:");
        invoice.setPatientName(reader.nextLine());
 
        System.out.println("Ingrese la edad del paciente:");
        invoice.setPatientAge(Integer.parseInt(reader.nextLine()));
 
        System.out.println("Ingrese el documento de identidad del paciente:");
        invoice.setPatientIdCard(reader.nextLine());
 
        System.out.println("Ingrese el nombre del doctor:");
        invoice.setDoctorName(reader.nextLine());
 
        System.out.println("Ingrese el nombre de la aseguradora:");
        invoice.setInsuranceName(reader.nextLine());
 
        System.out.println("Ingrese el número de póliza:");
        invoice.setPolicyNumber(reader.nextLine());
 
        System.out.println("Ingrese la fecha de la factura (formato yyyy-MM-dd):");
        String dateInput = reader.nextLine();
        invoice.setDate(LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
 
        System.out.println("Ingrese el monto total:");
        invoice.setTotalAmount(Double.parseDouble(reader.nextLine()));
 
        return invoice;
    }
 
    private Appointment readAppointment() {
        Appointment appointment = new Appointment();
 
        System.out.println("=== Datos del paciente para la cita ===");
        Patient patient = readPatient();
        appointment.setPatient(patient);
 
        // 🔑 Ahora pedimos solo la cédula del doctor
        System.out.println("Ingrese la cédula del doctor que atenderá la cita:");
        long doctorIdCard = Long.parseLong(reader.nextLine());
 
        // Buscar al doctor en la BD (simulación)
        User doctor = searchDoctorById(doctorIdCard);
 
        if (doctor == null) {
            System.out.println("⚠️ No se encontró un doctor con esa cédula.");
            return null;
        }
        appointment.setDoctor(doctor);
 
        System.out.println("Ingrese la fecha de la cita (formato yyyy-MM-dd HH:mm):");
        String dateInput = reader.nextLine();
        appointment.setDate(LocalDateTime.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
 
        System.out.println("Ingrese el motivo de la cita:");
        appointment.setReason(reader.nextLine());
 
        System.out.println("Ingrese el estado de la cita (PENDING, CONFIRMED, CANCELED):");
        appointment.setStatus(Status.valueOf(reader.nextLine().toUpperCase()));
 
        return appointment;
    }
 
    // === Simulación de consulta a BD ===
    private User searchDoctorById(long idCard) {
        // En un caso real, deberías usar un repositorio o servicio para obtener el doctor
        // Aquí simulamos un doctor de prueba
        if (idCard == 12345L) {
            User doctor = new User();
            doctor.setIdCard(idCard);
            doctor.setFullName("Dr. Ejemplo");
            doctor.setRole(Role.MEDIC);
            doctor.setGender(Gender.MALE);
            return doctor;
        }
        return null;
    }
}
 