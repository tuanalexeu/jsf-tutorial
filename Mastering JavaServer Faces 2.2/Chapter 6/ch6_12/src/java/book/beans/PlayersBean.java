package book.beans;

import book.ejbs.QueryBean;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class PlayersBean implements Serializable {

    @Inject
    private QueryBean queryBean;
    
    HashSet<Object> dataHashSet = new HashSet<>();
    final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public PlayersBean() {  
    }

    public HashSet<Object> getDataHashSet() {
        return dataHashSet;
    }

    public void setDataHashSet(HashSet<Object> dataHashSet) {
        this.dataHashSet = dataHashSet;
    }

    public void addTable(String selectedTable) {
        try {
            dataHashSet.clear();
            
            dataHashSet = queryBean.populateData(selectedTable);
            
            String tableToQuery = "book.ejbs." + selectedTable;
            
            Class tableClass = Class.forName(tableToQuery);
            Field[] privateFields = tableClass.getDeclaredFields();

            TableHelper tableHelper = new TableHelper();
            HtmlDataTable tableHashSet = tableHelper.createTable("#{playersBean.dataHashSet}", HashSet.class);
            
            for (int i = 0; i < privateFields.length; i++) {                
                String privateField = privateFields[i].getName();                
                if ((!privateField.startsWith("_")) && (!privateField.equals("serialVersionUID"))) {
                    tableHelper.createColumn(tableHashSet, privateField, null, "#{t."+privateField+"}", privateFields[i].getType(), null);
                }
            }

            tableHelper.attachTable(tableHashSet, "myTable");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlayersBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
