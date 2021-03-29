package book.beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    public void readFileAction() throws IOException, URISyntaxException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Path path = Paths.get(((ServletContext)externalContext.getContext()).getRealPath("/resources/rafa.txt"));
        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
        
        externalContext.responseReset();
        externalContext.setResponseContentType("text/plain");
        externalContext.setResponseContentLength((int) attrs.size());
        externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + "rafa.txt" + "\"");

        int nRead;
        byte[] data = new byte[128];
        InputStream inStream = externalContext.getResourceAsStream("/resources/rafa.txt");
        try (OutputStream output = externalContext.getResponseOutputStream()) {

            while ((nRead = inStream.read(data, 0, data.length)) != -1) {
                output.write(data, 0, nRead);
            }
            output.flush();
        }

        facesContext.responseComplete();
    }
}
