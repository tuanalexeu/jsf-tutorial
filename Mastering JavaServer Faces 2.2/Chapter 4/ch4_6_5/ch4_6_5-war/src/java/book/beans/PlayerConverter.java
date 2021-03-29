package book.beans;

import book.ejbs.RandomEJBBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Leonard
 */
@FacesConverter(value = "playerConverter")
public class PlayerConverter implements Converter {

    private static RandomEJBBean randomEJBBean;

    static {
        try {
            randomEJBBean = (RandomEJBBean) new InitialContext().lookup("java:global/ch4_6_5/ch4_6_5-ejb/RandomEJBBean");
        } catch (NamingException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int code = randomEJBBean.getRnd();
        value = value + "(" + code + ")";
        PlayerName playerName = new PlayerName(value.toLowerCase(), value.toUpperCase());

        return playerName;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        PlayerName playerName = (PlayerName) value;

        return "Mr. " + playerName.getUppercase();
    }
}
