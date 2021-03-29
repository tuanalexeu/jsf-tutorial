package book.beans;

import javax.faces.context.FacesContext;
import javax.faces.lifecycle.ClientWindow;
import javax.faces.lifecycle.ClientWindowFactory;

/**
 *
 * @author Leonard
 */
public class CustomClientWindowFactory extends ClientWindowFactory {

    private ClientWindowFactory clientWindowFactory;

    public CustomClientWindowFactory() {
    }

    public CustomClientWindowFactory(ClientWindowFactory clientWindowFactory) {
        this.clientWindowFactory = clientWindowFactory;
    }

    @Override
    public ClientWindow getClientWindow(FacesContext context) {
        if (context.getExternalContext().getInitParameter(ClientWindow.CLIENT_WINDOW_MODE_PARAM_NAME).equals("url")) {
            ClientWindow defaultClientWindow = clientWindowFactory.getClientWindow(context);            
            ClientWindow customClientWindow = new CustomClientWindow(defaultClientWindow);
            return customClientWindow;
        }
        return null;
    }

    @Override
    public ClientWindowFactory getWrapped() {
        return clientWindowFactory;
    }
}
