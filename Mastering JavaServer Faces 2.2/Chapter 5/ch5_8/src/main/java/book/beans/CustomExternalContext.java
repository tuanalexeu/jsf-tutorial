package book.beans;

import java.io.IOException;
import java.io.OutputStream;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonard
 */
public class CustomExternalContext extends ExternalContextWrapper {

    private ExternalContext externalContext;

    public CustomExternalContext(ExternalContext externalContext) {
        this.externalContext = externalContext;
    }

    @Override
    public ExternalContext getWrapped() {
        return externalContext;
    }

    @Override
    public OutputStream getResponseOutputStream() throws IOException { 
        HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();        
        OutputStream responseStream = response.getOutputStream();
        return new CustomResponseStream(responseStream);
    }
}
