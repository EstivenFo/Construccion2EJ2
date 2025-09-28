package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Order;
import app.domain.model.Record;
import app.domain.services.SearchMedicalRecordByPatient;
import app.domain.services.UpdateRecord;
import app.domain.services.CreateOrder;
import app.domain.model.Patient;
import app.domain.services.CreateRecord;

@Service
public class MedicUseCase {
	@Autowired
	private SearchMedicalRecordByPatient searchMedicalRecordByPatient;
	public void searchMedicalRecordByPatient (Patient patient) throws Exception{
		searchMedicalRecordByPatient.search(patient, null);
	}
	@Autowired
   private CreateRecord createRecord;
   public void createRecord (Record record) throws Exception{
	   createRecord.create(null, record,null);
   }
   @Autowired
   private UpdateRecord updateRecord;
   public void updateRecord (Record record)throws Exception{
	   updateRecord.updateRecord(null, record, null);
   }
   @Autowired
   private CreateOrder crearteOrder;
   public void crearteOrder (Order order)throws Exception{
	   crearteOrder.create(0, 0, false, null, order);
   }
   
} 













