package book.beans;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
@FacesComponent(value = "book.beans.TempConvertComponent", createTag = false)
public class TempConvertComponent extends UIInput implements NamingContainer {

    private UIInput unittoI;
    private UIInput temptI;

    public TempConvertComponent() {
    }

    public UIInput getUnittoI() {
        return unittoI;
    }

    public void setUnittoI(UIInput unittoI) {
        this.unittoI = unittoI;
    }

    public UIInput getTemptI() {
        return temptI;
    }

    public void setTemptI(UIInput temptI) {
        this.temptI = temptI;
    }

    public String getTempConvert() {
        TempConvertClient tempConvertClient = new TempConvertClient();
        return String.format("%.1f", Float.valueOf(tempConvertClient.callTempConvertService(String.valueOf(unittoI.getValue()), Float.valueOf(String.valueOf(temptI.getValue())))));
    }

    @Override
    public void decode(FacesContext context) {
        this.setSubmittedValue(temptI.getSubmittedValue() + "/" + unittoI.getSubmittedValue());
    }
         
    /*
     * you can override getSubmittedValue instead of decode
    @Override
    public Object getSubmittedValue() {
        return temptI.getSubmittedValue() + "/" + unittoI.getSubmittedValue();
    }
    */
    
    @Override
    public void encodeBegin(FacesContext context) throws IOException {

        if (getValue() != null) {
            String cv = String.valueOf(getValue());
            String unitto = cv.substring(0, cv.indexOf("/"));
            String temp = cv.substring(cv.indexOf("/") + 1);
            if (temptI.getValue() == null) {
                temptI.setValue(temp);
            }
            if (unittoI.getValue() == null) {
                unittoI.setValue(unitto);
            }
        }
        super.encodeBegin(context);
    }

    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }
}
