package app.adapter.in.client;
<<<<<<< HEAD

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.domain.model.Patient;
import app.domain.model.Appointment;
import app.domain.model.Invoice;
=======
 
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
>>>>>>> 39c238734a14a717ea9c851412ec64e52399b237
import app.domain.model.User;
import app.domain.model.enums.Gender;
import app.domain.model.enums.Role;
import app.domain.model.enums.Status;
<<<<<<< HEAD
import app.domain.services.CreatePatient;
import app.domain.services.UpdatePatient;
import app.domain.services.CreateAppointment;
import app.domain.services.CreateInvoice;

@Controller
public class AdminStaffClient {

	private static final Scanner sc = new Scanner(System.in);
	@Autowired
	private  CreatePatient createPatient;
	@Autowired
	private  UpdatePatient updatePatient;
	@Autowired
	private  CreateAppointment createAppointment;
	@Autowired
	private  CreateInvoice createInvoice;

	@Autowired
	public AdminStaffClient(CreatePatient createPatient, UpdatePatient updatePatient,
			CreateAppointment createAppointment, CreateInvoice createInvoice) {
		this.createPatient = createPatient;
		this.updatePatient = updatePatient;
		this.createAppointment = createAppointment;
		this.createInvoice = createInvoice;
	}

	private static final String MENU = """
			=== Menú Personal Administrativo ===
			1. Crear Paciente
			2. Actualizar Paciente
			3. Crear Cita
			4. Crear Factura
			0. Salir
			""";

	public void run() {
		int opcion;
		do {
			System.out.println(MENU);
			opcion = sc.nextInt();
			sc.nextLine(); // limpiar buffer

			try {
				switch (opcion) {
				case 1 -> crearPaciente();
				case 2 -> actualizarPaciente();
				case 3 -> crearCita();
				case 4 -> crearFactura();
				case 0 -> System.out.println("Saliendo...");
				default -> System.out.println("Opción inválida");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcion != 0);
	}

	private void crearPaciente() throws Exception {
		Patient patient = new Patient();

		System.out.print("Nombre completo: ");
		patient.setFullName(sc.nextLine());

		System.out.print("Fecha de nacimiento (YYYYMMDD): ");
		patient.setBirthDate(sc.nextLong());
		sc.nextLine();

		System.out.print("Género (M/F): ");
		String gender = sc.nextLine().toUpperCase();
		patient.setGender(gender.equals("M") ? Gender.MALE : Gender.FEMALE);

		System.out.print("Dirección: ");
		patient.setAddress(sc.nextLine());

		System.out.print("Teléfono: ");
		patient.setPhone(sc.nextLong());
		sc.nextLine();

		System.out.print("Email: ");
		patient.setEmail(sc.nextLine());

		System.out.print("Contacto de emergencia: ");
		patient.setEmergencyContact(sc.nextLine());

		System.out.print("Parentesco contacto: ");
		patient.setEmergencyContactRelationship(sc.nextLine());

		System.out.print("Teléfono contacto: ");
		patient.setEmergencyContactNumber(sc.nextLong());
		sc.nextLine();

		User admin = buildAdminUser();
		createPatient.create(patient, admin);

		System.out.println("✅ Paciente creado con éxito.");
	}

	private void actualizarPaciente() throws Exception {
		Patient patient = new Patient();

		System.out.print("ID del paciente: ");
		patient.setPatientId(sc.nextLong());
		sc.nextLine();

		System.out.print("Nuevo nombre completo: ");
		patient.setFullName(sc.nextLine());

		System.out.print("Nueva dirección: ");
		patient.setAddress(sc.nextLine());

		System.out.print("Nuevo teléfono: ");
		patient.setPhone(sc.nextLong());
		sc.nextLine();

		System.out.print("Nuevo email: ");
		patient.setEmail(sc.nextLine());

		User admin = buildAdminUser();
		updatePatient.update(admin, patient);

		System.out.println("✅ Paciente actualizado con éxito.");
	}

	private void crearCita() throws Exception {
		Appointment appointment = new Appointment();

		System.out.print("ID del paciente: ");
		long patientId = sc.nextLong();
		sc.nextLine();

		Patient patient = new Patient();
		patient.setPatientId(patientId);
		appointment.setPatient(patient);

		System.out.print("Doctor asignado (ID numérico): ");
		String doctorId = sc.nextLine();
		sc.nextLine();

		User doctor = new User();
		doctor.setIdCard(doctorId);
		doctor.setRole(Role.MEDIC);
		appointment.setDoctor(doctor);

		System.out.print("Fecha y hora (YYYY-MM-DDTHH:MM): ");
		String dateTime = sc.nextLine();
		appointment.setDate(LocalDateTime.parse(dateTime));

		System.out.print("Motivo de la cita: ");
		appointment.setReason(sc.nextLine());

		appointment.setStatus(Status.PENDING);

		User admin = buildAdminUser();
		createAppointment.create(appointment, admin);

		System.out.println("✅ Cita creada con éxito.");
	}

	private void crearFactura() throws Exception {
		Invoice invoice = new Invoice();

		System.out.print("Nombre del paciente: ");
		invoice.setPatientName(sc.nextLine());

		System.out.print("Edad del paciente: ");
		invoice.setPatientAge(sc.nextInt());
		sc.nextLine();

		System.out.print("ID del paciente: ");
		invoice.setPatientIdCard(sc.nextLine());

		System.out.print("Nombre del doctor: ");
		invoice.setDoctorName(sc.nextLine());

		System.out.print("Nombre del seguro: ");
		invoice.setInsuranceName(sc.nextLine());

		System.out.print("Número de póliza: ");
		invoice.setPolicyNumber(sc.nextLine());

		invoice.setDate(LocalDate.now());

		System.out.print("Monto total: ");
		invoice.setTotalAmount(sc.nextDouble());
		sc.nextLine();

		User admin = buildAdminUser();
		createInvoice.create(invoice, admin);

		System.out.println("✅ Factura creada con éxito.");
	}

	private User buildAdminUser() {
		User admin = new User();
		admin.setRole(Role.ADMINISTRATIVESTAFF);
		return admin;
	}
}
=======
 
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
 
>>>>>>> 39c238734a14a717ea9c851412ec64e52399b237
