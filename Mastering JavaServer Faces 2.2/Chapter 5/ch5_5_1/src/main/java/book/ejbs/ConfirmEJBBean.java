package book.ejbs;

import javax.ejb.Stateless;

/**
 *
 * @author Leonard
 */
@Stateless
public class ConfirmEJBBean {

    private String confirmMsg;
    
    public ConfirmEJBBean(){
        confirmMsg = "Are you sure you want to delete this file (EJB) ?";
    }   

    public String getConfirmMsg() {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg) {
        this.confirmMsg = confirmMsg;
    }  
}
