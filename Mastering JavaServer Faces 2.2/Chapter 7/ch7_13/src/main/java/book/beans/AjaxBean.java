package book.beans;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class AjaxBean {

    private static final Logger logger =
            Logger.getLogger(AjaxBean.class.getName());
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void ajaxAction() {
        logger.log(Level.INFO, "Name: {0}", name);
        name = name.toUpperCase();
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        logger.log(Level.INFO, "Surname: {0}", params.get("surnameInputId"));
    }
}
