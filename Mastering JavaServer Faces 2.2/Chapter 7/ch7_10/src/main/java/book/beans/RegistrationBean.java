package book.beans;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@FlowScoped(value = "registration")
public class RegistrationBean {

    private String playerName ="";
    private String playerSurname="";

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
    
    public void credentialsUpperCase(){
        playerName = playerName.toUpperCase();
        playerSurname = playerSurname.toUpperCase();
    }

    public String getReturnValue() {
        return "/done";
    }

    public String registrationAction() {
        return "confirm";
    }
}
