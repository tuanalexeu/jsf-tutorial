package book.beans;

import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class RandomInBean {

    private String in = "";

    public RandomInBean() {
        int in_rnd = new Random().nextInt(3);
        if (in_rnd == 0) {
            in = "in_index_A.xhtml";
        } else if (in_rnd == 1) {
            in = "in_index_B.xhtml";
        } else if (in_rnd == 2) {
            in = "in_index_C.xhtml";
        }       
    }

    public String getIn() {        
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }
}
