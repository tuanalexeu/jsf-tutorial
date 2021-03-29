package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
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

     private final static Logger logger = Logger.getLogger(PlayersBean.class.getName());
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
    public void init(){
        logger.log(Level.INFO, "Name: {0} Surname: {1}", new Object[]{playerName, playerSurname});
    }
    
    public String parametersAction() {        
        return "result";
    }
}
