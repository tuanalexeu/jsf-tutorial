package book.pojos;

import java.util.Date;

/**
 *
 * @author Leonard
 */
public class PlayerDetails {
    
    private int age;
    private Date birthday;
    private String birthplace;
    private String residence;
    private int height;
    private int weight;
    private PlayerMoreDetails playerMoreDetails;

    public PlayerDetails(int age, Date birthday, String birthplace, String residence, int height, int weight, PlayerMoreDetails playerMoreDetails) {
        this.age = age;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.residence = residence;
        this.height = height;
        this.weight = weight;
        this.playerMoreDetails = playerMoreDetails;
    }    
    
    public PlayerMoreDetails getPlayerMoreDetails() {
        return playerMoreDetails;
    }    

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getResidence() {
        return residence;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }                    
}