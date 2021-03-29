package book.beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@SessionScoped
public class AjaxBean implements Serializable{
    
    private static final Logger logger =
            Logger.getLogger(AjaxBean.class.getName());
    private String name = "Rafael";
    private String surname = "Nadal";

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
}
