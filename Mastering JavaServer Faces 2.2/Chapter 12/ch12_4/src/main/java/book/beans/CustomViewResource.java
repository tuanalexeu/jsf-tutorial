package book.beans;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ViewResource;

/**
 *
 * @author Leonard
 */
public class CustomViewResource extends ViewResource {

    private String resourceName;

    public CustomViewResource(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public URL getURL() {
        URL url = null;
        try {
            url = new URL("file:///D:/facelets/" + resourceName);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CustomViewResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
    }
}
