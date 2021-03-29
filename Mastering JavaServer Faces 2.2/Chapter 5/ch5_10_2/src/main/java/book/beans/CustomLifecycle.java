package book.beans;

import java.util.logging.Logger;
import javax.faces.FactoryFinder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.lifecycle.ClientWindow;
import javax.faces.lifecycle.ClientWindowFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleWrapper;

/**
 *
 * @author Leonard
 */
public class CustomLifecycle extends LifecycleWrapper {

    private static final Logger logger = Logger.getLogger(CustomLifecycle.class.getName());
    private Lifecycle lifecycle;

    public CustomLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override
    public void attachWindow(FacesContext context) {

        if (context.getExternalContext().getInitParameter(ClientWindow.CLIENT_WINDOW_MODE_PARAM_NAME).equals("url")) {
            ExternalContext externalContext = context.getExternalContext();
            ClientWindow clientWindow = externalContext.getClientWindow();
            if (clientWindow == null) {
                clientWindow = createClientWindow(context);
                if (clientWindow != null) {
                    CustomClientWindow customClientWindow = new CustomClientWindow(clientWindow);
                    customClientWindow.decode(context);
                    externalContext.setClientWindow(customClientWindow);
                }
            }
        }
    }

    private ClientWindow createClientWindow(FacesContext context) {        
        ClientWindowFactory clientWindowFactory = (ClientWindowFactory) FactoryFinder.getFactory(FactoryFinder.CLIENT_WINDOW_FACTORY);
        return clientWindowFactory.getClientWindow(context);
    }

    @Override
    public void execute(FacesContext context) {
        logger.info("Executing the phases of the request processing lifecycle ...");
        getWrapped().execute(context);
    }

    @Override
    public void render(FacesContext context) {
        logger.info("Executing the RENDER_RESPONSE phase of the request processing lifecycle ...");
        getWrapped().render(context);
    }

    @Override
    public Lifecycle getWrapped() {
        return lifecycle;
    }
}
