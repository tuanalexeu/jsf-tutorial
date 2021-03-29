package book.beans;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;

/**
 *
 * @author Leonard
 */
public class CustomResourceHandler extends javax.faces.application.ResourceHandlerWrapper {

    private ResourceHandler wrapped;

    public CustomResourceHandler(ResourceHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName) {

        if ((!resourceName.equals("rafa.css")) && (!resourceName.equals("roger.css"))) {
            //return super.createResource(resourceName, libraryName);  //in JSF 2.0 and JSF 2.2
            return super.createResourceFromId(libraryName + "/" + resourceName); //only in JSF 2.2
        } else {
            return new PlayerResource(resourceName);
        }
    }

    @Override
    public ResourceHandler getWrapped() {
        return this.wrapped;
    }
}
