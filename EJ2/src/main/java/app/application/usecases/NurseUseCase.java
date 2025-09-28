package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.model.Visit;
import app.domain.services.CreateVisit;
import app.domain.services.SearchPatient;
import app.domain.services.SearchOrdenByPatient;

@Service
public class NurseUseCase {
	@Autowired
	private CreateVisit createVisit;

	public void createVisit(Visit visit) throws Exception {
		createVisit.create(null, visit);
	}

	@Autowired
	private SearchPatient searchPatient;

	public void searchPatient(Patient patient) throws Exception {
		searchPatient.search(patient, null);
	}

	@Autowired
	private SearchOrdenByPatient searchOrdenByPatient;

	public void searchOrdenByPatient(Patient patient) throws Exception {
		searchOrdenByPatient.search(patient, null);
	}

}
