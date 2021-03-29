package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.Flash;
import javax.faces.context.FlashWrapper;

/**
 *
 * @author Leonard
 */
public class CustomFlash extends FlashWrapper {

    private static final Logger logger = Logger.getLogger(CustomFlash.class.getName());

    private Flash flash;
    
    public CustomFlash(Flash flash){
        this.flash = flash;
    }       
    
    @Override
    public Object put(String key, Object value){
        logger.log(Level.INFO, "put() was called with value added:{0}={1}", new Object[]{key, value.toString()});
        return getWrapped().put(key, value);
    }
    
    @Override
    public Object get(Object key){
        logger.log(Level.INFO, "get() was called with value added:{0}", new Object[]{key});
        return getWrapped().get(key);
    }
    
    @Override
    public  void setKeepMessages(boolean newValue){
         logger.log(Level.INFO, "setKeepMessages() was called with value: {0}", newValue);                  
         getWrapped().setKeepMessages(newValue);
    }
    
    @Override
    public Flash getWrapped() {
        return this.flash;
    }        
}
