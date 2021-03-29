package book.pojos;

/**
 *
 * @author Leonard
 */
public class PlayerMoreDetails {
    
    private int turnedpro;
    private String coach;
    private String website;

    public PlayerMoreDetails(int turnedpro, String coach, String website) {
        this.turnedpro = turnedpro;
        this.coach = coach;
        this.website = website;
    }

    public int getTurnedpro() {
        return turnedpro;
    }

    public String getCoach() {
        return coach;
    }

    public String getWebsite() {
        return website;
    }           
}
