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
public class AjaxBean implements Serializable{
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    public void upperCaseAction(){
        name = name.toUpperCase();
    }    
}
