package book.beans;

import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@SessionScoped
public class ThemeBean implements Serializable {

    private String theme = "browserpc";

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public ThemeBean() {
        Map<String, String> getRequestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap();
        String userAgent = getRequestMap.get("User-Agent");
        String httpAccept = getRequestMap.get("Accept");

        UAgentInfo detector = new UAgentInfo(userAgent, httpAccept);

        if (detector.isMobilePhone) {
            if ((detector.detectSmartphone())) {
                System.out.println("SMARTPHONE THEME!");
                theme = "Device480";
            } else {
                System.out.println("SIMPLE MOBILE THEME!");
                theme = "Device320";
            }
        } else {
            if (detector.detectTierTablet()) {
                System.out.println("TABLET THEME!");
                theme = "Device640";
            } else {
                System.out.println("BROWSER THEME!");
                theme = "browserpc";
            }
        }

    }
}
