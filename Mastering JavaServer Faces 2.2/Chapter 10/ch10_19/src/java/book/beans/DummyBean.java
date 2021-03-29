package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class DummyBean {

    private String dummy = null;

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }

    public Validator getDummyValidator() {
        return new DummyValidator();
    }

    public static class DummyValidator implements Validator {

        @Override
        public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            if ((String.valueOf(value).length() < 3)) {
                throw new ValidatorException(new FacesMessage("VALIDATOR ERROR ..."));
            }
        }
    }
}
