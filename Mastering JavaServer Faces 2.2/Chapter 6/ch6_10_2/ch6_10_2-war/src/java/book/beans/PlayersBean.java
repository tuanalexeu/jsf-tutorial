package book.beans;

import book.ejbs.Players;
import book.ejbs.PlayersSessionBean;
import java.util.HashSet;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    @Inject
    private PlayersSessionBean playersSessionBean;
    private PlayersDataModel playersDataModel;
    private HtmlDataTable table;
    private int rowsOnPage;
    private int allRowsCount = 0;

    public PlayersBean() {
    }

    @PostConstruct
    public void initHashSet() {
        rowsOnPage = 4;
        allRowsCount = playersSessionBean.countPlayersAction();
        lazyDataLoading(0);
    }

    public PlayersDataModel getPlayersDataModel() {
        return playersDataModel;
    }

    public void setPlayersDataModel(PlayersDataModel playersDataModel) {
        this.playersDataModel = playersDataModel;
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
        lazyDataLoading(0);
    }

    public void goToPreviousPage() {
        table.setFirst(table.getFirst() - table.getRows());
        lazyDataLoading(table.getFirst());
    }

    public void goToNextPage() {
        table.setFirst(table.getFirst() + table.getRows());
        lazyDataLoading(table.getFirst());
    }

    public void goToLastPage() {
        int totalRows = table.getRowCount();
        int displayRows = table.getRows();
        int full = totalRows / displayRows;
        int modulo = totalRows % displayRows;

        if ((modulo <= displayRows) && (modulo > 0)) {
            table.setFirst(full * displayRows);
        } else {
            table.setFirst(modulo + (full - 1) * displayRows);
        }

        lazyDataLoading(table.getFirst());
    }

    private void lazyDataLoading(int first) {
        HashSet<Players> dataHashSet = playersSessionBean.loadPlayersAction(first, rowsOnPage);
        playersDataModel = new PlayersDataModel(dataHashSet, allRowsCount, rowsOnPage);
    }
}
