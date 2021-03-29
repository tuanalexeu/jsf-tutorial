package book.beans;

import java.util.Map;
import javax.faces.context.FacesContext;
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
        Map<String, String> getRequestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap();
        String userAgent = getRequestMap.get("User-Agent");
        String httpAccept = getRequestMap.get("Accept");

        if (rendererType.equals(TempConvertDefaultRenderer.RENDERER_TYPE)) {
            UAgentInfo detector = new UAgentInfo(userAgent, httpAccept);

            if (detector.isMobilePhone) {
                if ((detector.detectSmartphone())) {
                    // System.out.println("SMARTPHONE THEME!");
                    return getWrapped().getRenderer(family, TempConvert480Renderer.RENDERER_TYPE);
                } else {
                    // System.out.println("SIMPLE MOBILE THEME!");
                    return getWrapped().getRenderer(family, TempConvert320Renderer.RENDERER_TYPE);
                }
            } else {
                if (detector.detectTierTablet()) {
                    // System.out.println("TABLET THEME!");
                    return getWrapped().getRenderer(family, TempConvert640Renderer.RENDERER_TYPE);
                } else {
                    // System.out.println("BROWSER THEME!");
                }
            }
        }

        return getWrapped().getRenderer(family, rendererType);
    }

    @Override
    public RenderKit getWrapped() {
        return renderKit;
    }
}
