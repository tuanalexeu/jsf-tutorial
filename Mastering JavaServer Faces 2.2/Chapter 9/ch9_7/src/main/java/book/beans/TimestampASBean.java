package book.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ApplicationScoped
public class TimestampASBean implements Serializable{

    private Timestamp timestamp;

    public TimestampASBean() {
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
