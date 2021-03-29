package book.beans;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@Dependent
public class PlayersBean {

    private static final Logger logger = Logger.getLogger(PlayersBean.class.getName());
    final String[] players_list = {"Nadal, Rafael (ESP)","Djokovic, Novak (SRB)", "Ferrer, David (ESP)", "Murray, Andy (GBR)", "Del Potro, Juan Martin (ARG)"};
    private ArrayList players = new ArrayList();
    private String player;

    public PlayersBean() {
    }

    public ArrayList getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList players) {
        this.players = players;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
    
    @PostConstruct
    public void init() {
        logger.log(Level.INFO, "Post Construct reporting: player={0}", player);
    }
      
    public void newPlayer() {        
        int nr = new Random().nextInt(4);
        player = players_list[nr];        
        players.add(player);         
        logger.log(Level.INFO, "Generated player: {0}", player);
    }       
}
