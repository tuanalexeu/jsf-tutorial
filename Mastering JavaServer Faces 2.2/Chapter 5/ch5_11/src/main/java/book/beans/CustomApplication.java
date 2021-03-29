package book.beans;

import java.util.Iterator;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.application.ApplicationWrapper;

/**
 *
 * @author Leonard
 */
public class CustomApplication extends ApplicationWrapper {

    private Application application;
    private ValidatorsBean validatorsBean;

    public CustomApplication(Application application, ValidatorsBean validatorsBean) {
        this.application = application;
        this.validatorsBean = validatorsBean;
    }

    @Override
    public Application getWrapped() {
        return application;
    }

    @Override
    public void addValidator(java.lang.String validatorId, java.lang.String validatorClass) {

        boolean flag;
        for (Map.Entry pairs : validatorsBean.getValidators().entrySet()) {
            flag = false;
            Iterator i = getWrapped().getValidatorIds();
            while (i.hasNext()) {
                if (i.next().equals(pairs.getKey())) {
                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                getWrapped().addValidator(pairs.getKey().toString(), pairs.getValue().toString());
            }
        }

        getWrapped().addValidator(validatorId, validatorClass);
    }
}