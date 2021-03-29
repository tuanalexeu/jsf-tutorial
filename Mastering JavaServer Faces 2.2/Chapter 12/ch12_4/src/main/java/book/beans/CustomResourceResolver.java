package book.beans;

import java.net.URL;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ViewResource;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.ResourceResolver;

/**
 *
 * @author Leonard
 */
public class CustomResourceResolver extends ResourceResolver {

    private ResourceResolver resourceResolver;

    public CustomResourceResolver() {
    }

    public CustomResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    @Override
    public URL resolveUrl(String path) {

        URL result;
        if (path.startsWith("/template")) {
            ViewResource viewResource = new CustomViewResource(path);
            result = viewResource.getURL();
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ResourceHandler resourceHandler = facesContext.getApplication().getResourceHandler();
            result = resourceHandler.createViewResource(facesContext, path).getURL();
        }

        return result;
    }
}
