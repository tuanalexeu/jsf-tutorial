package book.beans;

import java.util.Map;
import java.util.UUID;
import javax.faces.context.ExternalContext;
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
            synchronized (context.getExternalContext().getSession(true)) {
                final String clientWindowKey = "my.custom.id";
                ExternalContext externalContext = context.getExternalContext();
                Map<String, Object> sessionAttrs = externalContext.getSessionMap();
                Integer counter = (Integer) sessionAttrs.get(clientWindowKey);
                if (counter == null) {
                    counter = 0;
                }
                String uuid = UUID.randomUUID().toString();
                id = "UUID-" + uuid + "::" + counter;
                //String sessionId = externalContext.getSessionId(false);
                //id = sessionId + "::" + counter;
                sessionAttrs.put(clientWindowKey, ++counter);
            }
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
