package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Person;
import app.domain.model.enums.Role;
import app.domain.ports.UserPort;
@Service
public class CreateUser {
	@Autowired
    private  UserPort userPort;

    // Crear empleado con validación de rol
    public void createUser( Person user) throws Exception {
        Role role = user.getRole();
        if (user.getRole() != Role.HUMANRESOURCES) {
            throw new SecurityException("Solo personal de Recursos Humanos puede crear un empleado.");
        }

        // Validación de roles permitidos
        if (!(role == Role.MEDIC || role == Role.NURSE
           || role == Role.ADMINISTRATIVESTAFF || role == Role.HUMANRESOURCES)) {
            throw new IllegalArgumentException("El rol asignado no corresponde a un empleado válido.");
        }

        // Guardar empleado si es válido
        userPort.save(user);
    }


    // Buscar empleado por ID
    public Person searchById(long idCard) throws Exception {
        Person user = userPort.searchById(idCard);
        if (user == null) {
            throw new Exception("Empleado con ID " + idCard + " no encontrado.");
        }
        return user;
    }
}
