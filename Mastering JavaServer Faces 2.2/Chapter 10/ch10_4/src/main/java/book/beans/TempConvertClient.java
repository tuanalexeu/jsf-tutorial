package book.beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Leonard
 */
public class TempConvertClient {

    public String callTempConvertService(String unitto, Float temp) {
        try {

            Document doc = null;

            switch (unitto) {
                case "fahrenheit":
                    doc = Jsoup.connect("http://www.w3schools.com/webservices/tempconvert.asmx/CelsiusToFahrenheit")
                            .data("Celsius", String.valueOf(temp))
                            .timeout(5000)
                            .post();
                    break;
                case "celsius":
                    doc = Jsoup.connect("http://www.w3schools.com/webservices/tempconvert.asmx/FahrenheitToCelsius")
                            .data("Fahrenheit", String.valueOf(temp))
                            .timeout(5000)
                            .post();
                    break;
            }

            if (doc != null) {
                Elements result = doc.getElementsByTag("string");
                return result.text();
            }

            return "";
        } catch (IOException ex) {
            Logger.getLogger(TempConvertClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }
}
