package app.domain.ports;

import java.util.List;

import app.domain.model.Record;

public interface RecordPort {
	 void save(Record record) throws Exception;
	    Record searchByDateTime(String dateTime) throws Exception;
	    List<Record> findAll() throws Exception;
	    void update(Record record) throws Exception;
	    void delete(String dateTime) throws Exception;
	}

