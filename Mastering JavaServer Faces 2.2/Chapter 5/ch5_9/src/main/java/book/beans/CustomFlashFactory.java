package book.beans;

import javax.faces.context.Flash;
import javax.faces.context.FlashFactory;

/**
 *
 * @author Leonard
 */
public class CustomFlashFactory extends FlashFactory {

    private FlashFactory flashFactory;
    private Flash handler;

    public CustomFlashFactory() {
    }

    public CustomFlashFactory(FlashFactory flashFactory) {        
        this.flashFactory = flashFactory;
        this.handler = null;
    }

    @Override
    public Flash getFlash(boolean create) {
        if (handler == null) {
            handler = new CustomFlash(flashFactory.getFlash(create));
        }

        return handler;
    }
}
