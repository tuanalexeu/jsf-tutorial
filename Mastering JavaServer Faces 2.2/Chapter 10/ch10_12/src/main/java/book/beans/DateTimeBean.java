package book.beans;

import java.util.Calendar;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class DateTimeBean {

    private Date date;
    private Date min;
    private Date max;

    public DateTimeBean() {
        date = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -30);
        min = cal.getTime();
        cal.add(Calendar.DATE, +60);
        max = cal.getTime();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getMin() {
        return min;
    }

    public void setMin(Date min) {
        this.min = min;
    }

    public Date getMax() {
        return max;
    }

    public void setMax(Date max) {
        this.max = max;
    }        
    
    public void selectedDate(){
        System.out.println("Selected date:" + date);
    }
}
