package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private static final Logger logger = Logger.getLogger(PlayersBean.class.getName());
    
    @NotNull(message = "null/empty values not allowed in player name")
     @Size(min = 3,message = "Give at least 3 characters for player name")
    private String playerName;
    @NotNull(message = "null/empty values not allowed in player surname")
    @Size(min = 3,message = "Give at least 3 characters for player surname")
    private String playerSurname;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        logger.log(Level.INFO, "The player name ({0}) was successfully validated!", playerName);
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        logger.log(Level.INFO, "The player surname ({0}) was successfully validated!", playerSurname);
        this.playerSurname = playerSurname;
    }

    public void playerAction() {
        logger.log(Level.INFO, "Player name: {0}", playerName);
        logger.log(Level.INFO, "Player name: {0}", playerSurname);
    }
}
