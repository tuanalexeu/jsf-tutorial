package book.beans;

import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.ConfigurableNavigationHandlerWrapper;
import javax.faces.application.NavigationCase;
import javax.faces.context.FacesContext;
import javax.faces.flow.Flow;

/**
 *
 * @author Leonard
 */
public class CustomConfigurableNavigationHandler extends ConfigurableNavigationHandlerWrapper {

    private final static Logger logger = Logger.getLogger(CustomConfigurableNavigationHandler.class.getName());
    private ConfigurableNavigationHandler configurableNavigationHandler;

    public CustomConfigurableNavigationHandler() {
    }   
    
    public CustomConfigurableNavigationHandler(ConfigurableNavigationHandler configurableNavigationHandler) {
        this.configurableNavigationHandler = configurableNavigationHandler;
    }

    @Override
    public void inspectFlow(FacesContext context, Flow flow) {
        getWrapped().inspectFlow(context, flow);
        if (flow.getNavigationCases().size() > 0) {
            Map<String, Set<NavigationCase>> navigationCases = flow.getNavigationCases();

            for (Map.Entry<String, Set<NavigationCase>> entry : navigationCases.entrySet()) {
                logger.log(Level.INFO, "Navigation case: {0}", entry.getKey());
                for (NavigationCase nc : entry.getValue()) {
                    logger.log(Level.INFO, "From view id: {0}", nc.getFromViewId());
                    logger.log(Level.INFO, "From outcome: {0}", nc.getFromOutcome());
                    logger.log(Level.INFO, "To view id: {0}", nc.getToViewId(context));
                    logger.log(Level.INFO, "Redirect: {0}", nc.isRedirect());
                }
            }
        }
    }

    @Override
    public ConfigurableNavigationHandler getWrapped() {
        return configurableNavigationHandler;
    }
}
