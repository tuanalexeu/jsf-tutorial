package book.ejbs;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Leonard
 */
@Stateless
@LocalBean
public class LoginEJBBean {

    private List players = new ArrayList<>();

    public LoginEJBBean() {
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