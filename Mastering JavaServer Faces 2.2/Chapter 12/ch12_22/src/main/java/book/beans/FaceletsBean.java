package book.beans;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class FaceletsBean {

    private String cfiletext = "|file C - text as ui:param via managed bean...  ";

    public void addFaceletAction() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        FaceletContext faceletContext = (FaceletContext) context.getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);

        faceletContext.includeFacelet(context.getViewRoot(), "/files/fileA.xhtml");
        faceletContext.setAttribute("bparam", "file B - text as ui:param via string literal...");
        faceletContext.includeFacelet(context.getViewRoot(), "/files/fileB.xhtml");
        faceletContext.setAttribute("cparam", cfiletext);
        faceletContext.includeFacelet(context.getViewRoot(), "/files/fileC.xhtml");
    }
}
