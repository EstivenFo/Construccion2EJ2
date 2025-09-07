package app.adapter.in.client;

 

import java.util.Scanner;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

 

import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.User;
import app.domain.model.enums.Gender;
import app.domain.model.enums.Role;

 

@Controller
public class HumanResourcesClient {

 

    private static final String MENU = """
            === Gestión de Recursos Humanos ===
            1. Crear empleado
            2. Actualizar empleado
            3. Buscar empleado por ID
            4. Salir
            """;

 

    private static final Scanner reader = new Scanner(System.in);

 

    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;

 

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
                    User user = readUser();
                    humanResourcesUseCase.createUser(user);
                    System.out.println("✅ Empleado creado correctamente.");
                    return true;
                }
                case "2" -> {
                    User user = readUser();
                    humanResourcesUseCase.updateUser(option, user);
                    System.out.println("✔ Empleado actualizado correctamente.");
                    return true;
                }

            
                case "3" -> {
                    System.out.println("👋 Cerrando sesión de Recursos Humanos...");
                    return false;
                }
                default -> {
                    System.out.println("⚠️ Opción inválida. Intente nuevamente.");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return true;
        }
    }

 

    // === Métodos auxiliares ===

 

    private User readUser() {
        User user = new User();

 

        System.out.println("Ingrese el nombre completo:");
        user.setFullName(reader.nextLine());

 

        System.out.println("Ingrese el número de cédula:");
        user.setIdCard(Long.parseLong(reader.nextLine()));

 

        System.out.println("Ingrese el correo electrónico:");
        user.setEmail(reader.nextLine());

 

        System.out.println("Ingrese el teléfono:");
        user.setPhone(Long.parseLong(reader.nextLine()));

 

        System.out.println("Ingrese la fecha de nacimiento (yyyyMMdd):");
        user.setBirthDate(Long.parseLong(reader.nextLine()));

 

        System.out.println("Ingrese la dirección:");
        user.setAddress(reader.nextLine());

 

        System.out.println("Ingrese el género (MALE, FEMALE, OTHER):");
        user.setGender(Gender.valueOf(reader.nextLine().toUpperCase()));

 

        System.out.println("Ingrese el rol (MEDIC, NURSE, ADMINISTRATIVESTAFF, HUMANRESOURCES):");
        user.setRole(Role.valueOf(reader.nextLine().toUpperCase()));

 

        return user;
    }
}



