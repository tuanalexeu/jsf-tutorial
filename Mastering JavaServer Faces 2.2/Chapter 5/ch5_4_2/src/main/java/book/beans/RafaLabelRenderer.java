package book.beans;

import com.sun.faces.renderkit.html_basic.LabelRenderer;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
public class RafaLabelRenderer extends LabelRenderer {

    @Inject
    LabelPictureBean labelPictureBean;
    //@Inject
    //LabelPictureEJBBean labelPictureEJBBean;
    //@EJB
    //LabelPictureEJBBean labelPictureEJBBean;
    
    public RafaLabelRenderer(){        
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

        ResponseWriter responseWriter = context.getResponseWriter();     
        responseWriter.write("<img src='resources/default/img/" + labelPictureBean.getPicture() + "'/>");       
    }
}
