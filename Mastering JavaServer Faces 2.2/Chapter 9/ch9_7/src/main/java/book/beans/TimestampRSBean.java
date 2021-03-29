package book.beans;

import java.sql.Timestamp;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class TimestampRSBean {

    private Timestamp timestamp;

    public TimestampRSBean() {
        java.util.Date date = new java.util.Date();
        timestamp = new Timestamp(date.getTime());
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
