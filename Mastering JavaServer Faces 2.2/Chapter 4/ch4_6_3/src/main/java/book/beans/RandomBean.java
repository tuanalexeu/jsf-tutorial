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
public class RandomBean {
 
    private int rnd;
    
    public RandomBean(){
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
