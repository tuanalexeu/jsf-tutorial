package book.beans;

import java.io.IOException;
import java.util.Map;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author Leonard
 */
@ResourceDependencies({
    @ResourceDependency(name = "css/temp.css", library = "default", target = "head"),
    @ResourceDependency(name = "jsf.js", library = "javax.faces", target = "body")
})
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = TempConvertRenderer.RENDERER_TYPE)
public class TempConvertRenderer extends Renderer {

    public static final String RENDERER_TYPE = "book.beans.TempConvertRenderer";

    public TempConvertRenderer() {
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent uicomponent) throws IOException {
       
        TempConvertComponent component = (TempConvertComponent) uicomponent;         

        String clientId = component.getClientId(context);
        char separator = UINamingContainer.getSeparatorChar(context);
        encodeSelectOneMenu(context, component, clientId + separator + "selectonemenu");
        encodeInput(context, component, clientId + separator + "inputfield");
        encodeButton(context, component, clientId + separator + "button");
        encodeResult(context, component, clientId + separator + "div");
    }

    @Override
    public void decode(FacesContext context, UIComponent uicomponent) {

        TempConvertComponent component = (TempConvertComponent) uicomponent;
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String clientId = component.getClientId(context);
        char separator = UINamingContainer.getSeparatorChar(context);
        String temp = ((String) requestMap.get(clientId + separator + "inputfield"));
        String unitto = ((String) requestMap.get(clientId + separator + "selectonemenu"));       
        component.setSubmittedValue(unitto+"/"+temp);       
    }        

    private void encodeResult(FacesContext context, TempConvertComponent component, String clientId) throws IOException {
        
        String cv = String.valueOf(component.getValue());
        String unitto = cv.substring(0, cv.indexOf("/"));
        String temp = cv.substring(cv.indexOf("/") + 1);
        String result = component.getTempConvert(unitto, Float.valueOf(temp));

        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("div", component);
        responseWriter.writeAttribute("class", "tempClass", null);
        responseWriter.writeAttribute("name", clientId, "clientId");
        responseWriter.write("&deg;");
            if (unitto.equals("fahrenheit")) {
                responseWriter.write("F ");
            } else {
               responseWriter.write("C ");
           }
        responseWriter.write(result);
        responseWriter.endElement("div");
    }

    private void encodeSelectOneMenu(FacesContext context, TempConvertComponent component, String clientId) throws IOException {

        String cv = String.valueOf(component.getValue());
        String unitto = cv.substring(0, cv.indexOf("/"));

        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("span", component);
        responseWriter.write("Convert to:");
        responseWriter.endElement("span");
        responseWriter.startElement("select", component);
        responseWriter.writeAttribute("name", clientId, "clientId");
        responseWriter.writeAttribute("size", 1, "size");
        responseWriter.startElement("option", component);
        responseWriter.writeAttribute("value", "fahrenheit", "value");
        if (unitto.equals("fahrenheit")) {
            responseWriter.writeAttribute("selected", "selected", "selected");
        }
        responseWriter.writeText("fahrenheit", "fahrenheit");
        responseWriter.endElement("option");
        responseWriter.startElement("option", component);
        responseWriter.writeAttribute("value", "celsius", "value");
        if (unitto.equals("celsius")) {
            responseWriter.writeAttribute("selected", "selected", "selected");
        }
        responseWriter.writeText("celsius", "celsius");
        responseWriter.endElement("option");
        responseWriter.endElement("select");
    }

    private void encodeInput(FacesContext context, TempConvertComponent component, String clientId) throws IOException {

        String cv = String.valueOf(component.getValue());
        String temp = cv.substring(cv.indexOf("/") + 1);

        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("span", component);
        responseWriter.write("Insert value:");
        responseWriter.endElement("span");
        responseWriter.startElement("input", component);
        responseWriter.writeAttribute("name", clientId, "clientId");
        responseWriter.writeAttribute("value", temp, "value");
        responseWriter.writeAttribute("type", "text", "type");
        responseWriter.endElement("input");
    }

    private void encodeButton(FacesContext context, TempConvertComponent component, String clientId) throws IOException {

        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("input", component);
        responseWriter.writeAttribute("type", "Submit", null);
        responseWriter.writeAttribute("name", clientId, "clientId");
        responseWriter.writeAttribute("value", "Convert", null);
        responseWriter.writeAttribute("onclick",
                "jsf.ajax.request(this,event,{execute:'" + "@form" + "',"
                + "render:'" + "@form" + "'," + "});"
                + "return false;", null);
        responseWriter.endElement("input");
    }
}