package book.beans;

import java.io.IOException;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author Leonard
 */
@ResourceDependencies({
    @ResourceDependency(name = "css/temp.css", library = "default", target = "head")
})
@FacesRenderer(componentFamily = TempConvertComponent.COMPONENT_FAMILY, rendererType = TempConvertRenderer.RENDERER_TYPE)
public class TempConvertRenderer extends Renderer {

    public static final String RENDERER_TYPE = "book.beans.TempConvertRenderer";

    public TempConvertRenderer() {
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent uicomponent) throws IOException {

        ResponseWriter responseWriter = context.getResponseWriter();
        TempConvertComponent component = (TempConvertComponent) uicomponent;

        String unit = component.getUnitto();

        responseWriter.startElement("div", component);
        responseWriter.writeAttribute("class", "tempClass", null);
        responseWriter.writeAttribute("id", component.getClientId(), "id");
        responseWriter.write("&deg;");
        if (unit.equals("fahrenheit")) {
            responseWriter.write("F ");
        } else {
            responseWriter.write("C ");
        }
        responseWriter.write(component.getTempConvert());
        responseWriter.endElement("div");
    }
}
