package book.beans;

import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class TimeZoneBean {

    private TimeZone timezone = new GregorianCalendar().getTimeZone();

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }
    
    public void timezoneAction(){
        System.out.println("Selected timezone: " + this.timezone.getID());
    }
}
