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
public class PlayersBeanGet implements Serializable{  

    private final static Logger logger = Logger.getLogger(PlayersBeanGet.class.getName());
    
    public void playerGetAction() {    
        String name = String.valueOf(ApplicationMapHelper.getValueFromApplicationMap("PlayersBeanSet.name"));
        String surname = String.valueOf(ApplicationMapHelper.getValueFromApplicationMap("PlayersBeanSet.surname"));
        
       logger.log(Level.INFO, "Name: {0} Surname: {1}", new Object[]{name, surname});
    }
}
