package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.application.StateManager;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {
    
    private static final Logger logger =
            Logger.getLogger(PlayersBean.class.getName());
    private String name;
    private String surname;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void playerUpperCase() {
        name = name.toUpperCase();
        surname = surname.toUpperCase();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application application = facesContext.getApplication();
        StateManager stateManager = application.getStateManager();
        logger.log(Level.INFO, "Is view state saved on client ? {0}", stateManager.isSavingStateInClient(facesContext));
    }
}
