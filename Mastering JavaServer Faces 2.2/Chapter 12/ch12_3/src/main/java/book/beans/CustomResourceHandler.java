package book.beans;

import java.util.logging.Logger;
import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.application.ViewResource;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
public class CustomResourceHandler extends ResourceHandlerWrapper {

    private static final Logger logger =
            Logger.getLogger(CustomResourceHandler.class.getName());
    private ResourceHandler resourceHandler;

    public CustomResourceHandler() {
    }

    public CustomResourceHandler(ResourceHandler resourceHandler) {
        this.resourceHandler = resourceHandler;
    }

    @Override
    public Resource createResource(String resourceName, String libraryOrContractName) {
        logger.info(" ... other kinds of resources, such as scripts and stylesheets:");
        logger.info(resourceName);
        return getWrapped().createResource(resourceName, libraryOrContractName);
    }

    @Override
    public ViewResource createViewResource(FacesContext context, String resourceName) {

        ViewResource viewResource;
        if (resourceName.startsWith("/template")) {
            viewResource = new CustomViewResource(resourceName);
        } else {
            viewResource = getWrapped().createViewResource(context, resourceName);
        }

        return viewResource;
    }

    @Override
    public ResourceHandler getWrapped() {
        return this.resourceHandler;
    }
}
