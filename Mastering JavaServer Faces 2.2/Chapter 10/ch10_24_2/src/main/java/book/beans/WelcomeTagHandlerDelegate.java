package book.beans;

import java.io.IOException;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.MetaRuleset;
import javax.faces.view.facelets.TagHandlerDelegate;

/**
 *
 * @author Leonard
 */
public class WelcomeTagHandlerDelegate extends TagHandlerDelegate{
    
    private static final Logger logger = Logger.getLogger(WelcomeTagHandlerDelegate.class.getName());    
    private TagHandlerDelegate tagHandlerDelegate;
    
    public WelcomeTagHandlerDelegate(){        
    }
    
    public WelcomeTagHandlerDelegate (TagHandlerDelegate tagHandlerDelegate){
        this.tagHandlerDelegate = tagHandlerDelegate;
    }
    
    @Override
    public MetaRuleset createMetaRuleset(Class type) {
        logger.info("Inside 'TagHandlerDelegate.createMetaRuleset' method");
        return tagHandlerDelegate.createMetaRuleset(type);
    }

    @Override
    public void apply(FaceletContext ctx, UIComponent comp) throws IOException {
        logger.info("Inside 'TagHandlerDelegate.apply' method");
        tagHandlerDelegate.apply(ctx, comp);
    }
    
}
