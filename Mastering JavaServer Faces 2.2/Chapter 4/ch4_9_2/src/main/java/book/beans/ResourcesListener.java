package book.beans;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
public class ResourcesListener implements SystemEventListener {

    @Inject
    StyleResourcesBean styleResourcesBean;
    //@Inject
    //StyleResourcesEJBBean styleResourcesEJBBean;
    //@EJB
    //StyleResourcesEJBBean styleResourcesEJBBean;

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {

        FacesContext context = FacesContext.getCurrentInstance();

        int i = context.getViewRoot().getComponentResources(context, "HEAD").size() - 1;

        while (i >= 0) {

            UIComponent resource = context.getViewRoot().getComponentResources(context, "HEAD").get(i);

            String resourceLibrary = (String) resource.getAttributes().get("library");
            String resourceName = (String) resource.getAttributes().get("name");

            if ((resourceLibrary.equals("default")) && (resourceName.equals(styleResourcesBean.getStyles().get(0)))) {
                context.getViewRoot().removeComponentResource(context, resource, "HEAD");
            }

            i--;
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return (source instanceof UIViewRoot);
    }
}
