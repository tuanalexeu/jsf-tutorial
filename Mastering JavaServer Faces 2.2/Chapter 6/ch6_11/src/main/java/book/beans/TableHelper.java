package book.beans;

import com.sun.faces.component.visit.FullVisitContext;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;

/**
 *
 * @author Leonard
 */
public class TableHelper {

    public TableHelper() {
    }

    //create a new table
    public HtmlDataTable createTable(String exp, Class<?> cls) {
        HtmlDataTable table = new HtmlDataTable();
        table.setValueExpression("value", createValueExpression(exp, cls));
        table.setVar("t");
        table.setBorder(1);

        return table;
    }

    public HtmlColumn createColumn(HtmlDataTable table, String header_name, String footer_name, String exp, Class<?> cls, Class<?> converter) {

        HtmlColumn column = new HtmlColumn();
        table.getChildren().add(column);

        if (header_name != null) {
            HtmlOutputText header = new HtmlOutputText();
            header.setValue(header_name);
            column.setHeader(header);
        }

        if (footer_name != null) {
            HtmlOutputText footer = new HtmlOutputText();
            footer.setValue(footer_name);
            column.setFooter(footer);
        }

        HtmlOutputText output = new HtmlOutputText();
        output.setValueExpression("value", createValueExpression(exp, cls));
        column.getChildren().add(output);

        if (converter != null) {
            if (converter.getGenericInterfaces()[0].equals(Converter.class)) {
                if (converter.equals(DateTimeConverter.class)) {
                    DateTimeConverter dateTimeConverter = new DateTimeConverter();
                    dateTimeConverter.setPattern("dd.MM.yyyy");
                    output.setConverter(dateTimeConverter);
                }

                //more converters ...
            } else {
                //the passed class is not a converter!
            }
        }

        return column;
    }

    public void attachTable(HtmlDataTable table, String parent_id) throws NullPointerException {
        UIComponent component = findComponent(parent_id);
        if (component != null) {
            component.getChildren().clear();
            component.getChildren().add(table);
        } else {
            throw new NullPointerException();
        }
    }

    private UIComponent findComponent(final String id) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        final UIComponent[] found = new UIComponent[1];
        root.visitTree(new FullVisitContext(context), new VisitCallback() {
            @Override
            public VisitResult visit(VisitContext context, UIComponent component) {
                if (component.getId().equals(id)) {
                    found[0] = component;
                    return VisitResult.COMPLETE;
                }
                return VisitResult.ACCEPT;
            }
        });
        return found[0];
    }

    private ValueExpression createValueExpression(String exp, Class<?> cls) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        return facesContext.getApplication().getExpressionFactory().createValueExpression(elContext, exp, cls);
    }
}
