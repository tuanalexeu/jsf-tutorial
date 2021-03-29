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
public class MsgsBean {

    public void msgAction() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesGlobalMessage = new FacesMessage("This is a global message ");
        facesContext.addMessage(null, facesGlobalMessage);
        FacesMessage facesIdMessage = new FacesMessage("This is a specific message ");
        facesContext.addMessage("formId:nameId", facesIdMessage);
    }
}
