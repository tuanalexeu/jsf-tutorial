package book.beans;

import java.util.Iterator;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;

/**
 *
 * @author Leonard
 */
public class CustomLifecycleFactory extends LifecycleFactory {

    public static final String CUSTOM_LIFECYCLE_ID = "CustomLifecycle";
    private LifecycleFactory lifecycleFactory;

    public CustomLifecycleFactory(){        
    }
    
    public CustomLifecycleFactory(LifecycleFactory lifecycleFactory) {
        this.lifecycleFactory = lifecycleFactory;
        Lifecycle defaultLifecycle = this.lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
        addLifecycle(CUSTOM_LIFECYCLE_ID, new CustomLifecycle(defaultLifecycle));
    }

    @Override
    public final void addLifecycle(String lifecycleId, Lifecycle lifecycle) {
       lifecycleFactory.addLifecycle(lifecycleId, lifecycle);
    }

    @Override
    public Lifecycle getLifecycle(String lifecycleId) {
        return lifecycleFactory.getLifecycle(lifecycleId);
    }

    @Override
    public Iterator<String> getLifecycleIds() {
        return lifecycleFactory.getLifecycleIds();
    }
}
