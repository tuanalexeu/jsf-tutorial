package book.beans;

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
public class StyleResourcesBean {
    
    private List<String> styles = new ArrayList<>();
    
    public StyleResourcesBean(){
        styles.add("css/rafa.css");
        styles.add("css/roger.css");
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }        
    
}
