package book.beans;

import javax.faces.application.Resource;

/**
 *
 * @author Leonard
 */
public class PlayerResource extends javax.faces.application.ResourceWrapper {

    private String resourceName;

    public PlayerResource(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String getRequestPath() {
        return "players/css/" + this.resourceName;
    }

    @Override
    public Resource getWrapped() {
        return this;
    }
}
