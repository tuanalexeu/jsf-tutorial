package book.beans;

import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.inject.Inject;

/**
 *
 * @author Leonard
 */
public class CustomApplicationFactory extends ApplicationFactory {

    @Inject
    ValidatorsBean validatorsBean;
    private ApplicationFactory applicationFactory;
    
    public CustomApplicationFactory(){        
    }

    public CustomApplicationFactory(ApplicationFactory applicationFactory) {
        this.applicationFactory = applicationFactory;
    }

    @Override
    public void setApplication(Application application) {
        applicationFactory.setApplication(application);
    }

    @Override
    public Application getApplication() {       
        Application handler = new CustomApplication(applicationFactory.getApplication(), validatorsBean);
        return handler;
    }
}
