package book.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewDeclarationLanguage;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class RegularComponentBean {

    public void addComponent() {
        FacesContext context = FacesContext.getCurrentInstance();
        ViewDeclarationLanguage vdl = context.getApplication().getViewHandler().getViewDeclarationLanguage(context, context.getViewRoot().getViewId());
        
        Map<String, Object> attributes = new HashMap<>();       
        attributes.put("value", createValueExpression("#{playersBean.player}", java.lang.String.class).getExpressionString());
        UIOutput outputTextComponent = (UIOutput) vdl.createComponent(context, "http://java.sun.com/jsf/html", "outputText", attributes);

        UIComponent parent = context.getViewRoot().findComponent("myPlayerId");
        outputTextComponent.setId(parent.getClientId(context) + "_" + "nameId_"+ new Date().getTime());
        parent.getChildren().clear();
        parent.getChildren().add(outputTextComponent);
    }
    
        private ValueExpression createValueExpression(String exp, Class<?> cls) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        return facesContext.getApplication().getExpressionFactory().
                createValueExpression(elContext, exp, cls);
    }
}
