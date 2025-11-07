package app.domain.ports;


import app.domain.model.Person;
import java.util.List;

public interface UserPort {

    // Guardar un empleado
    public void save(Person user) throws Exception;

    // Buscar empleado por número de identificación
    public Person searchById(long idCard) throws Exception;

    // Listar todos los empleados
    public List<Person> findAll() throws Exception;

    // Actualizar empleado
    public void update(Person user) throws Exception;

    // Eliminar empleado por ID
    public void delete(long idCard) throws Exception;

    
}
