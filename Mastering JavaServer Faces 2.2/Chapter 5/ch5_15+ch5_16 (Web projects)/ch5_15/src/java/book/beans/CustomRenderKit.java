package book.beans;

import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitWrapper;
import javax.faces.render.Renderer;

/**
 *
 * @author Leonard
 */
public class CustomRenderKit extends RenderKitWrapper {

    private RenderKit renderKit;

    public CustomRenderKit() {
    }

    public CustomRenderKit(RenderKit renderKit) {
        this.renderKit = renderKit;
    }

    @Override
    public Renderer getRenderer(String family, String rendererType) {

        if (family.equals("javax.faces.Input")) {            
            Renderer inputRenderer = getWrapped().getRenderer(family, rendererType);
            return new RafaRenderer(inputRenderer);
        }
        return getWrapped().getRenderer(family, rendererType);
    }

    @Override
    public RenderKit getWrapped() {
        return renderKit;
    }
}
