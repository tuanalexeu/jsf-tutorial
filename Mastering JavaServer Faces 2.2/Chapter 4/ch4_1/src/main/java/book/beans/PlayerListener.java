package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Leonard
 */
public class PlayerListener implements ActionListener {
 
    private static final Logger logger = Logger.getLogger(PlayerListener.class.getName());
     
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        
         logger.log(Level.INFO, "Player listener class called ...");        
    }            
}
