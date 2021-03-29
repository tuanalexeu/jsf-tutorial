package book.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class FilesBean implements Serializable {

    ArrayList<String> filesList = new ArrayList<>();

    public FilesBean() {
        filesList.add("files/fileA.xhtml");
        filesList.add("files/fileB.xhtml");
        filesList.add("files/fileC.xhtml");
    }

    public ArrayList<String> getFilesList() {
        return filesList;
    }
}
