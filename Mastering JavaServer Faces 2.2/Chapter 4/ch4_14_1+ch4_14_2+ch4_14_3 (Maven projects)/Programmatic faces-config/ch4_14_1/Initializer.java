package book.beans;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ApplicationConfigurationPopulator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Leonard
 */
public class Initializer extends ApplicationConfigurationPopulator {

    @Override
    public void populateApplicationConfiguration(Document toPopulate) {

        String ns = toPopulate.getDocumentElement().getNamespaceURI();

        Element managedbeanEl = toPopulate.createElementNS(ns, "managed-bean");

        Element managedbeannameEl = toPopulate.createElementNS(ns, "managed-bean-name");
        managedbeannameEl.appendChild(toPopulate.createTextNode("playersBean"));
        managedbeanEl.appendChild(managedbeannameEl);

        Element managedbeanclassEl = toPopulate.createElementNS(ns, "managed-bean-class");
        managedbeanclassEl.appendChild(toPopulate.createTextNode("book.beans.PlayersBean"));
        managedbeanEl.appendChild(managedbeanclassEl);

        Element managedbeanscopeEl = toPopulate.createElementNS(ns, "managed-bean-scope");
        managedbeanscopeEl.appendChild(toPopulate.createTextNode("request"));
        managedbeanEl.appendChild(managedbeanscopeEl);

        Element managedproperty0El = toPopulate.createElementNS(ns, "managed-property");
        Element propertyNameEl = toPopulate.createElementNS(ns, "property-name");
        propertyNameEl.appendChild(toPopulate.createTextNode("name"));
        Element valueNameEl = toPopulate.createElementNS(ns, "value");
        valueNameEl.appendChild(toPopulate.createTextNode("Nadal"));
        managedproperty0El.appendChild(propertyNameEl);
        managedproperty0El.appendChild(valueNameEl);
        managedbeanEl.appendChild(managedproperty0El);

        Element managedproperty1El = toPopulate.createElementNS(ns, "managed-property");
        Element propertySurnameEl = toPopulate.createElementNS(ns, "property-name");
        propertySurnameEl.appendChild(toPopulate.createTextNode("surname"));
        Element valueSurnameEl = toPopulate.createElementNS(ns, "value");
        valueSurnameEl.appendChild(toPopulate.createTextNode("Rafael"));
        managedproperty1El.appendChild(propertySurnameEl);
        managedproperty1El.appendChild(valueSurnameEl);
        managedbeanEl.appendChild(managedproperty1El);

        Element managedproperty2El = toPopulate.createElementNS(ns, "managed-property");
        Element propertyAgeEl = toPopulate.createElementNS(ns, "property-name");
        propertyAgeEl.appendChild(toPopulate.createTextNode("age"));
        Element valueAgeEl = toPopulate.createElementNS(ns, "value");
        valueAgeEl.appendChild(toPopulate.createTextNode("27"));
        managedproperty2El.appendChild(propertyAgeEl);
        managedproperty2El.appendChild(valueAgeEl);
        managedbeanEl.appendChild(managedproperty2El);

        Element managedproperty3El = toPopulate.createElementNS(ns, "managed-property");
        Element propertyPlayEl = toPopulate.createElementNS(ns, "property-name");
        propertyPlayEl.appendChild(toPopulate.createTextNode("play"));
        Element valuePlayEl = toPopulate.createElementNS(ns, "value");
        valuePlayEl.appendChild(toPopulate.createTextNode("Left"));
        managedproperty3El.appendChild(propertyPlayEl);
        managedproperty3El.appendChild(valuePlayEl);
        managedbeanEl.appendChild(managedproperty3El);

        Element managedproperty4El = toPopulate.createElementNS(ns, "managed-property");
        Element propertyRafakeyEl = toPopulate.createElementNS(ns, "property-name");
        propertyRafakeyEl.appendChild(toPopulate.createTextNode("rafakey"));
        Element valueRafakeyEl = toPopulate.createElementNS(ns, "value");
        valueRafakeyEl.appendChild(toPopulate.createTextNode("#{initParam.rafakey}"));
        managedproperty4El.appendChild(propertyRafakeyEl);
        managedproperty4El.appendChild(valueRafakeyEl);
        managedbeanEl.appendChild(managedproperty4El);

        Element managedproperty5El = toPopulate.createElementNS(ns, "managed-property");
        Element propertyMatchfactsEl = toPopulate.createElementNS(ns, "property-name");
        propertyMatchfactsEl.appendChild(toPopulate.createTextNode("matchfacts"));
        Element mapEntriesEl = toPopulate.createElementNS(ns, "map-entries");
        Element mapEntry0El = toPopulate.createElementNS(ns, "map-entry");
        Element key0El = toPopulate.createElementNS(ns, "key");
        key0El.appendChild(toPopulate.createTextNode("Aces"));
        Element value0El = toPopulate.createElementNS(ns, "value");
        value0El.appendChild(toPopulate.createTextNode("12"));
        mapEntry0El.appendChild(key0El);
        mapEntry0El.appendChild(value0El);
        Element mapEntry1El = toPopulate.createElementNS(ns, "map-entry");
        Element key1El = toPopulate.createElementNS(ns, "key");
        key1El.appendChild(toPopulate.createTextNode("Double Faults"));
        Element value1El = toPopulate.createElementNS(ns, "value");
        value1El.appendChild(toPopulate.createTextNode("2"));
        mapEntry1El.appendChild(key1El);
        mapEntry1El.appendChild(value1El);
        Element mapEntry2El = toPopulate.createElementNS(ns, "map-entry");
        Element key2El = toPopulate.createElementNS(ns, "key");
        key2El.appendChild(toPopulate.createTextNode("1st Serve"));
        Element value2El = toPopulate.createElementNS(ns, "value");
        value2El.appendChild(toPopulate.createTextNode("70%"));
        mapEntry2El.appendChild(key2El);
        mapEntry2El.appendChild(value2El);
        mapEntriesEl.appendChild(mapEntry0El);
        mapEntriesEl.appendChild(mapEntry1El);
        mapEntriesEl.appendChild(mapEntry2El);
        managedproperty5El.appendChild(propertyMatchfactsEl);
        managedproperty5El.appendChild(mapEntriesEl);
        managedbeanEl.appendChild(managedproperty5El);

        Element managedproperty6El = toPopulate.createElementNS(ns, "managed-property");
        Element propertyTitles_2013El = toPopulate.createElementNS(ns, "property-name");
        propertyTitles_2013El.appendChild(toPopulate.createTextNode("titles_2013"));
        Element listEntriesEl = toPopulate.createElementNS(ns, "list-entries");
        Element valueClassEl = toPopulate.createElementNS(ns, "value-class");
        valueClassEl.appendChild(toPopulate.createTextNode("java.lang.String"));
        Element value0lEl = toPopulate.createElementNS(ns, "value");
        value0lEl.appendChild(toPopulate.createTextNode("Sao Paulo"));
        Element value1lEl = toPopulate.createElementNS(ns, "value");
        value1lEl.appendChild(toPopulate.createTextNode("Acapulco"));
        Element value2lEl = toPopulate.createElementNS(ns, "value");
        value2lEl.appendChild(toPopulate.createTextNode("Barcelona"));
        Element value3lEl = toPopulate.createElementNS(ns, "value");
        value3lEl.appendChild(toPopulate.createTextNode("..."));
        Element nullValuelEl = toPopulate.createElementNS(ns, "null-value");
        listEntriesEl.appendChild(valueClassEl);
        listEntriesEl.appendChild(value0lEl);
        listEntriesEl.appendChild(value1lEl);
        listEntriesEl.appendChild(value2lEl);
        listEntriesEl.appendChild(value3lEl);
        listEntriesEl.appendChild(nullValuelEl);
        managedproperty6El.appendChild(propertyTitles_2013El);
        managedproperty6El.appendChild(listEntriesEl);
        managedbeanEl.appendChild(managedproperty6El);

        toPopulate.getDocumentElement().appendChild(managedbeanEl);

        serializeFacesConfig(toPopulate, "D://faces-config.xml");
    }

    private void serializeFacesConfig(Document document, String path) {

        FileOutputStream fileOutputStream = null;
        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setIndent(5);
        outputFormat.setLineWidth(150);

        try {
            fileOutputStream = new FileOutputStream(path);

            XMLSerializer xmlSerializer = new XMLSerializer();
            xmlSerializer.setOutputFormat(outputFormat);
            xmlSerializer.setOutputByteStream((OutputStream) fileOutputStream);

            xmlSerializer.serialize(document);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}