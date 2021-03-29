package book.beans;

import com.sun.faces.util.MessageUtils;
import com.sun.faces.util.Util;
import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.PropertyNotFoundException;
import javax.el.PropertyNotWritableException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
public class ELContextResolver extends ELResolver {

    private static final Logger logger = Logger.getLogger(ELContextResolver.class.getName());
    private static final String EL_CONTEXT_NAME = "elContext";

    @Override
    public Class<?> getCommonPropertyType(ELContext ctx, Object base) {
        if (base != null) {
            return null;
        }
        return String.class;
    }

    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext ctx, Object base) {
        if (base != null) {
            return null;
        }
        ArrayList<FeatureDescriptor> list = new ArrayList<>(1);
        list.add(Util.getFeatureDescriptor("elContext", "elContext",
                "elContext", false, false, true, ELContext.class, Boolean.TRUE));

        return list.iterator();
    }

    @Override
    public Class<?> getType(ELContext ctx, Object base, Object property) {
        if (base != null) {
            return null;
        }
        if (property == null) {
            String message = MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "property");
            throw new PropertyNotFoundException(message);
        }
        if ((base == null) && property.equals(EL_CONTEXT_NAME)) {
            ctx.setPropertyResolved(true);
        }
        return null;
    }

    @Override
    public Object getValue(ELContext ctx, Object base, Object property) {

        logger.log(Level.INFO, "Get Value property : {0}", property);

        if ((base == null) && property.equals(EL_CONTEXT_NAME)) {
            logger.log(Level.INFO, "Found request {0}", base);
            ctx.setPropertyResolved(true);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            return facesContext.getELContext();
        }
        return null;
    }

    @Override
    public boolean isReadOnly(ELContext ctx, Object base, Object property) {
        if (base != null) {
            return false;
        }
        if (property == null) {
            String message = MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "property");
            throw new PropertyNotFoundException(message);
        }
        if (EL_CONTEXT_NAME.equals(property)) {
            ctx.setPropertyResolved(true);
            return true;
        }
        return false;
    }

    @Override
    public void setValue(ELContext ctx, Object base, Object property, Object value) {
        if (base != null) {
            return;
        }
        ctx.setPropertyResolved(false);
        if (property == null) {
            String message = MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "property");
            throw new PropertyNotFoundException(message);
        }
        if (EL_CONTEXT_NAME.equals(property)) {
            throw new PropertyNotWritableException((String) property);
        }
    }
}
