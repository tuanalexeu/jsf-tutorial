package book.beans;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ApplicationScoped
public class LoginBean {
    
    private List players = new ArrayList<>();
    
    public LoginBean(){
        players.add("rafael@yahoo.com");
        players.add("federer@yahoo.com");
        players.add("novak@yahoo.com");
        players.add("ferer@yahoo.com");
        players.add("tonga@yahoo.com");
    }

    public List getPlayers() {
        return players;
    }

    public void setPlayers(List players) {
        this.players = players;
    }            
}
