package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
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

    public void processAction() {

        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent uinc = view.findComponent("playerFormId:playerNameId");
        Object prev = ((UIInput) uinc).getAttributes().put("value", "RAFAEL");
        logger.log(Level.INFO, "Name: {0}", String.valueOf(prev));

        UIComponent uisc = view.findComponent("playerFormId:playerSurnameId");
        Object current = ((UIInput) uisc).getAttributes().get("value");
        logger.log(Level.INFO, "Surname: {0}", String.valueOf(current));
    }
}
