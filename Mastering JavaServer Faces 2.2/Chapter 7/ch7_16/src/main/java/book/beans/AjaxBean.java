package book.beans;

import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class AjaxBean implements Serializable {

    private String type;
    private List<String> players = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public void processJSONAction() {

        players.clear();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String json = facesContext.getExternalContext().getRequestParameterMap().get("params");
        JsonArray personArray;
        try (JsonReader reader = Json.createReader(new StringReader(json))) {
            personArray = reader.readArray();
        }
        
        String player="";
        for (JsonValue jsonVal : personArray) {            
            JsonObject jsonObj = (JsonObject) jsonVal;
            String name = jsonObj.getString("name");
            String surname = jsonObj.getString("surname");
            int age = jsonObj.getInt("age");
            boolean ismarried = jsonObj.getBoolean("isMarried");
            JsonObject addressObj = jsonObj.getJsonObject("address");
            String city = addressObj.getString("city");
            String country = addressObj.getString("country");
            JsonArray websitesArray = jsonObj.getJsonArray("websites");
            String websites = "";
            for (JsonValue jsonSite : websitesArray) {
                websites = websites + jsonSite + ",";
            }
            websites = websites.substring(0,websites.length()-1);
            player = "Name: " + name + " Surname: " + surname + " Age: " + age + " Is Married ? " + ismarried + " City: " + city + " Country: " + country + " Websites: " + websites;
            players.add(player);
        }
    }
}
