package book.beans;

import javax.faces.component.UIInput;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 *
 * @author Leonard
 */
public class InputValidationListener implements SystemEventListener {

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        UIInput inputSource = (UIInput) event.getSource();
 
        if(!inputSource.isValid()) {
            inputSource.getAttributes().put("styleClass", "ui-invalid");
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return (source instanceof UIInput);
    }
    
}
