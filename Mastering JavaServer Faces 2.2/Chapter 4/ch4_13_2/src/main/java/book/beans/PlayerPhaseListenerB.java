package book.beans;

import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Leonard
 */
public class PlayerPhaseListenerB implements PhaseListener {
    
    private static final Logger logger = Logger.getLogger(PlayerPhaseListenerB.class.getName());

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
               logger.info("Phase listener B called for component with id playerId!");
            }
            processComponents(child);
        }
    }
}
