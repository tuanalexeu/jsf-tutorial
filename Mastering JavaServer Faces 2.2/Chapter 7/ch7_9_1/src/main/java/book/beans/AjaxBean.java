package book.beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class AjaxBean implements Serializable {

    private static final Logger logger =
            Logger.getLogger(AjaxBean.class.getName());
    private String name = "RafaelNadal";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.log(Level.INFO, "Name: {0}", name);
        this.name = name;
    }

    public void upperCaseName() {
        name = name.toUpperCase();
        logger.log(Level.INFO, "Name: {0}", name);
    }

    public void cancelName() {
        name = "";
        logger.log(Level.INFO, "Name: {0}", name);
    }
}
