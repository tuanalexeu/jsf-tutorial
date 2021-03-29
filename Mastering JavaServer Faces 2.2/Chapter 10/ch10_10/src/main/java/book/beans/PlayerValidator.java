package book.beans;

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
@FacesValidator(value="playerValidator")
public class PlayerValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String s_value = String.valueOf(value);
        if(s_value.length() < 3){        
        throw new ValidatorException(new FacesMessage("The player name/surname must be at least 3 characters long ..."));
        }       
    }
}
