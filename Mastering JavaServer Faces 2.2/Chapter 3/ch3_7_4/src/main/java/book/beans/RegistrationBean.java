package book.beans;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@FlowScoped(value = "registration")
public class RegistrationBean implements Serializable {

    private static final Logger logger = Logger.getLogger(RegistrationBean.class.getName());
    private String playerName;
    private String playerSurname;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }

    public String getReturnValue() {
        return "/done";
    }

    @PostConstruct
    public void init() {
        logger.log(Level.INFO, "Post Construct reporting: player={0} surname={1}", new Object[]{playerName, playerSurname});
    }

    public String registrationAction() {

        //simulate some registration conditions
        Random r = new Random();
        int nr = r.nextInt(10);

        if (nr < 5) {
            playerName = "";
            playerSurname = "";
            FacesContext.getCurrentInstance().addMessage("password", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration failed!", ""));
            return "registration";
        } else {
            return "confirm";
        }
    }
}
