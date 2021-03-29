package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.lifecycle.ClientWindow;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PullWindowIdBean {

    private static final Logger logger = Logger.getLogger(PullWindowIdBean.class.getName());

    public void pullWindowIdAction() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        ClientWindow clientWindow = externalContext.getClientWindow();
        if (clientWindow != null) {
            logger.log(Level.INFO, "The current client window id is:{0}", clientWindow.getId());
        } else {
            logger.log(Level.INFO, "Client Window cannot be determined!");
        }
    }
}
