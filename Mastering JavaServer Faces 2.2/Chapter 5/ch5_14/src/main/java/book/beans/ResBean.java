package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class ResBean {

    public void addResourcesAction() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIOutput rafa_css = new UIOutput();
        UIOutput rafa_js = new UIOutput();

        rafa_css.setRendererType("javax.faces.resource.Stylesheet");
        rafa_css.getAttributes().put("library", "default");
        rafa_css.getAttributes().put("name", "css/rafa.css");
        rafa_js.setRendererType("javax.faces.resource.Script");
        rafa_js.getAttributes().put("library", "default");
        rafa_js.getAttributes().put("name", "js/rafa.js");

        facesContext.getViewRoot().addComponentResource(facesContext, rafa_css, "head");
        facesContext.getViewRoot().addComponentResource(facesContext, rafa_js, "head");
    }
}
