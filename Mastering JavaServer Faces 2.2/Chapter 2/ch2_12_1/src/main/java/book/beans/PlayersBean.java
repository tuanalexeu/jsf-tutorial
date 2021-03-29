package book.beans;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private final static Logger logger = Logger.getLogger(PlayersBean.class.getName());
    private String playerName;
    private String playerSurname;

    /**
     * Creates a new instance of PlayersBean
     */
    public PlayersBean() {
    }

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

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            logger.info("The init() method was called !!!");
            if (playerName != null) {
                playerName = playerName.toUpperCase();
            }
            if (playerSurname != null) {
                playerSurname = playerSurname.toUpperCase();
            }
        }
    }

    public void userAction() {
        logger.info("The userAction() method was called !!!");
    }
}
