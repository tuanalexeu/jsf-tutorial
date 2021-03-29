package book.beans;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Leonard
 */
public class DebugPhaseListener implements PhaseListener {

    public DebugPhaseListener() {
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("After Phase: " + event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("Before Phase:" + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
         return PhaseId.RENDER_RESPONSE;
    }
}