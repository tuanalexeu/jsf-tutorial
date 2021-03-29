package book.beans;

import java.util.logging.Logger;
import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
public class ExceptionHandler extends ViewHandlerWrapper {

    private static final Logger logger = Logger.getLogger(ExceptionHandler.class.getName());
    private ViewHandler baseViewHandler;

    public ExceptionHandler(ViewHandler baseViewHandler) {
        this.baseViewHandler = baseViewHandler;
    }

    @Override
    public UIViewRoot restoreView(FacesContext context, String viewId) {

        UIViewRoot root;

        root = baseViewHandler.restoreView(context, viewId);
        if (root == null) {
            logger.info("The session has expired ... I will not allow ViewExpiredException ...");
            root = createView(context, viewId);

            //root = createView(context, "/expired.xhtml");
            //context.renderResponse();
        }
        return root;
    }

    @Override
    public ViewHandler getWrapped() {
        return baseViewHandler;
    }
}
