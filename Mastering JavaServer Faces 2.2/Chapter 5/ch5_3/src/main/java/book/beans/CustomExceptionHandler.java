package book.beans;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 *
 * @author Leonard
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    private static final Logger logger = Logger.getLogger(CustomExceptionHandler.class.getName());
    private ExceptionHandler exceptionHandler;

    CustomExceptionHandler(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return exceptionHandler;
    }

    @Override
    public void handle() throws FacesException {
        
        final Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();

        while (queue.hasNext()) {
            //take exceptions one by one
            ExceptionQueuedEvent item = queue.next();
            ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) item.getSource();

            try {
                //log error
                Throwable throwable = exceptionQueuedEventContext.getException();
                logger.log(Level.SEVERE, "EXCEPTION: ", throwable.getMessage());

                //redirect error page
                FacesContext facesContext = FacesContext.getCurrentInstance();
                Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
                NavigationHandler nav = facesContext.getApplication().getNavigationHandler();

                requestMap.put("errmsg", throwable.getMessage());
                nav.handleNavigation(facesContext, null, "/error");
                facesContext.renderResponse();
            } finally {
                //remove it from queue
                queue.remove();
            }
        }

        getWrapped().handle();
    }
}
