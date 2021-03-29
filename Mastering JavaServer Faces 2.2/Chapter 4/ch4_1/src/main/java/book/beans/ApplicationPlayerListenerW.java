package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ActionListenerWrapper;

/**
 *
 * @author Leonard
 */
public class ApplicationPlayerListenerW extends ActionListenerWrapper {

    private ActionListener actionListener;
    private static final Logger logger = Logger.getLogger(ApplicationPlayerListenerW.class.getName());

    public ApplicationPlayerListenerW(){        
    }
    
    public ApplicationPlayerListenerW(ActionListener actionListener){
        this.actionListener = actionListener;
    }
    
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        logger.log(Level.INFO, "Application player listener (wrapper) class called ...");
        getWrapped().processAction(event);
    }

    @Override
    public ActionListener getWrapped() {        
         return this.actionListener;
    }
}
