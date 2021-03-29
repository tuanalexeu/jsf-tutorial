package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
public class ApplicationPlayerListener implements ActionListener {

    @Inject
    private DemoBean demoBean;
    private static final Logger logger = Logger.getLogger(PlayerListener.class.getName());
    private ActionListener actionListener = null;

    public ApplicationPlayerListener() {      
    }

    public ApplicationPlayerListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {

        logger.log(Level.INFO, "Application player listener class called ...");
        logger.log(Level.INFO, "Value from demo injected bean: {0}", demoBean.getDemo());
        actionListener.processAction(event);
    }
}
