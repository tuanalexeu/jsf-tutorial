package book.ejbs;

import javax.ejb.Stateless;

/**
 *
 * @author Leonard
 */
@Stateless
public class LabelPictureEJBBean {

    private String picture;
    
    public LabelPictureEJBBean(){
        picture = "logo.png";
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }        

}
