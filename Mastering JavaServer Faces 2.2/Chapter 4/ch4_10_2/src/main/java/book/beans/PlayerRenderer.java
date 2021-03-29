package book.beans;

import com.sun.faces.renderkit.html_basic.TextRenderer;
import javax.faces.component.UIInput;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.ListenerFor;
import javax.faces.event.ListenersFor;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.event.PostValidateEvent;

/**
 *
 * @author Leonard
 */
 @ListenersFor({
    @ListenerFor(systemEventClass=PostAddToViewEvent.class, sourceClass = javax.faces.component.UIInput.class),
    @ListenerFor(systemEventClass=PostValidateEvent.class, sourceClass = javax.faces.component.UIInput.class)
  })
public class PlayerRenderer extends TextRenderer implements ComponentSystemEventListener {

    @Override
    public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {

        UIInput inputSource = (UIInput) event.getComponent();
        inputSource.getAttributes().put("styleClass", "rafa-style");
        
        if(!inputSource.isValid()){
            inputSource.getAttributes().put("styleClass", "ui-invalid");
        }
    }
}
