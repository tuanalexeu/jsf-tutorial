package book.beans;

import book.ejbs.StyleResourcesEJBBean;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
public class PlayerPhaseListener implements PhaseListener {

    //@Inject
    //StyleResourcesBean styleResourcesBean;    
    @Inject
    StyleResourcesEJBBean styleResourcesEJBBean;
    //@EJB
    //StyleResourcesEJBBean styleResourcesEJBBean;
    
    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        processComponents(event.getFacesContext().getViewRoot());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

    private void processComponents(UIComponent root) {
        for (UIComponent child : root.getChildren()) {
            if (child.getId().equals("playerId")) {
                HtmlInputText inputText = (HtmlInputText) child;
                String value = (String) inputText.getValue();

                if (value != null) {
                    if (value.equalsIgnoreCase("rafa")) {
                        inputText.setStyleClass(styleResourcesEJBBean.getStyles().get(0));
                    } else if (value.equalsIgnoreCase("roger")) {
                        inputText.setStyleClass(styleResourcesEJBBean.getStyles().get(1));
                    }
                }
            }
            processComponents(child);
        }
    }
}
