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
    private String name = "";
    private int request = 0;

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }        
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.log (Level.INFO, "Name: {0}", name);
        this.name = name;
    }
    
    public void upperCaseName(){
        name = name.toUpperCase();
        request++;
        logger.log (Level.INFO, "Name: {0}", name);
    }                 
}
