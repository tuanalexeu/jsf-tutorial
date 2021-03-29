package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayerBean {

    private static final Logger logger = Logger.getLogger(PlayerBean.class.getName());

    public void playerListener(ActionEvent e) {
        logger.log(Level.INFO, "playerListener method called ...");
    }

    public String playerDone() {
        logger.log(Level.INFO, "playerDone method called ...");
        return "done";
    }
}
