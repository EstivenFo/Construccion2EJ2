package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.InvoiceValidator;
import app.domain.model.Invoice;
import app.domain.model.Order;
import app.domain.model.Patient;
import app.domain.model.User;

@Component
public class InvoiceBuilder {

	@Autowired
	private InvoiceValidator invoiceValidator;

	public Invoice build(String invoiceId, String patientId, String patientName, String patientAge,
			String patientIdCard, String doctorId, String doctorName, String insuranceName, String policyNumber,
			String date, String totalAmount) throws Exception {

		Invoice invoice = new Invoice();
		Patient patient = new Patient();
		User doctor = new User();
		Order order = new Order();

		patient.setPatientId(invoiceValidator.patientIdCardValidator(patientId));
		patient.setFullName(invoiceValidator.patientNameValidator(patientName));
		patient.setBirthDate(invoiceValidator.patientAgeValidator(patientAge));
		invoice.setPatientName(patient.getFullName());
		invoice.setPatientAge(patient.getBirthDate());
		invoice.setPatientIdCard( patient.getPatientId());
		doctor.setIdCard(invoiceValidator.patientIdCardValidator(doctorId));
		doctor.setFullName(invoiceValidator.doctorNameValidator(doctorName));
		invoice.setDoctorName(doctor.getFullName());
		invoice.setInsuranceName(invoiceValidator.insuranceNameValidator(insuranceName));
		invoice.setPolicyNumber(invoiceValidator.policyNumberValidator(policyNumber));
		invoice.setInvoiceId( invoiceValidator.invoiceIdValidator(invoiceId));
		invoice.setDate(invoiceValidator.dateValidator(date));
		invoice.setTotalAmount(invoiceValidator.totalAmountValidator(totalAmount));
		order.setOrderNumber( invoiceValidator.orderNumberIdValidator(patientId));
		invoice.setOrder(order);
		return invoice;
	}
}