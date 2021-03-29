package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Cookie;

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

    public String parametersAction() {

        Object name_cookie = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("name");
        Object surname_cookie = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("surname");
        if (name_cookie != null) {
            playerName = (((Cookie) name_cookie).getValue());
        }
        if (surname_cookie != null) {
            playerSurname = (((Cookie) surname_cookie).getValue());
        }
        
        return "result";
    }
}
