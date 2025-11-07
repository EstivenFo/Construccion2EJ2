package app.domain.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Order;
import app.domain.model.OrderItem;
import app.domain.ports.OrderPort;
import app.domain.model.enums.Role;
import app.domain.model.Person;

@Service
public class CreateOrder {
	@Autowired
	private OrderPort orderPort;

	public void create(long patientId, long doctorId, boolean requiresHospitalization, Person user, Order order)
			throws Exception {

		if (patientId == 0){
			throw new IllegalArgumentException("El paciente es obligatorio");
		}
		  
		if (doctorId == 0) {
			throw new IllegalArgumentException("El doctor es obligatorio");

		}

		if (user.getRole() != Role.MEDIC) {
			throw new SecurityException("Solo un médico puede crear una orden médica");
		}
		order.setPatientId(patientId);
		order.setDoctorId(doctorId);
		order.setCreationDate(LocalDate.now());

		// Hospitalización como procedimiento (si aplica)
		if (requiresHospitalization) {
			order.addItem(new OrderItem());
		}

		// Procedimientos de enfermería
		order.addItem(new OrderItem());
		order.addItem(new OrderItem());

		// Medicamentos recetados
		order.addItem(new OrderItem());
		order.addItem(new OrderItem());
		order.addItem(new OrderItem());

		// Ayuda diagnóstica
		order.addItem(new OrderItem());

		// Guardar en el repositorio
		orderPort.save(order);
	}

}
