package book.beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class AjaxBean implements Serializable{
    
    private static final Logger logger =
            Logger.getLogger(AjaxBean.class.getName());
    private String name = "";
    private String surname = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.log (Level.INFO, "Name: {0}", name);
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        logger.log (Level.INFO, "Surname: {0}", surname);
        this.surname = surname;
    }        
    
    public void upperCaseNameAndSurname(){
        name = name.toUpperCase();
        surname = surname.toUpperCase();
        logger.log (Level.INFO, "Name: {0}", name);
        logger.log (Level.INFO, "Surname: {0}", surname);
    }        
    
      public void cancelNameAndSurname(){
        name = "";
        surname = "";
        logger.log (Level.INFO, "Name: {0}", name);
        logger.log (Level.INFO, "Surname: {0}", surname);
    }
}
