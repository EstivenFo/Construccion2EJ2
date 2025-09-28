package app.domain.ports;

import java.util.List;
import app.domain.model.Appointment;

public interface AppointmentPort {

    // Guardar nueva cita
    void save(Appointment appointment) throws Exception;

    // Buscar cita por el ID del paciente
    Appointment searchByPatientId(Long patientId) throws Exception;

    // Buscar cita por el ID del doctor
    Appointment searchByDoctorId(Long doctorId) throws Exception;

    // Actualizar una cita existente
    void update(Appointment appointment) throws Exception;

    // Listar todas las citas
    List<Appointment> findAll() throws Exception;
}
