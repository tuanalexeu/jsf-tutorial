package book.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {
    
    public void someAction(){
        throw new NullPointerException();
    }
    
}
