package book.beans;

import javax.faces.view.facelets.FaceletCache;
import javax.faces.view.facelets.FaceletCacheFactory;

/**
 *
 * @author Leonard
 */
public class CustomFaceletCacheFactory extends FaceletCacheFactory {

    private FaceletCacheFactory faceletCacheFactory;

    public CustomFaceletCacheFactory() {
    }

    public CustomFaceletCacheFactory(FaceletCacheFactory faceletCacheFactory) {
        this.faceletCacheFactory = faceletCacheFactory;
    }

    @Override
    public FaceletCache getFaceletCache() {
        //default FaceletCache
        //FaceletCache<Facelet> faceletCache = faceletCacheFactory.getFaceletCache();
        return new CustomFaceletCache();
    }

    @Override
    public FaceletCacheFactory getWrapped() {
        return this.faceletCacheFactory;
    }
}
