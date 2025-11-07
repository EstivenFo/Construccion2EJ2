package app.adapter.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import app.domain.model.Person;
import app.domain.ports.UserPort;

@Repository  // Spring lo registrará como un bean
public class UserAdapter implements UserPort {

    private final Map<Long, Person> database = new HashMap<>();

    @Override
    public void save(Person user) throws Exception {
        database.put(user.getIdCard(), user);
        System.out.println("Usuario guardado en memoria con cédula: " + user.getIdCard());
    }

    @Override
    public Person searchById(long idCard) throws Exception {
        return database.get(idCard);
    }

    @Override
    public List<Person> findAll() throws Exception {
        return new ArrayList<>(database.values());
    }

    @Override
    public void update(Person user) throws Exception {
        if (!database.containsKey(user.getIdCard())) {
            throw new Exception("Usuario con cédula " + user.getIdCard() + " no existe");
        }
        database.put(user.getIdCard(), user);
        System.out.println("Usuario actualizado con cédula: " + user.getIdCard());
    }

    @Override
    public void delete(long idCard) throws Exception {
        if (!database.containsKey(idCard)) {
            throw new Exception("Usuario con cédula " + idCard + " no existe");
        }
        database.remove(idCard);
        System.out.println("Usuario eliminado con cédula: " + idCard);
    }
}

