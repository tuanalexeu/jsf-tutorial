package book.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
@FacesConverter(value="playerConverter")
public class PlayerConverter implements Converter{
    
    @Inject
    RandomBean randomBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int code = randomBean.getRnd();
        value = value + "(" + code + ")";
        PlayerName playerName = new PlayerName(value.toLowerCase(), value.toUpperCase());
        
        return playerName;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        PlayerName playerName = (PlayerName)value;
        
        return "Mr. " + playerName.getUppercase();
    }
    
}
