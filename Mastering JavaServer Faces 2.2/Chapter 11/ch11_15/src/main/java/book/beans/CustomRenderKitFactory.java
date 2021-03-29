package book.beans;

import java.util.Iterator;
import javax.faces.context.FacesContext;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitFactory;

/**
 *
 * @author Leonard
 */
public class CustomRenderKitFactory extends RenderKitFactory {

    private RenderKitFactory renderKitFactory;

    public CustomRenderKitFactory() {
    }
     
    public CustomRenderKitFactory(RenderKitFactory renderKitFactory) {
        this.renderKitFactory = renderKitFactory;
    }

    @Override
    public void addRenderKit(String renderKitId, RenderKit renderKit) {
        renderKitFactory.addRenderKit(renderKitId, renderKit);
    }

    @Override
    public RenderKit getRenderKit(FacesContext context, String renderKitId) {
        RenderKit renderKit = renderKitFactory.getRenderKit(context, renderKitId);
        return (HTML_BASIC_RENDER_KIT.equals(renderKitId)) ? new CustomRenderKit(renderKit) : renderKit;
    }

    @Override
    public Iterator<String> getRenderKitIds() {
        return renderKitFactory.getRenderKitIds();
    }
}
