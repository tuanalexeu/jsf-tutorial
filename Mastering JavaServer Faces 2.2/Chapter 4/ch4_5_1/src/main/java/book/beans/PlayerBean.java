package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayerBean {

    private static final Logger logger = Logger.getLogger(PlayerBean.class.getName());  

    public String playerDone() {
        logger.log(Level.INFO, "playerDone method called ...");
        return "done";
    }   
}
