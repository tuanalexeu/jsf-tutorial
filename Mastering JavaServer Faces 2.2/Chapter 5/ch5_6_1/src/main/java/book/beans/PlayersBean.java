package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {
    
    public void ajaxAction(String n){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("AJAX " + n + " MSG ..."));

    }
    
}
