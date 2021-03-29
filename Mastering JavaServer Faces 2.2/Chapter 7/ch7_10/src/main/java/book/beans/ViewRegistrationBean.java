package book.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
public class ViewRegistrationBean implements Serializable {

    @Inject
    RegistrationBean registrationBean;
    private String playerNameView = "nothing";
    private String playerSurnameView = "nothing";
    private static final Map<Integer, String> myMap = new HashMap<>();

    static {
        myMap.put(1, "Nadal Rafael");
        myMap.put(2, "Federer Roger");
        myMap.put(3, "Ferer David");
        myMap.put(4, "Murray Andy");
        myMap.put(5, "Djokovic Novak");
        myMap.put(6, "Berdych Tomas");
        myMap.put(7, "Haas Tommy");
        myMap.put(8, "Isner John");
        myMap.put(9, "Fognini Fabio");
        myMap.put(10, "Robredo Tommy");
    }

    @PostConstruct
    public void init() {
        Random r = new Random();
        int key = 1 + r.nextInt(9);
        String player = myMap.get(key);
        String[] fullname = player.split(" ");
        
        playerNameView = fullname[0];
        playerSurnameView = fullname[1];
        playerNameView = playerNameView.toUpperCase();
        playerSurnameView = playerSurnameView.toUpperCase();
    }

    public String getPlayerNameView() {
        return playerNameView;
    }

    public void setPlayerNameView(String playerNameView) {
        this.playerNameView = playerNameView;
    }

    public String getPlayerSurnameView() {
        return playerSurnameView;
    }

    public void setPlayerSurnameView(String playerSurnameView) {
        this.playerSurnameView = playerSurnameView;
    }

    public void generateCredentials() {
        registrationBean.setPlayerName(playerNameView);
        registrationBean.setPlayerSurname(playerSurnameView);
    }
}
