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

        Element lifecycleEl = toPopulate.createElementNS(ns, "lifecycle");
        Element phaselistenerEl = toPopulate.createElementNS(ns, "phase-listener");
        phaselistenerEl.appendChild(toPopulate.createTextNode("book.beans.DebugPhaseListener"));
        lifecycleEl.appendChild(phaselistenerEl);
        toPopulate.getDocumentElement().appendChild(lifecycleEl);

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