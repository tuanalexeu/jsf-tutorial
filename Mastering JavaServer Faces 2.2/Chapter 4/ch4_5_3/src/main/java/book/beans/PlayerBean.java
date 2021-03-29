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
    private boolean login;

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isLogin() {
        return login;
    }

    public String playerLogin() {
        logger.log(Level.INFO, "playerLogin method called ...");
        Random random = new Random();
        int r = random.nextInt(10);
        login = r > 5;
        
        return "done";
    }

    public String navigateHelper() {
        if (!login) {
            return "failed.xhtml";
        } else {
            return "success.xhtml";
        }
    }
}
