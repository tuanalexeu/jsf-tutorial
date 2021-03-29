package book.beans;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class UploadBean {

    private static final Logger logger = Logger.getLogger(UploadBean.class.getName());
    private Part file1;
    private Part file2;
    private String fileInString1;
    private String fileInString2;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }   

    public void upload() {
        try {
            if (file1 != null) {
                Scanner scanner1 = new Scanner(file1.getInputStream(), "UTF-8").useDelimiter("\\A");
                fileInString1 = scanner1.hasNext() ? scanner1.next() : "";
                logger.info(fileInString1);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload successfully ended for file 1!"));
            }
            if (file2 != null) {
                Scanner scanner2 = new Scanner(file2.getInputStream(), "UTF-8").useDelimiter("\\A");
                fileInString2 = scanner2.hasNext() ? scanner2.next() : "";
                logger.info(fileInString2);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload successfully ended for file 2!"));
            }
        } catch (IOException | NoSuchElementException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload failed!"));
        }
    }
}
