package book.beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class TemplatesBean implements Serializable {
    
    private String msgTopDefault="";
    private String msgBottomDefault="";
    private String msgCenterDefault="No center content ... press the below button!";

    public String getMsgCenterDefault() {
        return msgCenterDefault;
    }

    public void setMsgCenterDefault(String msgCenterDefault) {
        this.msgCenterDefault = msgCenterDefault;
    }    
    
    public String getMsgTopDefault() {
        return msgTopDefault;
    }

    public void setMsgTopDefault(String msgTopDefault) {
        this.msgTopDefault = msgTopDefault;
    }        

    public String getMsgBottomDefault() {
        return msgBottomDefault;
    }

    public void setMsgBottomDefault(String msgBottomDefault) {
        this.msgBottomDefault = msgBottomDefault;
    }        
    
    public void topAction(String msg){
        this.msgTopDefault = msg;
    }
    
    public void bottomAction(String msg){
        this.msgBottomDefault = msg;
    }
    
    public void centerAction(){
        this.msgCenterDefault="This is default content";
    }
    
}
