package book.beans;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {
    
    private String[] players = new String[]{"Rafael Nadal", "Roger Federer", "David Ferer",  "Tommy Haas", "Andy Murray"};
    private String player;

    public String getPlayer() {
        return player;
    }
    
    @PostConstruct
    public void generatePlayer(){
        player = players[new Random().nextInt(4)];
    }
}
