package gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if(f.isDirectory()) {
            return true;
        }

        String extension = Utils.getFileExtenstion(f.getName());
        return ((extension != null) && extension.equals("per"));
    }

    @Override
    public String getDescription() {
        return "Person database files (*.per)";
    }
}
