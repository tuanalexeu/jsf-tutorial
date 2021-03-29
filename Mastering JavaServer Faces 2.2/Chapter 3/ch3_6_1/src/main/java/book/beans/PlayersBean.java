package book.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class PlayersBean implements Serializable{

    final String[] players_list = {"Nadal, Rafael (ESP)","Djokovic, Novak (SRB)", "Ferrer, David (ESP)", "Murray, Andy (GBR)", "Del Potro, Juan Martin (ARG)"};
    private ArrayList players = new ArrayList();
    private String player;

    /** Creates a new instance of PlayersBean */
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
    
    public void newPlayer() {
        int nr = new Random().nextInt(4);
        player = players_list[nr];
        players.add(player);
    }       
}
