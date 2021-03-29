package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named(value="playerConverter")
@RequestScoped
public class PlayerConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        PlayerName playerName = new PlayerName(value.toLowerCase(), value.toUpperCase());
        
        return playerName;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        PlayerName playerName = (PlayerName)value;
        
        return "Mr. " + playerName.getUppercase();
    }
    
}
