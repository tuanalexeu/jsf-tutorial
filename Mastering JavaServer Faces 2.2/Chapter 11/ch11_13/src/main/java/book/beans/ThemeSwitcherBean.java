package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class ThemeSwitcherBean {

    private String theme = "tableGreen";

    public String getTheme() {        
        return theme;
    }

    public void setTheme(String theme) {        
        this.theme = theme;
    }  
    
    public void themeAction(String theme){       
        this.theme=theme;
    }
}
