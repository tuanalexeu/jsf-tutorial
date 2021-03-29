package book.ejbs;

import java.util.Random;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Leonard
 */
@Stateless
@LocalBean
public class RandomEJBBean {

    private int rnd;
    
    public RandomEJBBean(){
        Random random = new Random();
        rnd = random.nextInt(10);
    }

    public int getRnd() {
        return rnd;
    }

    public void setRnd(int rnd) {
        this.rnd = rnd;
    }        

}
