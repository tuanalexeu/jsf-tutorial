package book.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Leonard
 */
@ManagedBean(name = "uploadBean")
@SessionScoped
public class UploadBean implements Serializable {

    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void validateFile() {
        //VALIDATE FILE NAME LENGTH
        String name = file.getSubmittedFileName();
        if (name.length() == 0) {
            resetFile();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload Error: Cannot determine the file name !"));
        } else if (name.length() > 25) {
            resetFile();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload Error: The file name is to long !"));
        } else //VALIDATE FILE CONTENT TYPE
        if ((!"image/png".equals(file.getContentType())) && (!"image/jpeg".equals(file.getContentType()))) {
            resetFile();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload Error: Only images can be uploaded (PNGs and JPGs) !"));
        } else //VALIDATE FILE SIZE (not bigger than 1 MB)        
        if (file.getSize() > 1048576) {
            resetFile();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload Error: Cannot upload files larger than 1 MB !"));
        }
    }

    public void saveFileToDisk() {

        if (file != null) {
            try (InputStream inputStream = file.getInputStream(); FileOutputStream outputStream = new FileOutputStream("D:" + File.separator + "files" + File.separator + file.getSubmittedFileName())) {

                int bytesRead;
                final byte[] chunck = new byte[1024];
                while ((bytesRead = inputStream.read(chunck)) != -1) {
                    outputStream.write(chunck, 0, bytesRead);
                }

                resetFile();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload successfully ended!"));
            } catch (IOException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Upload failed!"));
            }
        }
    }

    public void resetFile() {
        try {
            if (file != null) {
                file.delete();
            }
        } catch (IOException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        file = null;
    }
}
