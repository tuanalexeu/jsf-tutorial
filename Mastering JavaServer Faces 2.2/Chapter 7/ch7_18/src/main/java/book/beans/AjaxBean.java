package book.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class AjaxBean implements Serializable {

    private Map<Integer, String> myMap = new HashMap<>();

    @PostConstruct
    public void init() {
        myMap.put(1, "Nadal Rafael");
        myMap.put(2, "Federer Roger");
        myMap.put(3, "Ferer David");
        myMap.put(4, "Murray Andy");
        myMap.put(5, "Djokovic Novak");
        myMap.put(6, "Berdych Tomas");
        myMap.put(7, "Haas Tommy");
        myMap.put(8, "Isner John");
        myMap.put(9, "Fognini Fabio");
        myMap.put(10, "Robredo Tommy");
    }

    public Map<Integer, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<Integer, String> myMap) {
        this.myMap = myMap;
    }
        
    public void deletePlayerAction(String nr) {      
        if(nr!=null){               
            myMap.remove(Integer.valueOf(nr));
        }
    }
}
