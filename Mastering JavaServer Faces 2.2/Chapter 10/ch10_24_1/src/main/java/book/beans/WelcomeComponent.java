package book.beans;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author Leonard
 */
@FacesComponent("components.WelcomeComponent")
public class WelcomeComponent extends UIComponentBase {

    @Override
    public String getFamily() {
        return "welcome.component";
    } 
    
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        String value = (String) getAttributes().get("value");
        String to = (String) getAttributes().get("to");

        if ((value != null) && (to != null)) {
            ResponseWriter writer = context.getResponseWriter();
            writer.writeAttribute("id", getClientId(context), null);
            writer.write(value + ", " + to);
        }
    }
}
