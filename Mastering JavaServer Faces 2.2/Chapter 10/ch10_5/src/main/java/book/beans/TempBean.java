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
    
    private String value = "celsius/0";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }              
}
