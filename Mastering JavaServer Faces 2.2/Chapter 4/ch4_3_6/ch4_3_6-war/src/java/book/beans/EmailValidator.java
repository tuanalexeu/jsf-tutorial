package book.beans;

import book.ejbs.LoginEJBBean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@FacesValidator
public class EmailValidator implements Validator {

    private LoginEJBBean loginEJBBean;
    private static final String IP_REGEX = ".+@.+\\.[a-z]+";

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        try {
            loginEJBBean = (LoginEJBBean) new InitialContext().lookup("java:global/ch4_3_6/ch4_3_6-ejb/LoginEJBBean");
        } catch (NamingException e) {
            throw new ExceptionInInitializerError(e);
        }
        
        String emailAddress = (String) value;
        Pattern mask = Pattern.compile(IP_REGEX);
        Matcher matcher = mask.matcher(emailAddress);
        FacesMessage message = new FacesMessage();

        if (!matcher.matches()) {            
            message.setDetail("E-mail not valid");
            message.setSummary("E-mail not valid");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        } else {
            if (!loginEJBBean.getPlayers().contains(value)) {                
                message.setDetail("E-mail is valid but you don't have an account!");
                message.setSummary("E-mail is valid but you don't have an account!");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }
    }
}
