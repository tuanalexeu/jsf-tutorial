package book.beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class ProfileBean implements Serializable{

    private final static Logger logger = Logger.getLogger(PlayersBean.class.getName());
    @Inject
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
       logger.info(greetings);
    }
    
}
