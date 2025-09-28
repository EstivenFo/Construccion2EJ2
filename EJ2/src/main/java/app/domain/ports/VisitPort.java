package app.domain.ports;

import java.util.List;

import app.domain.model.Visit;

public interface VisitPort {
	public void save(Visit visit) throws Exception;
    Visit findById(long patientId) throws Exception;
    List<Visit> findAllByPatient(long patientId) throws Exception;
	
}