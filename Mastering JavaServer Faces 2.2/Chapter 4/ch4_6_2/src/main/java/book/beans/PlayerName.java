package book.beans;

/**
 *
 * @author Leonard
 */
public class PlayerName {
    
    private String lowercase;
    private String uppercase;

    public PlayerName(String lowercase, String uppercase) {
        this.lowercase = lowercase;
        this.uppercase = uppercase;
    }        

    public String getLowercase() {
        return lowercase;
    }

    public void setLowercase(String lowercase) {
        this.lowercase = lowercase;
    }

    public String getUppercase() {
        return uppercase;
    }

    public void setUppercase(String uppercase) {
        this.uppercase = uppercase;
    }            
}
