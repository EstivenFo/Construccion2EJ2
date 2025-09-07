package app.adapter.in.client;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.application.usecases.MedicUseCase;
import app.domain.model.Order;
import app.domain.model.Record;

@Controller
public class MedicClient {

    private static final String MENU = 
              "Ingrese una de las opciones \n"
            + "1. Crear registro médico \n"
            + "2. Crear orden médica \n"
            + "3. Salir";

    private static Scanner reader = new Scanner(System.in);

    @Autowired
    private MedicUseCase medicUseCase;

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
            case "1": {
                Record record = readMedicalRecordData();
                medicUseCase.createRecord(record);
                return true;
            }
            case "2": {
                Order order = readOrderData();
                medicUseCase.createOrder(order);
                return true;
            }
            case "3": {
                System.out.println("Hasta luego \nCerrando sesión...");
                return false;
            }
            default: {
                System.out.println("Ingrese una opción válida");
                return true;
            }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
    }

    // Construir un registro médico
    private Record readMedicalRecordData() {
        Record record = new Record();
        System.out.println("Ingrese el ID del doctor:");
        record.setDoctorId(reader.nextLine());
        record.setDateTime(LocalDateTime.now());
        System.out.println("Ingrese el diagnóstico:");
        record.setDiagnosis(reader.nextLine());
        System.out.println("Ingrese el tratamiento:");
        record.setTreatment(reader.nextLine());
        System.out.println("Ingrese notas adicionales:");
        record.setNotes(reader.nextLine());
        // Ejemplo simple de tests y recetas
        record.setTests(Arrays.asList("Hemograma", "Rayos X"));
        record.setPrescriptions(Arrays.asList("Ibuprofeno 400mg", "Amoxicilina 500mg"));
        return record;
    }

    // Construir una orden médica
    private Order readOrderData() {
        Order order = new Order();
        System.out.println("Ingrese el ID del paciente:");
        order.setPatientId(reader.nextLine());
        System.out.println("Ingrese el ID del doctor:");
        order.setDoctorId(reader.nextLine());
        order.setCreationDate(java.time.LocalDate.now());
        return order;
    }
}

