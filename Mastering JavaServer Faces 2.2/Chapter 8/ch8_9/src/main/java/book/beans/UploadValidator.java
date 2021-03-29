package book.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author Leonard
 */
@FacesValidator
public class UploadValidator implements Validator {

    private static final Logger logger = Logger.getLogger(UploadValidator.class.getName());

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        Part file = (Part) value;

        //VALIDATE FILE NAME LENGTH
        String name = file.getSubmittedFileName();
        logger.log(Level.INFO, "VALIDATING FILE NAME: {0}", name);
        if (name.length() == 0) {
            FacesMessage message = new FacesMessage("Upload Error: Cannot determine the file name !");
            throw new ValidatorException(message);
        } else if (name.length() > 25) {
            FacesMessage message = new FacesMessage("Upload Error: The file name is to long !");
            throw new ValidatorException(message);
        }

        //VALIDATE FILE CONTENT TYPE
        if ((!"image/png".equals(file.getContentType())) && (!"image/jpeg".equals(file.getContentType()))) {
            FacesMessage message = new FacesMessage("Upload Error: Only images can be uploaded (PNGs and JPGs) !");
            throw new ValidatorException(message);
        }

        //VALIDATE FILE SIZE (not bigger than 1 MB)
        if (file.getSize() > 1048576) {
            FacesMessage message = new FacesMessage("Upload Error: Cannot upload files larger than 1 MB !");
            throw new ValidatorException(message);
        }
    }
}
