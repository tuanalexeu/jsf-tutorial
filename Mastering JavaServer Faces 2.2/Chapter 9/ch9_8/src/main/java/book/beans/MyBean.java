package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class MyBean {    

    private static final Logger logger =
            Logger.getLogger(MyBean.class.getName());

    public void statelessQuestion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        logger.log(Level.INFO, "Is stateless (using isTransient) ? {0}", uiViewRoot.isTransient());
        logger.log(Level.INFO, "Is stateless (using isStateless) ? {0}", facesContext.getRenderKit().getResponseStateManager().isStateless(facesContext, null));

    }
}
