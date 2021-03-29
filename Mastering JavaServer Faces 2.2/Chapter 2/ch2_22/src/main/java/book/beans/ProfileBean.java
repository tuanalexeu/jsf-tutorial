package book.beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Leonard
 */
@ManagedBean //cannot be @Named
@ViewScoped
public class ProfileBean implements Serializable{

    private final static Logger LOGGER = Logger.getLogger(PlayersBean.class.getName());
    @ManagedProperty("#{playersBean}")
    private PlayersBean playersBean;
    private String greetings;

    /**
     * Creates a new instance of PlayersBean
     */
    public ProfileBean() {     
    }   

    public void setPlayersBean(PlayersBean playersBean) {
        this.playersBean = playersBean;
    }        
    
    @PostConstruct
    public void init(){
        greetings = "Hello, " + playersBean.getPlayerName() + " " +playersBean.getPlayerSurname() + " !";
    }
    
    public void greetingsAction(){
       LOGGER.info(greetings);
    }
    
}
