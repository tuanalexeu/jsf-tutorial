package book.beans;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.FacesBehavior;

/**
 *
 * @author Leonard
 */
@FacesBehavior(value = "focusblur")
public class FocusBlurBehavior extends ClientBehaviorBase {

    @Override
    public String getRendererType() {           
        return "focusblurrenderer";
    }
}
