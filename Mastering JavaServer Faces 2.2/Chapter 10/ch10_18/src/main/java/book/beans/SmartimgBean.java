package book.beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class SmartimgBean implements Serializable{
    
    private String pressed;

    public String getPressed() {
        return pressed;
    } 

    public void setPressed(String pressed) {
        this.pressed = pressed;
    }        
    
    public void smartimgAction(){ 
        System.out.println("Pressed ..." + pressed);     
        System.out.println("Take some action here ...");        
    }
    
}
