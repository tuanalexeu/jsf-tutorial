package book.beans;

import java.io.Serializable;
import java.util.Random;
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
public class AjaxBean implements Serializable {

    private String name="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        
    
    public void ajaxAction() {
        Random rnd = new Random();
        int sleep=1000 + rnd.nextInt(4000);
        try {
            //sleep between 1 and 5 seconds
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(AjaxBean.class.getName()).log(Level.SEVERE, null, ex);
        };        
        name=name.toUpperCase();
    }
}
