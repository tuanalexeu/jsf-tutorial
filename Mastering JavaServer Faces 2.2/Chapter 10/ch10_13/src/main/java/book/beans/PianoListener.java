package book.beans;

import java.util.List;
import javax.el.ELResolver;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Leonard
 */
public class PianoListener implements ActionListener {

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELResolver elResolver = facesContext.getApplication().getELResolver();
        PianoBean pianoBean = (PianoBean) elResolver.getValue(facesContext.getELContext(), null, "pianoBean");
        
        List<UIComponent> comps = ((UIComponent) event.getSource()).getChildren();
        for (UIComponent comp : comps) {
            if (comp.getClientId().endsWith("noteId")) {
                pianoBean.addNote(String.valueOf(comp.getAttributes().get("value")));
            }
        }
    }
}
