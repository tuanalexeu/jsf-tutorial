package book.beans;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.ResponseWriter;
import javax.faces.context.ResponseWriterWrapper;

/**
 *
 * @author Leonard
 */
public class EscapeResponseWriter extends ResponseWriterWrapper {

    private ResponseWriter responseWriter;

    public EscapeResponseWriter(ResponseWriter responseWriter) {
        this.responseWriter = responseWriter;
    }

    @Override
    public ResponseWriter getWrapped() {
        return responseWriter;
    }

    @Override
    public void writeText(Object text, UIComponent component, String property)
            throws IOException {

        String escape = (String) component.getAttributes().get("escape");
        if (escape != null) {
            if ("false".equals(escape)) {
                super.write(String.valueOf(text));
            } else {
                super.writeText(String.valueOf(text), component, property);
            }
        }
    }
}
