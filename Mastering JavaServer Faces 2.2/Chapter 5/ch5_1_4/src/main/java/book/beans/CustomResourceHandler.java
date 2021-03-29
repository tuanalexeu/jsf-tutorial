package book.beans;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
public class CustomResourceHandler extends javax.faces.application.ResourceHandlerWrapper {

    @Inject
    private VersionBean versionBean;
    private ResourceHandler wrapped;
 
    public CustomResourceHandler(){        
    }
    
    public CustomResourceHandler(ResourceHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ResourceHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName) {

        Resource resource = super.createResource(resourceName, libraryName);
        return new PlayerResource(resource, versionBean.getVersion());
    }
}
