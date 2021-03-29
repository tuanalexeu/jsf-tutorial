package book.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class TimestampVSBean implements Serializable{

    private Timestamp timestamp;

    public TimestampVSBean() {
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
