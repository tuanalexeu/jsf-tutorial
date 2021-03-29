package book.beans;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leonard
 */
public class PlayersBean {

    private String name;
    private String surname;
    private int age;
    private String rafakey;
    private Map<String, String> matchfacts = new HashMap<>();
    private String[] titles_2013;

    public enum Plays {

        Left, Right
    };
    private Plays play;

    public String[] getTitles_2013() {
        return titles_2013;
    }

    public void setTitles_2013(String[] titles_2013) {
        this.titles_2013 = titles_2013;
    }   
    
    public Map<String, String> getMatchfacts() {
        return matchfacts;
    }

    public void setMatchfacts(Map<String, String> matchfacts) {
        this.matchfacts = matchfacts;
    }     
    
    public String getRafakey() {
        return rafakey;
    }

    public void setRafakey(String rafakey) {
        this.rafakey = rafakey;
    }    
    
    public Plays getPlay() {
        return play;
    }

    public void setPlay(Plays play) {
        this.play = play;
    }        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
