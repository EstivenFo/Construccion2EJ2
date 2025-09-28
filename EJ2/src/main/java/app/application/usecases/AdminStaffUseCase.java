package app.application.usecases;

import app.domain.model.Patient;
import app.domain.services.UpdatePatient;
import app.domain.services.CreatePatient;
import app.domain.services.CreateInvoice;
import app.domain.model.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Appointment;
import app.domain.services.CreateAppointment;
@Service
public class AdminStaffUseCase {
@Autowired
	private CreatePatient createPatient;

	public void createPatient(Patient patient) throws Exception {
		createPatient.create(patient, null);

	}
	@Autowired
	private UpdatePatient updatePatient;

	public void updatePatient(Patient patient) throws Exception {
		updatePatient.update(null, patient);
	}
	@Autowired
	private CreateAppointment createAppointment;

	public void createAppointmet(Appointment appointment) throws Exception {
		createAppointment.create(appointment, null);
	}
	@Autowired
	private CreateInvoice createInvoice;

	public void createInvoice(Invoice invoice) throws Exception {
		createInvoice.create(invoice, null);
	}

}
