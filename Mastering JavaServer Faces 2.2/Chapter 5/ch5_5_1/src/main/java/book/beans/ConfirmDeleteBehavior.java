package book.beans;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
@FacesBehavior(value = "confirm")
public class ConfirmDeleteBehavior extends ClientBehaviorBase {

    @Inject
    ConfirmBean confirmBean;
    //@Inject
    //ConfirmEJBBean confirmEJBBean;
    //@EJB
    //ConfirmEJBBean confirmEJBBean;
    
    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        return "return confirm('"+confirmBean.getConfirmMsg()+"');";
    }
}
