package book.beans;

import java.io.IOException;
import java.util.logging.Logger;
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
    
    private static final Logger logger = Logger.getLogger(WelcomeComponent.class.getName());
        
    @Override
    public String getFamily() {
        return "welcome.component";
    } 
    
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        logger.info("Inside 'WelcomeComponent.encodeBegin' method");
        String value = (String) getAttributes().get("value");
        String to = (String) getAttributes().get("to");

        if ((value != null) && (to != null)) {
            ResponseWriter writer = context.getResponseWriter();
            writer.writeAttribute("id", getClientId(context), null);
            writer.write(value + ", " + to);
        }
    }
}
