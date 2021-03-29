package book.beans;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.facelets.FaceletsResourceResolver;
import javax.faces.view.facelets.ResourceResolver;

/**
 *
 * @author Leonard
 */
@FaceletsResourceResolver
public class CustomResourceResolver extends ResourceResolver {

    private ResourceResolver resourceResolver;

    public CustomResourceResolver() {
    }

    public CustomResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    @Override
    public URL resolveUrl(String path) {

        URL result = null;
        if (path.startsWith("/template")) {
            try {
                result = new URL("file:///D:/facelets/" + path);
            } catch (MalformedURLException ex) {
                Logger.getLogger(CustomResourceResolver.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            result = resourceResolver.resolveUrl(path);
        }

        return result;
    }
}
