package book.beans;

import java.io.IOException;
import java.net.URL;
import javax.faces.view.facelets.Facelet;
import javax.faces.view.facelets.FaceletCache;

/**
 *
 * @author Leonard
 */
public class CustomFaceletCache extends FaceletCache<Facelet> {

    public CustomFaceletCache() {
    }

    @Override
    public Facelet getFacelet(URL url) throws IOException {
        System.out.println("Creating facelet: " + url.toString());
        MemberFactory<Facelet> memberFactory = getMemberFactory();
        Facelet facelet = memberFactory.newInstance(url);

        return facelet;
    }

    @Override
    public boolean isFaceletCached(URL url) {
        return false;
    }

    @Override
    public Facelet getViewMetadataFacelet(URL url) throws IOException {
        System.out.println("Creating metadata facelet: " + url.toString());
        MemberFactory<Facelet> metadataMemberFactory = getMetadataMemberFactory();
        Facelet facelet = metadataMemberFactory.newInstance(url);

        return facelet;

    }

    @Override
    public boolean isViewMetadataFaceletCached(URL url) {
        return false;
    }

    public FaceletCache<Facelet> getWrapped() {
        return this;
    }
}
