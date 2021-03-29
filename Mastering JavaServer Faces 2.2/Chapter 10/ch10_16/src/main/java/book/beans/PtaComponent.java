package book.beans;

import java.io.IOException;
import java.util.Map;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
@FacesComponent(value = "book.beans.PtaComponent", createTag = false)
public class PtaComponent extends UIInput implements NamingContainer {

    @Override
    public void encodeBegin(FacesContext context) throws IOException {

        System.out.println("Attributes map contains:");
        for (Map.Entry<String, Object> entry : getAttributes().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"="+value);
        }
        
        System.out.println("Pass-through attributes map contains:");
        for (Map.Entry<String, Object> entry : getPassThroughAttributes().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"="+value);
        }      

        super.encodeBegin(context);
    }

    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }
}
