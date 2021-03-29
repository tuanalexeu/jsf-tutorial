package book.beans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class PlayersBean implements Serializable{
    
    private String msgsid = null;        

    public String getMsgsid() {
        return msgsid;
    }

    public void setMsgsid(String msgsid) {
        this.msgsid = msgsid;
    }       
    
    public void ajaxAction(String n){       
        msgsid = "msgsId";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("AJAX " + n + " MSG ..."));

    }
    
}
