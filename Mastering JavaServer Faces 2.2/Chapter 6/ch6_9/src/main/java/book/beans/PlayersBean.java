package book.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class PlayersBean implements Serializable {

    HashMap<Players, HashSet<Trophies>> dataHashMap = new HashMap<>();
    final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public PlayersBean() {
        try {
            HashSet<Trophies> trophies_1 = new HashSet<>();
            Trophies trophy_1_1 = new Trophies(1, "US Open");
            Trophies trophy_1_2 = new Trophies(1, "ATP World Tour Masters 1000 Cincinnati");
            Trophies trophy_1_3 = new Trophies(1, "ATP World Tour Masters 1000 Canada");
            Trophies trophy_1_4 = new Trophies(1, "Roland Garros");
            Trophies trophy_1_5 = new Trophies(1, "ATP World Tour Masters 1000 Rome");
            Trophies trophy_1_6 = new Trophies(1, "ATP World Tour Masters 1000 Madrid");
            Trophies trophy_1_7 = new Trophies(1, "Barcelona");
            Trophies trophy_1_8 = new Trophies(1, "ATP World Tour Masters 1000 Indian Wells");
            Trophies trophy_1_9 = new Trophies(1, "Acapulco");
            Trophies trophy_1_10 = new Trophies(1, "Sao Paulo");
            trophies_1.add(trophy_1_1);
            trophies_1.add(trophy_1_2);
            trophies_1.add(trophy_1_3);
            trophies_1.add(trophy_1_4);
            trophies_1.add(trophy_1_5);
            trophies_1.add(trophy_1_6);
            trophies_1.add(trophy_1_7);
            trophies_1.add(trophy_1_8);
            trophies_1.add(trophy_1_9);
            trophies_1.add(trophy_1_10);
            dataHashMap.put(new Players(1, "RAFAEL NADAL", (byte) 27, "Manacor, Mallorca, Spain", "Manacor, Mallorca, Spain", (short) 185, (byte) 85, "Toni Nadal", sdf.parse("03.06.1986")), trophies_1);

            HashSet<Trophies> trophies_2 = new HashSet<>();
            Trophies trophy_2_1 = new Trophies(2, "Barclays ATP World Tour Finals");
            Trophies trophy_2_2 = new Trophies(2, "ATP World Tour Masters 1000 Paris");
            Trophies trophy_2_3 = new Trophies(2, "ATP World Tour Masters 1000 Shanghai");
            Trophies trophy_2_4 = new Trophies(2, "ATP World Tour Masters 1000 Monte Carlo");
            Trophies trophy_2_5 = new Trophies(2, "Dubai");
            Trophies trophy_2_6 = new Trophies(2, "Beijing");
            Trophies trophy_2_7 = new Trophies(2, "Australian Open");            
            trophies_2.add(trophy_2_1);
            trophies_2.add(trophy_2_2);
            trophies_2.add(trophy_2_3);
            trophies_2.add(trophy_2_4);
            trophies_2.add(trophy_2_5);
            trophies_2.add(trophy_2_6);
            trophies_2.add(trophy_2_7);
            dataHashMap.put(new Players(2, "NOVAK DJOKOVIC", (byte) 26, "Belgrade, Serbia", "Monte Carlo, Monaco", (short) 188, (byte) 80, "Boris Becker, Marian Vajda", sdf.parse("22.05.1987")), trophies_2);

            HashSet<Trophies> trophies_3 = new HashSet<>();
            Trophies trophy_3_1 = new Trophies(2, "Buenos Aires");
            Trophies trophy_3_2 = new Trophies(2, "Auckland");
            trophies_3.add(trophy_3_1);
            trophies_3.add(trophy_3_2);
            dataHashMap.put(new Players(3, "DAVID FERRER", (byte) 31, "Javea, Spain", "Valencia, Spain", (short) 175, (byte) 73, "Jose Francisco Altur", sdf.parse("02.04.1982")), trophies_3);

        } catch (ParseException ex) {
            Logger.getLogger(PlayersBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashMap<Players, HashSet<Trophies>> getDataHashMap() {
        return dataHashMap;
    }

    public void setDataHashMap(HashMap<Players, HashSet<Trophies>> dataHashMap) {
        this.dataHashMap = dataHashMap;
    }
}
