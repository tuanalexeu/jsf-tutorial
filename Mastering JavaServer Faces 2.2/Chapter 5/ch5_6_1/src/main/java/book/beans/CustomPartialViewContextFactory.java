package book.beans;

import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.context.PartialViewContextFactory;

/**
 *
 * @author Leonard
 */
public class CustomPartialViewContextFactory extends PartialViewContextFactory {

    private PartialViewContextFactory partialViewContextFactory;

    public CustomPartialViewContextFactory(){}
    
    public CustomPartialViewContextFactory(PartialViewContextFactory partialViewContextFactory) {
        this.partialViewContextFactory = partialViewContextFactory;
    }

    @Override
    public PartialViewContext getPartialViewContext(FacesContext context) {
        
        PartialViewContext handler = new CustomPartialViewContext(partialViewContextFactory.getPartialViewContext(context));

        return handler;
        
    }
}
