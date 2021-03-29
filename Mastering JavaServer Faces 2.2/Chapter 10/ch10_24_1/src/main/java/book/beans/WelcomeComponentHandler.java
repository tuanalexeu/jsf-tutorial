package book.beans;

import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.ComponentConfig;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.FaceletContext;

/**
 *
 * @author Leonard
 */
public class WelcomeComponentHandler extends ComponentHandler {

    private static final Logger logger = Logger.getLogger(WelcomeComponentHandler.class.getName());

    public WelcomeComponentHandler(ComponentConfig config) {
        super(config);
    }

    //only in JSF 2.2
    @Override
    public UIComponent createComponent(FaceletContext ctx) {
        logger.info("Inside 'createComponent' method");
        return null;
    }

    @Override
    public void onComponentCreated(FaceletContext ctx, UIComponent c, UIComponent parent) {
        logger.info("Inside 'onComponentCreated' method");
        super.onComponentCreated(ctx, c, parent);
    }

    @Override
    public void onComponentPopulated(FaceletContext ctx, UIComponent c, UIComponent parent) {
        logger.info("Inside 'onComponentPopulated' method");
        super.onComponentPopulated(ctx, c, parent);
    }
}
