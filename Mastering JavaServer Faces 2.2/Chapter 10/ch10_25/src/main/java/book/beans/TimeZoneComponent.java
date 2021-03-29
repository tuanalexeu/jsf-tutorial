package book.beans;

import java.io.IOException;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeSet;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Leonard
 */
@FacesComponent(value = "book.beans.TimeZoneComponent", createTag = false)
public class TimeZoneComponent extends UIInput implements NamingContainer {

    private UIInput mainzone;
    private UIInput secondaryzone;
    private UIInput inzone;
    private static final String ATTR_MAIN_ZONES = "mainzones";
    private static final String ATTR_SECONDARY_ZONES = "secondaryzones";
    private static final String ATTR_IN_ZONES = "inzones";
    private static final SortedSet ATTR_MAIN_ZONES_DEFAULT = new TreeSet();
    private static final SortedSet ATTR_SECONDARY_ZONES_DEFAULT = new TreeSet();
    private static final SortedSet ATTR_IN_ZONES_DEFAULT = new TreeSet();
    private static final String[] timezonesids = TimeZone.getAvailableIDs();

    public SortedSet getMainzones() {
        return (SortedSet) getStateHelper().eval(ATTR_MAIN_ZONES, ATTR_MAIN_ZONES_DEFAULT);
    }

    public void setMainzones(SortedSet mainzones) {
        getStateHelper().put(ATTR_MAIN_ZONES, mainzones);
    }

    public SortedSet getSecondaryzones() {
        return (SortedSet) getStateHelper().eval(ATTR_SECONDARY_ZONES, ATTR_SECONDARY_ZONES_DEFAULT);
    }

    public void setSecondaryzones(SortedSet secondaryzones) {
        getStateHelper().put(ATTR_SECONDARY_ZONES, secondaryzones);
    }

    public SortedSet getInzones() {
        return (SortedSet) getStateHelper().eval(ATTR_IN_ZONES, ATTR_IN_ZONES_DEFAULT);
    }

    public void setInzones(SortedSet inzones) {
        getStateHelper().put(ATTR_IN_ZONES, inzones);
    }

    public UIInput getMainzone() {
        return mainzone;
    }

    public void setMainzone(UIInput mainzone) {
        this.mainzone = mainzone;
    }

    public UIInput getSecondaryzone() {
        return secondaryzone;
    }

    public void setSecondaryzone(UIInput secondaryzone) {
        this.secondaryzone = secondaryzone;
    }

    public UIInput getInzone() {
        return inzone;
    }

    public void setInzone(UIInput inzone) {
        this.inzone = inzone;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        TimeZone timezone = (TimeZone) getValue();
        String timezone_value = timezone.getID();

        String[] zone_parts = timezone_value.split("/");

        // set mainzone
        if (this.getMainzones().isEmpty()) {
            this.setMainzones(this.extractAllMainZones());
        }
        this.mainzone.setValue(zone_parts[0]);

        // set secondaryzone
        this.setSecondaryzones(this.extractAllSecondaryZones(zone_parts[0]));
        if (zone_parts.length > 1) {
            this.secondaryzone.setValue(zone_parts[1]);

            // set inzone
            if (zone_parts.length > 2) {
                this.inzone.setValue(zone_parts[2]);
            } else {
                this.inzone.setValue("");
            }
            this.setInzones(this.extractAllInZones(zone_parts[0], zone_parts[1]));
        } else {
            this.secondaryzone.setValue("");
        }

        super.encodeBegin(context);
    }

    @Override
    public Object getSubmittedValue() {
        String timezoneid = (String) this.mainzone.getSubmittedValue();
        String szid = String.valueOf(this.secondaryzone.getSubmittedValue());
        String izid = String.valueOf(this.inzone.getSubmittedValue());
        if (!szid.isEmpty()) {
            timezoneid += "/" + szid;
            if (!izid.isEmpty()) {
                timezoneid += "/" + izid;
            }
        }
        return timezoneid;
    }

    @Override
    protected Object getConvertedValue(FacesContext context, Object newSubmittedValue) throws ConverterException {
        TimeZone timeZone = TimeZone.getTimeZone((String) newSubmittedValue);
        return timeZone;
    }

    public void updateAllSecondaryZones(AjaxBehaviorEvent evt) {
        SortedSet all_sz = this.extractAllSecondaryZones((String) mainzone.getValue());
        if (!all_sz.isEmpty()) {
            this.secondaryzone.setValue(all_sz.first());
        } else {
            this.secondaryzone.setValue("");
        }
        this.setSecondaryzones(all_sz);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getPartialViewContext().getRenderIds().add(this.secondaryzone.getClientId(facesContext));

        this.updateAllInZones(evt);
    }

    public void updateAllInZones(AjaxBehaviorEvent evt) {
        SortedSet all_iz = this.extractAllInZones((String) mainzone.getValue(), (String) secondaryzone.getValue());
        if (!all_iz.isEmpty()) {
            this.inzone.setValue(all_iz.first());
        } else {
            this.inzone.setValue("");
        }
        this.setInzones(all_iz);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getPartialViewContext().getRenderIds().add(this.inzone.getClientId(facesContext));
    }

    private SortedSet extractAllMainZones() {
        SortedSet all_mz = new TreeSet();
        for (int i = 0; i < timezonesids.length; i++) {
            if (timezonesids[i].contains("/")) {
                all_mz.add(timezonesids[i].substring(0, timezonesids[i].indexOf("/")));
            } else {
                all_mz.add(timezonesids[i]);
            }
        }

        return all_mz;
    }

    private SortedSet extractAllSecondaryZones(String mz) {
        SortedSet all_sz = new TreeSet();
        for (int i = 0; i < timezonesids.length; i++) {
            if (timezonesids[i].startsWith(mz + "/")) {
                String sz = timezonesids[i].substring((timezonesids[i].indexOf("/") + 1));
                if (sz.contains("/")) {
                    sz = sz.substring(0, sz.indexOf("/"));
                }
                all_sz.add(sz);
            }
        }

        return all_sz;
    }

    private SortedSet extractAllInZones(String mz, String sz) {
        SortedSet all_iz = new TreeSet();
        for (int i = 0; i < timezonesids.length; i++) {
            if (timezonesids[i].startsWith(mz + "/" + sz + "/")) {
                all_iz.add(timezonesids[i].substring(timezonesids[i].lastIndexOf("/") + 1));
            }
        }

        return all_iz;
    }

    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }
}
