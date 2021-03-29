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

    private PlayerName playerName;

    public PlayerName getPlayerName() {
        return playerName;
    }

    public void setPlayerName(PlayerName playerName) {
        this.playerName = playerName;
    }
    
    public void playerAction(){
        logger.log(Level.INFO, "Player name in lowercase: {0}", playerName.getLowercase());
        logger.log(Level.INFO, "Player name in uppercase: {0}", playerName.getUppercase());
    }
}
