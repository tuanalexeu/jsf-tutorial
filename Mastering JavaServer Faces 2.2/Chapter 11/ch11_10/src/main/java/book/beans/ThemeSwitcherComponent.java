package book.beans;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UINamingContainer;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Leonard
 */
@FacesComponent(value = "book.beans.ThemeSwitcherComponent", createTag = false)
public class ThemeSwitcherComponent extends UIComponentBase implements NamingContainer {

    private List<String> contracts = new ArrayList<>();

    public List<String> getContracts() {
        return contracts;
    }
 
    public ThemeSwitcherComponent() throws IOException {
        //System.out.println("DETECTING THEMES ..................................");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Path path = Paths.get(((ServletContext) externalContext.getContext()).getRealPath("/contracts"));
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
            for (Path file : ds) {
                if (Files.readAttributes(file, BasicFileAttributes.class).isDirectory()) {
                    contracts.add(file.getFileName().toString());
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }
}
