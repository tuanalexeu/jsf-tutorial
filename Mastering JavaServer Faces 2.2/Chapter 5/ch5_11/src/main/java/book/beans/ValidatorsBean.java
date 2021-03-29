package book.beans;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ApplicationScoped
public class ValidatorsBean {
    
    private Map<String,String> validators = new HashMap<>();
    
    public ValidatorsBean(){
        validators.put("emailValidator", "book.beans.EmailValidator");
        //... add here more validators 
    }

    public Map<String, String> getValidators() {
        return validators;
    }

    public void setValidators(Map<String, String> validators) {
        this.validators = validators;
    }           
}
