package book.beans;

import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class AjaxBean implements Serializable {

    private static final Logger logger =
            Logger.getLogger(AjaxBean.class.getName());

    public void requestTypeAction() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, String> headers = externalContext.getRequestHeaderMap();
        logger.info(headers.toString());

        //determination method 1       
        PartialViewContext partialViewContext = facesContext.getPartialViewContext();
        if (partialViewContext != null) {
            if (partialViewContext.isAjaxRequest()) {
                logger.info("THIS IS AN AJAX REQUEST (DETERMINATION METHOD 1) ...");
            } else {
                logger.info("THIS IS A NON-AJAX REQUEST (DETERMINATION METHOD 1) ...");
            }
        }

        //determination method 2
        String request_type_header_FR = headers.get("Faces-Request");
        if (request_type_header_FR != null) {
            if (request_type_header_FR.equals("partial/ajax")) {
                logger.info("THIS IS AN AJAX REQUEST (DETERMINATION METHOD 2) ...");
            } else {
                logger.info("THIS IS A NON-AJAX REQUEST (DETERMINATION METHOD 2) ...");
            }
        }

        //determination method 3
        String request_type_header_XRW = headers.get("X-Requested-With");
        if (request_type_header_XRW != null) {
            if (request_type_header_XRW.equals("XMLHttpRequest")) {
                logger.info("THIS IS AN AJAX REQUEST (DETERMINATION METHOD 3) ...");
            } else {
                logger.info("THIS IS A NON-AJAX REQUEST (DETERMINATION METHOD 3) ...");
            }
        }
    }
}
