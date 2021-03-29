package book.beans;

import java.util.Date;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.lifecycle.ClientWindow;
import javax.faces.lifecycle.ClientWindowWrapper;
import javax.faces.render.ResponseStateManager;

/**
 *
 * @author Leonard
 */
public class CustomClientWindow extends ClientWindowWrapper {

    private ClientWindow clientWindow;
    String id;

    public CustomClientWindow() {
    }

    public CustomClientWindow(ClientWindow clientWindow) {
        this.clientWindow = clientWindow;
    }

    @Override
    public void decode(FacesContext context) {

        Map<String, String> requestParamMap = context.getExternalContext().getRequestParameterMap();
        if (isClientWindowRenderModeEnabled(context)) {
            id = requestParamMap.get(ResponseStateManager.CLIENT_WINDOW_URL_PARAM);
        }
        if (requestParamMap.containsKey(ResponseStateManager.CLIENT_WINDOW_PARAM)) {
            id = requestParamMap.get(ResponseStateManager.CLIENT_WINDOW_PARAM);
        }
        if (id == null) {
            long time = new Date().getTime();
            id = "CUSTOM-" + time;
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public ClientWindow getWrapped() {
        return this.clientWindow;
    }
}
