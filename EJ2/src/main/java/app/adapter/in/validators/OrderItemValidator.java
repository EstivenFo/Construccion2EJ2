package app.adapter.in.validators;
 
import org.springframework.stereotype.Component;
 
@Component
public class OrderItemValidator extends SimpleValidator {
 
    public String typeValidator(String value) throws Exception {
        // Aquí podrías validar contra un enum en lugar de solo texto
        return stringValidator("tipo de ítem", value);
    }
 
    public String descriptionValidator(String value) throws Exception {
        return stringValidator("descripción del ítem", value);
    }
 
    public String detailsValidator(String value) throws Exception {
        return stringValidator("detalles del ítem", value);
    }
}