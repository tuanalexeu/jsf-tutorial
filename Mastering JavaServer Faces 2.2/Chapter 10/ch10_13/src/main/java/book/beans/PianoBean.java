package book.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class PianoBean implements Serializable{
    
    private List<String> mlines = new ArrayList<>();
    
    public PianoBean(){
        mlines.add("start.png");
    }

    public List<String> getMlines() {
        return mlines;
    }   
    
    public void addNote(String note){                
        mlines.add(note+".png");
    }
    
    public void notesToMusic(){
        System.out.println("PLAY ...");        
    }
    
}
