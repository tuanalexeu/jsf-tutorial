package book.beans;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;

/**
 *
 * @author Leonard
 */
public class CustomVisitCallback implements VisitCallback{

    @Override
    public VisitResult visit(VisitContext context, UIComponent target) {
        
        if (!target.isRendered()) {
            return VisitResult.REJECT;
        }
 
        if (target instanceof EditableValueHolder) {
            ((EditableValueHolder)target).resetValue();
        }
         
        return VisitResult.ACCEPT;
    }
    
}
