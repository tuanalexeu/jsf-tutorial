package book.beans;

import java.io.IOException;
import java.util.Date;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Leonard
 */
@FacesComponent(value = "datetime")
public class DateTimeComponent extends UINamingContainer {

    private static final DateTimeFormatter HTML5_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd");
    private String minHTML5Date = "";
    private String maxHTML5Date = "";

    public String getMinHTML5Date() {
        return minHTML5Date;
    }

    public String getMaxHTML5Date() {
        return maxHTML5Date;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {

        Date min = (Date) getAttributes().get("min");
        if (min != null) {
            DateTime minDateTime = new DateTime(min);
            minHTML5Date = HTML5_FORMAT.print(minDateTime);
        }
        Date max = (Date) getAttributes().get("max");
        if (max != null) {
            DateTime maxDateTime = new DateTime(max);
            maxHTML5Date = HTML5_FORMAT.print(maxDateTime);
        }
        super.encodeBegin(context);
    }
}
