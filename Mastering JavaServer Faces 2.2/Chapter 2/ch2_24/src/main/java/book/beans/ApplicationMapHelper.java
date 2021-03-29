package book.beans;

import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
public class ApplicationMapHelper {
    
    public static Object getValueFromApplicationMap(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
    }  

    public static void setValueInApplicationMap(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
    }    
}
