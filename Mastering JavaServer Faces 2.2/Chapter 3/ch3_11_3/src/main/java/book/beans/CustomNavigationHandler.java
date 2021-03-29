package book.beans;

import javax.faces.application.NavigationHandler;
import javax.faces.application.NavigationHandlerWrapper;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
public class CustomNavigationHandler extends NavigationHandlerWrapper {

    private NavigationHandler configurableNavigationHandler;

    public CustomNavigationHandler() {
    }

    public CustomNavigationHandler(NavigationHandler configurableNavigationHandler) {
        this.configurableNavigationHandler = configurableNavigationHandler;
    }

    @Override
    public void handleNavigation(FacesContext context, String fromAction, String outcome) {

        if (outcome.equals("confirm_outcome")) {
            outcome = "confirm";
        }

        getWrapped().handleNavigation(context, fromAction, outcome);
    }

    @Override
    public NavigationHandler getWrapped() {
        return configurableNavigationHandler;
    }
}
