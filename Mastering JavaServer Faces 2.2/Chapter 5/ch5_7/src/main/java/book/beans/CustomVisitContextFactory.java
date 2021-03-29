package book.beans;

import java.util.Collection;
import java.util.Set;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitContextFactory;
import javax.faces.component.visit.VisitHint;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
public class CustomVisitContextFactory extends VisitContextFactory {
    
    private VisitContextFactory visitContextFactory;
    
    public CustomVisitContextFactory() {}
    
    public CustomVisitContextFactory(VisitContextFactory visitContextFactory){        
        this.visitContextFactory = visitContextFactory;
    }

    @Override
    public VisitContext getVisitContext(FacesContext context, Collection<String> ids, Set<VisitHint> hints) {
        VisitContext handler = new CustomVisitContext(visitContextFactory.getVisitContext(context, ids, hints));

        return handler;        
    }   
}
