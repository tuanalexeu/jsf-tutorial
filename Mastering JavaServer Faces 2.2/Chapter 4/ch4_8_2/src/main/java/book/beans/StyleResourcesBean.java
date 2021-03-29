package book.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ApplicationScoped
public class StyleResourcesBean implements Serializable{
    
    private List<String> styles = new ArrayList<>();
    
    public StyleResourcesBean(){
        styles.add("rafa-style");
        styles.add("roger-style");
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }        
    
}
