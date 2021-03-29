package book.beans;

import java.util.Random;
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
    private boolean login  = false;

    public boolean isLogin() {
        return login;
    }       

    public void playerLogin() {
        logger.log(Level.INFO, "playerLogin method called ...");
        Random random = new Random();
        int r = random.nextInt(10);
        if (r <= 5) {
            login = false;
        } else {
            login = true;
        }
    }   
}
