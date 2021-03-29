package book.beans;

import java.io.IOException;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import javax.faces.render.RendererWrapper;

/**
 *
 * @author Leonard
 */
@ResourceDependencies({
    @ResourceDependency(name = "css/rafastyles.css", library = "default", target = "head")
})
@FacesRenderer(componentFamily = "javax.faces.Rafa", rendererType = RafaRenderer.RENDERER_TYPE)
public class RafaRenderer extends RendererWrapper {

    private Renderer renderer;
    public static final String RENDERER_TYPE = "book.beans.RafaRenderer";

    public RafaRenderer() {
    }

    public RafaRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void encodeBegin(FacesContext context, UIComponent uicomponent) throws IOException {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.writeAttribute("class", "rafastyle", "class");
        getWrapped().encodeBegin(context, uicomponent);
    }

    @Override
    public Renderer getWrapped() {
        return renderer;
    }
}
