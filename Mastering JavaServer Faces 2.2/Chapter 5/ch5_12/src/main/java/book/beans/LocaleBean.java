package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class LocaleBean {

    private String mylocale = "fr";

    public String getMylocale() {
        return mylocale;
    }  

    public void changeLocale(String mylocale) {
        this.mylocale = mylocale;
    }
}
