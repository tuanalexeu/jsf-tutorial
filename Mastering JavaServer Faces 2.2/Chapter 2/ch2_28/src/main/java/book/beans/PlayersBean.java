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

    private static final Logger logger =
            Logger.getLogger(PlayersBean.class.getName());
    private String playerName;
    private String playerSurname;

    /**
     * Creates a new instance of PlayersBean
     */
    public PlayersBean() {
    }

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            logger.info("EXECUTING INIT ACTION");
            if (playerName != null) {
                playerName = playerName.toUpperCase();
            }
            if (playerSurname != null) {
                playerSurname = playerSurname.toUpperCase();
            }
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        logger.info("EXECUTING 'setPlayerName' SETTER");
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        logger.info("EXECUTING 'setPlayerSurname' SETTER");
        this.playerSurname = playerSurname;
    }

    public void postbackAction() {
        logger.info("EXECUTING POSTBACK ACTION");
    }
}
