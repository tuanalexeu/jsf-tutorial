package book.beans;

import com.sun.faces.config.WebConfiguration;
import com.sun.faces.renderkit.ServerSideStateHelper;
import com.sun.faces.renderkit.StateHelper;
import com.sun.faces.util.RequestStateManager;
import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.application.StateManager;
import javax.faces.context.FacesContext;
import javax.faces.render.ResponseStateManager;
import static com.sun.faces.config.WebConfiguration.WebContextInitParameter.StateSavingMethod;

/**
 *
 * @author Leonard
 */
public class CustomResponseStateManager extends ResponseStateManager {

    private StateHelper helper;

    public CustomResponseStateManager() {
        WebConfiguration webConfig = WebConfiguration.getInstance();
        String stateMode =
                webConfig.getOptionValue(StateSavingMethod);
        helper = ((StateManager.STATE_SAVING_METHOD_CLIENT.equalsIgnoreCase(stateMode)
                ? new CustomClientSideStateHelper()
                : new ServerSideStateHelper()));
    }

    @Override
    public boolean isPostback(FacesContext context) {

        return context.getExternalContext().getRequestParameterMap().
                containsKey(ResponseStateManager.VIEW_STATE_PARAM);

    }

    @Override
    public String getCryptographicallyStrongTokenFromSession(FacesContext context) {
        return helper.getCryptographicallyStrongTokenFromSession(context);
    }

    @Override
    public String getViewState(FacesContext context, Object state) {

        StringBuilder sb = new StringBuilder(32);
        try {
            helper.writeState(context, state, sb);
        } catch (IOException e) {
            throw new FacesException(e);
        }
        return sb.toString();

    }

    @Override
    public Object getState(FacesContext context, String viewId) {

        Object state = RequestStateManager.get(context, RequestStateManager.FACES_VIEW_STATE);
        if (state == null) {
            try {
                state = helper.getState(context, viewId);
                if (state != null) {
                    RequestStateManager.set(context,
                            RequestStateManager.FACES_VIEW_STATE,
                            state);
                }
            } catch (IOException e) {
                throw new FacesException(e);
            }
        }
        return state;

    }

    @Override
    public void writeState(FacesContext context, Object state)
            throws IOException {

        helper.writeState(context, state, null);
    }

    @SuppressWarnings({"deprecation"})
    @Override
    public Object getTreeStructureToRestore(FacesContext context, String viewId) {

        Object[] state = (Object[]) getState(context, viewId);
        if (state != null) {
            return state[0];
        }
        return null;

    }

    @Override
    public boolean isStateless(FacesContext facesContext, String viewId) {
        return helper.isStateless(facesContext, viewId);
    }
}
