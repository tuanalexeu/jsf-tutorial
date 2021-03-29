package book.beans;

import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitContextWrapper;
import javax.faces.component.visit.VisitResult;

/**
 *
 * @author Leonard
 */
public class CustomVisitContext extends VisitContextWrapper {

    private static final Logger logger = Logger.getLogger(CustomVisitContext.class.getName());
    private VisitContext visitContext;

    public CustomVisitContext(VisitContext visitContext) {
        this.visitContext = visitContext;
    }

    @Override
    public VisitContext getWrapped() {
        return visitContext;
    }

    @Override
    public VisitResult invokeVisitCallback(UIComponent component, VisitCallback callback) {
        logger.info("Custom visit context is used!");
        return getWrapped().invokeVisitCallback(component, callback);
    }
}
