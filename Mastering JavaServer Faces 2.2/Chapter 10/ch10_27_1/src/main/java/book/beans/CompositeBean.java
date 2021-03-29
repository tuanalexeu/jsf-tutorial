package book.beans;

import java.util.HashMap;
import java.util.Map;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewDeclarationLanguage;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class CompositeBean {

    public void addWelcomeCompositeComponent() {
        FacesContext context = FacesContext.getCurrentInstance();
        ViewDeclarationLanguage vdl = context.getApplication().getViewHandler().getViewDeclarationLanguage(context, context.getViewRoot().getViewId());

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("value", createValueExpression("#{welcomeBean.value}", java.lang.String.class).getExpressionString());
        attributes.put("to", createValueExpression("#{welcomeBean.to}", java.lang.String.class).getExpressionString());
        UINamingContainer welcomeComponent = (UINamingContainer) vdl.createComponent(context, "http://xmlns.jcp.org/jsf/composite/customs", "welcome", attributes);
        UIComponent parent = context.getViewRoot().findComponent("welcomeId");
        welcomeComponent.setId(parent.getClientId(context) + "_" + "welcomeMsgId");
        parent.getChildren().add(welcomeComponent);
    }

    public void addTemperatureCompositeComponent() {
        FacesContext context = FacesContext.getCurrentInstance();
        ViewDeclarationLanguage vdl = context.getApplication().getViewHandler().getViewDeclarationLanguage(context, context.getViewRoot().getViewId());

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("value", createValueExpression("#{tempBean.value}", java.lang.String.class).getExpressionString());
        UIComponent tempComponent = vdl.createComponent(context, "http://xmlns.jcp.org/jsf/composite/temperature", "temperature", attributes);
        UIComponent parent = context.getViewRoot().findComponent("tempFormId");
        tempComponent.setId(parent.getClientId(context) + "_" + "tempId");
        parent.getChildren().add(tempComponent);
    }

    private ValueExpression createValueExpression(String exp, Class<?> cls) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        return facesContext.getApplication().getExpressionFactory().
                createValueExpression(elContext, exp, cls);
    }
}
