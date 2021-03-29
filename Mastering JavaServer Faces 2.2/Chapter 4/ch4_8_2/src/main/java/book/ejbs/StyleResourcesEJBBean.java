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
