package app.domain.services;

import app.domain.model.Order;
import app.domain.model.enums.Role;
import app.domain.model.Patient;
import app.domain.model.Person;
import app.domain.ports.OrderPort;
import app.domain.ports.PatientPort;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SearchOrdenByPatient {

	private PatientPort patientPort;
	private OrderPort orderPort;

	public List<Order> search(Patient patient, Person user) throws Exception {
		patient = patientPort.search(patient);
		if (patient == null) {
			throw new Exception("debe consultar ordenes de un paciente registrado");
		}
		if (user.getRole() != Role.NURSE) {
		    throw new Exception("Solo una enfermera puede consultar las órdenes de pacientes.");
		}
		return orderPort.search(patient);
	}
}