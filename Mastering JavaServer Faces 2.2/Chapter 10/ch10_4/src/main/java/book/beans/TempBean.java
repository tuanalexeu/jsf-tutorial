package book.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@SessionScoped
public class TempBean implements Serializable {
    
    private String unitto = "fahrenheit";
    private Float temp = 0f;

    public String getUnitto() {
        return unitto;
    }

    public void setUnitto(String unitto) {
        this.unitto = unitto;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {        
        this.temp = temp;
    }                
}
