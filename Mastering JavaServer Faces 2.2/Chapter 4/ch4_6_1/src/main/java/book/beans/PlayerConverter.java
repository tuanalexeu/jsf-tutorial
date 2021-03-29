package book.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Leonard
 */
//@FacesConverter  //use this in JSF 2.2
//@FacesConverter(value="playerConverter")  //use this in JSF 2.0
@FacesConverter(forClass=PlayerName.class)
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
