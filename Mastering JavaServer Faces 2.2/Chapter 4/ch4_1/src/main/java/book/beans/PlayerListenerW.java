package book.beans;

import javax.faces.event.ActionListener;
import javax.faces.event.ActionListenerWrapper;

/**
 *
 * @author Leonard
 */
public class PlayerListenerW extends ActionListenerWrapper {

    PlayerListener playerListener = new PlayerListener();
    
    @Override
    public ActionListener getWrapped() {
        return playerListener;
    }
}
