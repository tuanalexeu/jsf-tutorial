package book.beans;

import javax.faces.application.ResourceDependency;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.render.ClientBehaviorRenderer;
import javax.faces.render.FacesBehaviorRenderer;

/**
 *
 * @author Leonard
 */
@FacesBehaviorRenderer(rendererType = "focusblurrenderer")
//@ResourceDependency(name="player.css", target="head")
public class FocusBlurRenderer extends ClientBehaviorRenderer {

    private static final String FOCUS_EVENT = "focus";
    private static final String BLUR_EVENT = "blur";
    
    @Override
    public String getScript(ClientBehaviorContext behaviorContext, ClientBehavior behavior) {

        if (FOCUS_EVENT.equals(behaviorContext.getEventName())) {
             //return "this.setAttribute('class','focus-css');";
            return "this.setAttribute('style','background-color: #00CC00;');";
        }

        if (BLUR_EVENT.equals(behaviorContext.getEventName())) {
            //return "this.setAttribute('class','blur-css');";
            return "this.setAttribute('style','background-color: #FFFFFF;');";
        }

        return null;
    }
}
