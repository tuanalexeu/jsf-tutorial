package book.beans;

import com.sun.faces.renderkit.html_basic.MessagesRenderer;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author Leonard
 */
public class EscapeMessagesRenderer extends MessagesRenderer {
        
    public EscapeMessagesRenderer(){        
    }
    
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        
        ResponseWriter responseWriter = context.getResponseWriter();        
        context.setResponseWriter(new EscapeResponseWriter(responseWriter));          
        super.encodeEnd(context, component);
        context.setResponseWriter(responseWriter);
    }   
}
