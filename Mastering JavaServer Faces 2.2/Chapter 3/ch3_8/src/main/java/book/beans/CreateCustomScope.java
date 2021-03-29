package book.beans;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Leonard
 */
public class CreateCustomScope implements ActionListener {

    private static final Logger logger = Logger.getLogger(CreateCustomScope.class.getName());

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {

        logger.log(Level.INFO, "Creating custom scope ...");

        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> applicationMap = context.getExternalContext().getApplicationMap();
        CustomScope customScope = (CustomScope) applicationMap.get(CustomScope.SCOPE);

        if (customScope == null) {
            customScope = new CustomScope();
            applicationMap.put(CustomScope.SCOPE, customScope);

            customScope.scopeCreated(context);
        } else {
            logger.log(Level.INFO, "Custom scope exists ...");
        }
    }
}
