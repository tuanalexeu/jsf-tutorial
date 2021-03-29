package book.beans;

import javax.faces.view.ViewDeclarationLanguage;
import javax.faces.view.ViewDeclarationLanguageWrapper;

/**
 *
 * @author Leonard
 */
public class CustomViewDeclarationLanguage extends ViewDeclarationLanguageWrapper {

    private ViewDeclarationLanguage viewDeclarationLanguage;

    public CustomViewDeclarationLanguage(ViewDeclarationLanguage viewDeclarationLanguage) {
        this.viewDeclarationLanguage = viewDeclarationLanguage;
    }

    //override here the needed methods
    
    @Override
    public ViewDeclarationLanguage getWrapped() {
        return viewDeclarationLanguage;
    }
}
