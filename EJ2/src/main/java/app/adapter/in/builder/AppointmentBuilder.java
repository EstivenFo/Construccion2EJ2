package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.AppointmentValidator;
import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Status;

import java.time.LocalDateTime;

@Component
public class AppointmentBuilder {

	@Autowired
	private AppointmentValidator appointmentValidator;

	public Appointment build(String patientId, String doctorId, String date, String reason, String status)
			throws Exception {

		Appointment appointment = new Appointment();
		Patient patient = new Patient();
		User doctor = new User();

		// Validaciones y asignaciones
		patient.setPatientId(appointmentValidator.patientIdValidator(patientId));
		doctor.setIdCard(appointmentValidator.doctorIdValidator(doctorId));
		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		// Conversión LocalDate → LocalDateTime
		appointment.setDate(LocalDateTime.from(appointmentValidator.dateValidator(date).atStartOfDay()));
		appointment.setReason(appointmentValidator.reasonValidator(reason));
		appointment.setStatus(Status.valueOf(appointmentValidator.statusValidator(status).toUpperCase()));

		return appointment;
	}
}
