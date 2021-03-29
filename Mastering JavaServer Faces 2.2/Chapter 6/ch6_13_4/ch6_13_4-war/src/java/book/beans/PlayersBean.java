package book.beans;

import book.ejbs.Players;
import book.ejbs.PlayersSessionBean;
import java.io.Serializable;
import java.util.HashSet;
import javax.annotation.PostConstruct;
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
    private PlayersSessionBean playersSessionBean;
    private PlayersDataModel playersDataModel;
    private HtmlDataTable tableHashSet;
    private int rowsOnPage;
    private String criteria = "all";
    private String copy_criteria = "none";
    private int allRowsCount = 0;

    public PlayersBean() {
    }

    @PostConstruct
    public void initHashSet() {
        rowsOnPage = 4;
        lazyDataLoading(0);
    }

    public PlayersDataModel getPlayersDataModel() {
        return playersDataModel;
    }

    public void setPlayersDataModel(PlayersDataModel playersDataModel) {
        this.playersDataModel = playersDataModel;
    }

    public HtmlDataTable getTableHashSet() {
        return tableHashSet;
    }

    public void setTableHashSet(HtmlDataTable tableHashSet) {
        this.tableHashSet = tableHashSet;
    }

    public int getRowsOnPage() {
        return rowsOnPage;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public void setRowsOnPage(int rowsOnPage) {
        this.rowsOnPage = rowsOnPage;
    }

    public void goToFirstPage() {
        tableHashSet.setFirst(0);
        lazyDataLoading(0);
    }

    public void goToPreviousPage() {
        tableHashSet.setFirst(tableHashSet.getFirst() - tableHashSet.getRows());
        lazyDataLoading(tableHashSet.getFirst());
    }

    public void goToNextPage() {
        tableHashSet.setFirst(tableHashSet.getFirst() + tableHashSet.getRows());
        lazyDataLoading(tableHashSet.getFirst());
    }

    public void goToLastPage() {
        int totalRows = tableHashSet.getRowCount();
        int displayRows = tableHashSet.getRows();
        int full = totalRows / displayRows;
        int modulo = totalRows % displayRows;

        if (modulo > 0) {
            tableHashSet.setFirst(full * displayRows);
        } else {
            tableHashSet.setFirst((full - 1) * displayRows);
        }

        lazyDataLoading(tableHashSet.getFirst());
    }

    private void lazyDataLoading(int first) {
        if (!copy_criteria.equals(criteria)) {           
            allRowsCount = playersSessionBean.countPlayersAction(criteria);
            copy_criteria = criteria;
        }
        HashSet<Players> dataHashSet = playersSessionBean.loadPlayersAction(first, rowsOnPage, criteria);
        playersDataModel = new PlayersDataModel(dataHashSet, allRowsCount, rowsOnPage);
    }
}
