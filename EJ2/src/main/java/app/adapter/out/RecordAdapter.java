package app.adapter.out;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import app.domain.model.Record;
import app.domain.ports.RecordPort;

@Repository  // Spring lo registrará como un bean
public class RecordAdapter implements RecordPort {

    private final Map<String, Record> database = new HashMap<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void save(Record record) throws Exception {
        String key = record.getDateTime().format(formatter);
        database.put(key, record);
        System.out.println("Historia clínica guardada en memoria con clave: " + key);
    }

    @Override
    public Record searchByDateTime(String dateTime) throws Exception {
        return database.get(dateTime);
    }

    @Override
    public List<Record> findAll() throws Exception {
        return new ArrayList<>(database.values());
    }

    @Override
    public void update(Record record) throws Exception {
        String key = record.getDateTime().format(formatter);
        if (!database.containsKey(key)) {
            throw new Exception("Historia clínica con clave " + key + " no existe");
        }
        database.put(key, record);
        System.out.println("Historia clínica actualizada con clave: " + key);
    }

    @Override
    public void delete(String dateTime) throws Exception {
        if (!database.containsKey(dateTime)) {
            throw new Exception("Historia clínica con clave " + dateTime + " no existe");
        }
        database.remove(dateTime);
        System.out.println("Historia clínica eliminada con clave: " + dateTime);
    }
}
