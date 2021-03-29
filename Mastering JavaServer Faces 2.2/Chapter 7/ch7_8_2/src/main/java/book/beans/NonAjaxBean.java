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
public class NonAjaxBean implements Serializable{
    
    private static final Logger logger =
            Logger.getLogger(NonAjaxBean.class.getName());
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.log (Level.INFO, "Name: {0}", name);
        this.name = name;
    }
    
    public void upperCaseName(){
        name = name.toUpperCase();
        logger.log (Level.INFO, "Name: {0}", name);
    }           
}
