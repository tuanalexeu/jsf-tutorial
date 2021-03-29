package book.beans;


import com.sun.faces.renderkit.html_basic.TextRenderer;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
//import javax.faces.render.FacesRenderer;

/**
 *
 * @author Leonard
 */
//@FacesRenderer(componentFamily="javax.faces.Input",rendererType="javax.faces.Text") //not working as expected!
public class PlayerInputTextRenderer extends TextRenderer {

    public PlayerInputTextRenderer(){        
    }
    
    @Override
    protected void getEndTextToRender(FacesContext context, UIComponent component, String currentValue)
            throws java.io.IOException {
        String[] attributes = {"player-nickname", "player-mother-name", "player-father-name"};
        ResponseWriter writer = context.getResponseWriter();
        for (String attribute : attributes) {
            String value = (String) component.getAttributes().get(attribute);
            if (value != null) {
                writer.writeAttribute(attribute, value, attribute);
            }
        }
        super.getEndTextToRender(context, component, currentValue);
    }
}
