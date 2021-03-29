package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {
   
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

    public String init() {       
        if (playerName != null) {
            playerName = playerName.toUpperCase();
        }
        if (playerSurname != null) {
            playerSurname = playerSurname.toUpperCase();
        }

        return "start"; //you can use "start?includeViewParams=true" to pass the view params further
    }
}
