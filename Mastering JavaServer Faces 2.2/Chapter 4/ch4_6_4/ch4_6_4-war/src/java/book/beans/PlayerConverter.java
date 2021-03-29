package book.beans;

import book.ejbs.RandomEJBBean;
import javax.ejb.EJB;
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
    
    @EJB
    RandomEJBBean randomEJBBean;
    //@Inject
    //RandomEJBBean randomEJBBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int code = randomEJBBean.getRnd();
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
