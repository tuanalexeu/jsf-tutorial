package book.beans;

import java.util.logging.Logger;
import javax.faces.view.ViewDeclarationLanguage;
import javax.faces.view.ViewDeclarationLanguageFactory;

/**
 *
 * @author Leonard
 */
public class CustomViewDeclarationLanguageFactory extends ViewDeclarationLanguageFactory{
    
    private static final Logger logger = Logger.getLogger(CustomViewDeclarationLanguageFactory.class.getName());    
    private ViewDeclarationLanguageFactory viewDeclarationLanguageFactory;
    
    public CustomViewDeclarationLanguageFactory(ViewDeclarationLanguageFactory viewDeclarationLanguageFactory){        
        this.viewDeclarationLanguageFactory = viewDeclarationLanguageFactory;
        logger.info("Using your custom VDL  ...");
    }
    
    @Override
    public ViewDeclarationLanguage getViewDeclarationLanguage(String viewId) {        
        return new CustomViewDeclarationLanguage(viewDeclarationLanguageFactory.getViewDeclarationLanguage(viewId));
    }
    
}
