package book.validator;

import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Leonard
 */
@FacesValidator("playerValidator")
public class PlayerValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        //simulate some validation here
        Random r = new Random();
        int valid = r.nextInt(20);
        if (valid < 10) {
            FacesMessage msg = new FacesMessage(" Player name/surname validation failed.", "Details about failure!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }
    }
}
