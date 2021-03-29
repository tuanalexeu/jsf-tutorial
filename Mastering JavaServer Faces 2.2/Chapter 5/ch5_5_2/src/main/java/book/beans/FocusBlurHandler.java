package book.beans;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

/**
 *
 * @author Leonard
 */
public class FocusBlurHandler extends TagHandler {

    private FocusBlurBehavior onfocus = new FocusBlurBehavior();
    private FocusBlurBehavior onblur = new FocusBlurBehavior();

    public FocusBlurHandler(TagConfig tagConfig) {
        super(tagConfig);
    }

    @Override
    public void apply(FaceletContext ctx, UIComponent parent) throws IOException {
        if (parent instanceof ClientBehaviorHolder) {
            ClientBehaviorHolder clientBehaviorHolder = (ClientBehaviorHolder) parent;

            clientBehaviorHolder.addClientBehavior("focus", onfocus);
            clientBehaviorHolder.addClientBehavior("blur", onblur);
        }
    }
}
