package book.beans;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private String playerName="";
    private String playerSurname="";
    private FacesContext facesContext;

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
    public void postConstruct() {      
        facesContext = FacesContext.getCurrentInstance();
    }

    
    public String validateData() {
        
        Random r = new Random();
        int valid = r.nextInt(20);
        if (valid < 10) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Player name/surname validation failed.",""));                                  
        }
        
        return "index";
    }
}
