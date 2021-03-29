package book.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@SessionScoped
public class TimestampSSBean implements Serializable{

    private Timestamp timestamp;

    public TimestampSSBean() {
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
