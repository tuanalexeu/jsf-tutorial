package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Resource;

/**
 *
 * @author Leonard
 */
public class PlayerResource extends javax.faces.application.ResourceWrapper
{    
    private static final Logger logger = Logger.getLogger(PlayerResource.class.getName());
    
    private Resource resource;
    
    public PlayerResource(Resource resource) {  
        this.resource = resource;
    }
 
    @Override
    public Resource getWrapped() {
        return this.resource;
    }
 
    @Override
    public String getRequestPath() {            
        String requestPath = resource.getRequestPath();
        
        logger.log (Level.INFO, "Initial request path is: {0}", requestPath);
       
        String new_version = "v4.2.1";
        
        if(requestPath.contains("?"))
            requestPath = requestPath + "&v=" + new_version;
        else
            requestPath = requestPath + "?v=" + new_version;
        
        logger.log (Level.INFO, "New request path is: {0}", requestPath);
        
        return requestPath;
    }
 
    @Override
    public String getContentType() {
        return getWrapped().getContentType();
    }
 
}
