package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.VisitValidator;
import app.domain.model.Visit;
import app.domain.model.User;
import app.domain.model.Patient;

@Component
public class VisitBuilder {

	@Autowired
	private VisitValidator visitValidator;

	public Visit builder(Patient patient, User createdBy, // doctor o enfermera
			String bloodPressure, String temperature, String pulse, String oxygenLevel, String observations)
			throws Exception {

		Visit visit = new Visit();

		visit.setBloodPressure(visitValidator.bloodPressureValidator(bloodPressure));
		visit.setTemperature(visitValidator.temperatureValidator(temperature));
		visit.setPulse(visitValidator.pulseValidator(pulse));
		visit.setOxygenLevel(visitValidator.oxygenLevelValidator(oxygenLevel));
		visit.setObservations(visitValidator.observationsValidator(observations));

		return visit;
	}
}
