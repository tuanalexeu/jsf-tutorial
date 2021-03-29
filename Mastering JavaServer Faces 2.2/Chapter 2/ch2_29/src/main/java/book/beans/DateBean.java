package book.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class DateBean {

    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }        

    public String sendDate() {
        String dateAsString = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return "date.xhtml?faces-redirect=true&date=" + dateAsString;
    }
}
