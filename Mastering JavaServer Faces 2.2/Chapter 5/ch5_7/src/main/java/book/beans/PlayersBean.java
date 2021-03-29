package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.visit.VisitContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    public void resetAction() {        
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent component = context.getViewRoot();
        CustomVisitCallback customVisitCallback = new CustomVisitCallback();
        
        component.visitTree(VisitContext.createVisitContext(FacesContext.getCurrentInstance()), customVisitCallback);
    }
}
