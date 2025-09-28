package app.domain.services;

import java.util.List;
import org.springframework.stereotype.Service;

import app.domain.model.Appointment;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.AppointmentPort;

@Service
public class CreateAppointment {

    private final AppointmentPort appointmentPort;

    // Inyección por constructor (mejor práctica)
    public CreateAppointment(AppointmentPort appointmentPort) {
        this.appointmentPort = appointmentPort;
    }

    // Crear nueva cita
    public void create(Appointment appointment, User ADMINISTRATIVESTAFF) throws Exception {
        if (appointment == null) {
            throw new IllegalArgumentException("La cita no puede ser nula.");
        }
        appointmentPort.save(appointment);
    }

    // Buscar cita por paciente
    public Appointment getByPatient(Long patientId) throws Exception {
        if (patientId == null || patientId <= 0) {
            throw new IllegalArgumentException("El ID del paciente no es válido.");
        }
        return appointmentPort.searchByPatientId(patientId);
    }

    // Buscar cita por doctor
    public Appointment getByDoctor(Long doctorId) throws Exception {
        if (doctorId == null || doctorId <= 0) {
            throw new IllegalArgumentException("El ID del doctor no es válido.");
        }
        return appointmentPort.searchByDoctorId(doctorId);
    }

    // Actualizar cita
    public void update(Appointment appointment, User ADMINISTRATIVESTAFF) throws Exception {
        if (appointment == null) {
            throw new IllegalArgumentException("La cita no es válida para actualizar.");
        }
        if (ADMINISTRATIVESTAFF == null || !ADMINISTRATIVESTAFF.getRole().equals(Role.ADMINISTRATIVESTAFF)) {
            throw new IllegalArgumentException("Solo un administrador puede crear citas.");
        }
        appointmentPort.update(appointment);
    }

    // Listar todas las citas
    public List<Appointment> getAll() throws Exception {
        return appointmentPort.findAll();
    }
}
