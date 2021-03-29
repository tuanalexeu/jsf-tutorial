package book.beans;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Leonard
 */
public class PlayerPhaseListener implements PhaseListener {

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
                        inputText.setStyleClass("rafa-style");
                    } else if (value.equalsIgnoreCase("roger")) {
                        inputText.setStyleClass("roger-style");
                    }
                }
            }
            processComponents(child);
        }
    }
}
