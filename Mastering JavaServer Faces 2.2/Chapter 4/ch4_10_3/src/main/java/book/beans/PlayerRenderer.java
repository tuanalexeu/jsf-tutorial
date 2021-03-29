package book.beans;

import book.ejbs.StyleResourcesEJBBean;
import com.sun.faces.renderkit.html_basic.TextRenderer;
import javax.faces.component.UIInput;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.ListenerFor;
import javax.faces.event.PostAddToViewEvent;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
@ListenerFor(systemEventClass = PostAddToViewEvent.class, sourceClass = javax.faces.component.UIInput.class)
public class PlayerRenderer extends TextRenderer implements ComponentSystemEventListener {

    @Inject
    StyleResourcesEJBBean styleResourcesBean;    
    //@Inject
    //StyleResourcesEJBBean styleResourcesEJBBean;
    //@EJB
    //StyleResourcesEJBBean styleResourcesEJBBean;

    @Override
    public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {

        UIInput inputSource = (UIInput) event.getComponent();
        inputSource.getAttributes().put("styleClass", styleResourcesBean.getStyles().get(0));      
    }
}
