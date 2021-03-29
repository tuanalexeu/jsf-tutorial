package book.beans;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 *
 * @author Leonard
 */
@FacesComponent(value = TempConvertComponent.COMPONENT_TYPE, createTag = true, namespace = "http://temp.converter/", tagName = "temperature")
public class TempConvertComponent extends UIComponentBase {

    public TempConvertComponent() {
        setRendererType(TempConvertRenderer.RENDERER_TYPE);
    }
    public static final String COMPONENT_FAMILY = "components.TempConvertComponent";
    public static final String COMPONENT_TYPE = "book.beans.TempConvertComponent";
    private static final String ATTR_UNITTO = "unitto";
    private static final String ATTR_UNITTO_DEFAULT = "fahrenheit";
    private static final String ATTR_TEMP = "temp";
    private static final Float ATTR_TEMP_DEFAULT = 0f;

    public String getUnitto() {
        return (String) getStateHelper().eval(ATTR_UNITTO, ATTR_UNITTO_DEFAULT);
    }

    public void setUnitto(String unitto) {        
        getStateHelper().put(ATTR_UNITTO, unitto);
    }

    public Float getTemp() {
        return (Float) getStateHelper().eval(ATTR_TEMP, ATTR_TEMP_DEFAULT);
    }

    public void setTemp(Float temp) {
        getStateHelper().put(ATTR_TEMP, temp);
    }

    public String getTempConvert() {
        TempConvertClient tempConvertClient = new TempConvertClient();
        return String.format("%.1f", Float.valueOf(tempConvertClient.callTempConvertService(getUnitto(), getTemp())));
    }

    @Override
    public String getFamily() {
        return TempConvertComponent.COMPONENT_FAMILY;
    }
}
