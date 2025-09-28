package app.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;
import app.infrastructure.persistence.entities.AppointmentEntity;
import app.infrastructure.persistence.mapper.AppointmentMapper;
import app.infrastructure.persistence.repository.AppointmentRepository;

@Service
public class AppointmentAdapter implements AppointmentPort {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public void save(Appointment appointment) throws Exception {
		AppointmentEntity entity = AppointmentMapper.toEntity(appointment);
		appointmentRepository.save(entity);
	}

	@Override
	public Appointment searchByPatientId(Long patientId) throws Exception {
		AppointmentEntity entity = appointmentRepository.findByPatient_Id(patientId).stream().findFirst()
				.orElseThrow(() -> new Exception("No se encontró ninguna cita para el paciente con ID: " + patientId));
		return AppointmentMapper.toDomain(entity);
	}

	@Override
	public Appointment searchByDoctorId(Long doctorId) throws Exception {
		AppointmentEntity entity = appointmentRepository.findByDoctor_Id(doctorId).stream().findFirst()
				.orElseThrow(() -> new Exception("No se encontró ninguna cita para el doctor con ID: " + doctorId));
		return AppointmentMapper.toDomain(entity);
	}

	@Override
	public void update(Appointment appointment) throws Exception {
		AppointmentEntity entity = AppointmentMapper.toEntity(appointment);
		appointmentRepository.save(entity); // save() en JPA también actualiza si el ID ya existe
	}

	@Override
	public List<Appointment> findAll() throws Exception {
		List<AppointmentEntity> entities = appointmentRepository.findAll();
		return entities.stream().map(AppointmentMapper::toDomain).collect(Collectors.toList());
	}

}
