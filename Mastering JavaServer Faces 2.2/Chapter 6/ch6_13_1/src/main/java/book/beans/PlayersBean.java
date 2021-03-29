package book.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class PlayersBean implements Serializable {

    private HashSet<Players> dataHashSet = new HashSet<>();
    private HtmlDataTable table;
    private int rowsOnPage;
    private String criteria;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public PlayersBean() {
        rowsOnPage = 4;
        try {
            dataHashSet.add(new Players(2, "NOVAK DJOKOVIC", (byte) 26, "Belgrade, Serbia", "Monte Carlo, Monaco", (short) 188, (byte) 80, "Boris Becker, Marian Vajda", sdf.parse("22.05.1987")));
            dataHashSet.add(new Players(1, "RAFAEL NADAL", (byte) 27, "Manacor, Mallorca, Spain", "Manacor, Mallorca, Spain", (short) 185, (byte) 85, "Toni Nadal", sdf.parse("03.06.1986")));
            dataHashSet.add(new Players(7, "TOMAS BERDYCH", (byte) 28, "Valasske Mezirici, Czech", "Monte Carlo, Monaco", (short) 196, (byte) 91, "Tomas Krupa", sdf.parse("17.09.1985")));
            dataHashSet.add(new Players(8, "STANISLAS WAWRINKA", (byte) 28, "Lausanne, Switzerland", "St. Barthelemy, Switzerland", (short) 183, (byte) 81, "Magnus Norman", sdf.parse("28.03.1985")));
            dataHashSet.add(new Players(4, "ANDY MURRAY", (byte) 26, "Dunblane, Scotland", "London, England", (short) 190, (byte) 84, "Ivan Lendl", sdf.parse("15.05.1987")));
            dataHashSet.add(new Players(5, "JUAN MARTIN DEL POTRO", (byte) 25, "Tandil, Argentina", "Tandil, Argentina", (short) 198, (byte) 97, "Franco Davin", sdf.parse("23.09.1988")));
            dataHashSet.add(new Players(10, "JO-WILFRIED TSONGA", (byte) 28, "Le Mans, France", "Gingins, Switzerland", (short) 188, (byte) 91, "Nicolas Escude & Thierry Ascione", sdf.parse("17.04.1985")));
            dataHashSet.add(new Players(6, "ROGER FEDERER", (byte) 32, "Basel, Switzerland", "Bottmingen, Switzerland", (short) 185, (byte) 85, "Stefan Edberg, Severin Luthi", sdf.parse("08.08.1981")));
            dataHashSet.add(new Players(9, "RICHARD GASQUET", (byte) 27, "Beziers, France", "Neuchatel, Switzerland", (short) 185, (byte) 75, "Sergi Bruguera and Sebastien", sdf.parse("18.06.1986")));
            dataHashSet.add(new Players(3, "DAVID FERRER", (byte) 31, "Javea, Spain", "Valencia, Spain", (short) 175, (byte) 73, "Jose Francisco Altur", sdf.parse("02.04.1982")));
        } catch (ParseException ex) {
            Logger.getLogger(PlayersBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public HashSet<Players> getDataHashSet() {
        return dataHashSet;
    }

    public void setDataHashSet(HashSet<Players> dataHashSet) {
        this.dataHashSet = dataHashSet;
    }

    public HtmlDataTable getTable() {
        return table;
    }

    public void setTable(HtmlDataTable table) {
        this.table = table;
    }

    public int getRowsOnPage() {
        return rowsOnPage;
    }

    public void setRowsOnPage(int rowsOnPage) {
        this.rowsOnPage = rowsOnPage;
    }

    public void goToFirstPage() {
        table.setFirst(0);
    }

    public void goToPreviousPage() {
        table.setFirst(table.getFirst() - table.getRows());
    }

    public void goToNextPage() {
        table.setFirst(table.getFirst() + table.getRows());
    }

    public void goToLastPage() {
        int totalRows = table.getRowCount();
        int displayRows = table.getRows();
        int full = totalRows / displayRows;
        int modulo = totalRows % displayRows;

        if (modulo > 0) {
            table.setFirst(full * displayRows);
        } else {
            table.setFirst((full - 1) * displayRows);
        }
    }

    public void addTableFilter() {

        if (!criteria.equals("all")) {
            String c = "";

            for (int i = 0; i < table.getRowCount(); i++) {
                table.setRowIndex(i);
                Players player = (Players) table.getRowData();
                if (criteria.equals("<26")) {
                    if (player.getAge() >= 26) {
                        c = c + "rowhide,";
                    } else {
                        c = c + "rowshow,";
                    }
                }
                if (criteria.equals(">=26")) {
                    if (player.getAge() < 26) {
                        c = c + "rowhide,";
                    } else {
                        c = c + "rowshow,";
                    }
                }
            }
            String css = "rowshow";
            if (!c.isEmpty()) {
                css = c.substring(0, c.length() - 1);
            }

            rowsOnPage = table.getRowCount();
            table.setRowClasses(css);
            table.setFirst(0);
        } else {
            removeTableFilter();
        }
    }

    public void removeTableFilter() {
        String css = "rowshow";
        rowsOnPage = 4;
        table.setRowClasses(css);
        table.setFirst(0);
    }
}
