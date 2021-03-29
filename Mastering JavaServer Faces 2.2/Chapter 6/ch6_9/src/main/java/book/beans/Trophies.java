package book.beans;

/**
 *
 * @author Leonard
 */
public class Trophies {
    
    private int ranking;
    private String trophy;

    public Trophies(int ranking, String trophy) {
        this.ranking = ranking;
        this.trophy = trophy;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getTrophy() {
        return trophy;
    }

    public void setTrophy(String trophy) {
        this.trophy = trophy;
    }       
}
