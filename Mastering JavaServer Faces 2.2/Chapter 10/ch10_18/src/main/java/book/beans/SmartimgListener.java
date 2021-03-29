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
public class SmartimgListener implements ActionListener {

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELResolver elResolver = facesContext.getApplication().getELResolver();
        SmartimgBean smartimgBean = (SmartimgBean) elResolver.getValue(facesContext.getELContext(), null, "smartimgBean");

        List<UIComponent> comps = ((UIComponent) event.getSource()).getChildren();
        for (UIComponent comp : comps) {
             if (comp.getClientId().endsWith("itemId")) {
                smartimgBean.setPressed(String.valueOf(comp.getAttributes().get("value")));
            }
        }
    }
}
