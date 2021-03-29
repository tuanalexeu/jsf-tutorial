package book.beans;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Leonard
 */
public class MsgPhaseListener implements PhaseListener {
    
    private static final Logger logger = Logger.getLogger(MsgPhaseListener.class.getName());    
    
    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        Iterator<String> ids = facesContext.getClientIdsWithMessages();

        while (ids.hasNext()) {
            String id = ids.next();
            Iterator<FacesMessage> messages = facesContext.getMessages(id);

            while (messages.hasNext()) {
                FacesMessage message = messages.next();
                logger.log(Level.INFO, "User ID:{0} Message: {1}", new Object[]{id, message.getSummary()});
                if(id == null){
                    message.setSummary(message.getSummary() + "alered by a pahse listener!");
                }
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }     
}
