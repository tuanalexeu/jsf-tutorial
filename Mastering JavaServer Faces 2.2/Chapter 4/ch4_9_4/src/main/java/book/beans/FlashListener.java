package book.beans;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 *
 * @author Leonard
 */
public class FlashListener implements SystemEventListener {

    private final static Logger LOGGER = Logger.getLogger(FlashListener.class.getName());

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {

        if (event.getSource() instanceof String) {
            LOGGER.log(Level.INFO, "The following parameter was added in flash scope: {0}", event.getSource());
        } else if (event.getSource() instanceof Map) {
            LOGGER.info("Preparing to clear flash scope ...");
            LOGGER.info("Current content:");
            Iterator iterator = ((Map) event.getSource()).entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                LOGGER.log(Level.INFO, "{0}={1}", new Object[]{mapEntry.getKey(), mapEntry.getValue()});
            }
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return ((source instanceof String) || (source instanceof Map));
    }
}
