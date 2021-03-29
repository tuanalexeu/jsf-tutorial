package book.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ApplicationScoped
public class VersionBean {
    
    private String version;
           
    public VersionBean(){
        this.version = "4.2.1";
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }            
}
