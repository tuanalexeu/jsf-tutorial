package book.beans;

import java.io.IOException;
import java.io.Serializable;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.Resource;
import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@SessionScoped
public class CompositeBean implements Serializable {

    public void addWelcomeCompositeComponent() {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent parent = context.getViewRoot().findComponent("welcomeId");
        UIComponent composite = addCompositeComponent(parent, "customs", "/welcome.xhtml", "welcomeMsgId");
        composite.setValueExpression("value", createValueExpression("#{welcomeBean.value}", java.lang.String.class));        
        composite.setValueExpression("to", createValueExpression("#{welcomeBean.to}", java.lang.String.class));        
    }
    
    public void addTemperatureCompositeComponent() {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent parent = context.getViewRoot().findComponent("tempFormId");
        UIComponent composite = addCompositeComponent(parent, "temperature", "/temperature.xhtml", "tempId");
        composite.setValueExpression("value", createValueExpression("#{tempBean.value}", java.lang.String.class));                    
    }

    private UIComponent addCompositeComponent(UIComponent compositeComponentParent, String compositeComponentLibraryName, String compositeComponentPath, String compositeComponentId) {

        // get faces and facelet context
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        FaceletContext faceletContext = (FaceletContext) context.getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);

        // creating <ui:component>
        Resource resource = application.getResourceHandler().createResource(compositeComponentPath, compositeComponentLibraryName);
        UIComponent composite = application.createComponent(context, resource);
        composite.setId(compositeComponentParent.getClientId(context) + "_" + compositeComponentId);

        // creating <composite:implementation>.
        UIComponent implementation = application.createComponent(UIPanel.COMPONENT_TYPE);
        implementation.setRendererType("javax.faces.Group");       
        composite.getFacets().put(UIComponent.COMPOSITE_FACET_NAME, implementation);

        // add composite component to its parent
        compositeComponentParent.getChildren().add(composite);
        compositeComponentParent.pushComponentToEL(context, composite);
        try {
            faceletContext.includeFacelet(implementation, resource.getURL());
        } catch (IOException e) {
            throw new FacesException(e);
        } finally {
            compositeComponentParent.popComponentFromEL(context);
        }

        return composite;
    }

    private ValueExpression createValueExpression(String exp, Class<?> cls) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        return facesContext.getApplication().getExpressionFactory().
                createValueExpression(elContext, exp, cls);
    }
}
