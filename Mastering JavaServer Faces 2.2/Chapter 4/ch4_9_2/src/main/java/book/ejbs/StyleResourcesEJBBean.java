package book.ejbs;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Leonard
 */
@Stateless
public class StyleResourcesEJBBean {

    private List<String> styles = new ArrayList<>();

    public StyleResourcesEJBBean() {
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
