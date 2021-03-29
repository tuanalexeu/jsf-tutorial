package book.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Leonard
 */
@ManagedBean //cannot be @Named
@RequestScoped
public class PlayersBean {

    @ManagedProperty(value = "#{param.playerNameParam}")
    private String playerName;
    @ManagedProperty(value = "#{param.playerSurnameParam}")
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

    @PostConstruct
    public void parametersAction() {
        playerName = playerName.toUpperCase();
        playerSurname = playerSurname.toUpperCase();
    }
}
