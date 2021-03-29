package book.beans;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;

/**
 *
 * @author Leonard
 */
@FacesComponent(createTag = true, namespace = "http://temp.converter/", tagName = "temperature")
public class TempConvertComponent extends UIInput {

    public TempConvertComponent() {
        setRendererType(TempConvertDefaultRenderer.RENDERER_TYPE);        
    }    

    public String getTempConvert(String unitto, float temp) {   
        TempConvertClient tempConvertClient = new TempConvertClient();
        return String.format("%.1f", tempConvertClient.callTempConvertService(unitto, temp));
    }
     
}
