package book.beans;

import java.util.Collection;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.context.PartialViewContextWrapper;
import javax.faces.event.PhaseId;

/**
 *
 * @author Leonard
 */
public class CustomPartialViewContext extends PartialViewContextWrapper {
    
    private PartialViewContext partialViewContext;
    private PlayersBean playersBean;

    public CustomPartialViewContext(PartialViewContext partialViewContext, PlayersBean playersBean) {
        this.partialViewContext = partialViewContext;
        this.playersBean = playersBean;
    }

    @Override
    public PartialViewContext getWrapped() {
        return partialViewContext;
    }

    @Override
    public Collection<String> getRenderIds() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (PhaseId.RENDER_RESPONSE == facesContext.getCurrentPhaseId()) {          
            UIComponent component = findComponent(playersBean.getMsgsid(), facesContext.getViewRoot());
            if (component != null && component.isRendered()) {
                String componentClientId = component.getClientId(facesContext);
                Collection<String> renderIds = getWrapped().getRenderIds();
                if (!renderIds.contains(componentClientId)) {
                    renderIds.add(componentClientId);
                }
            }
        }
        return getWrapped().getRenderIds();
    }

    private UIComponent findComponent(String id, UIComponent root) {
        if (root == null) {
            return null;
        } else if (root.getId().equals(id)) {
            return root;
        } else {
            List<UIComponent> childrenList = root.getChildren();
            if (childrenList == null || childrenList.isEmpty()) {
                return null;
            }
            for (UIComponent child : childrenList) {
                UIComponent result = findComponent(id, child);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}
