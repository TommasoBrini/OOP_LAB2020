package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 
 */
public class Controller {

    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator") + "Desktop"
            + System.getProperty("file.separator")
            + "output.txt";

    private File currentFile = new File(PATH);
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     */

    public final void setCurrentFile(final File file) {
        if (file.getParentFile().exists()) {
            this.currentFile = file;
        } else {
            throw new IllegalArgumentException("Not existing Path");
        }
    }

    /* 
     * 2) A method for getting the current File
     */

    public final File getCurrentFile() {
        return this.currentFile;
    }

    /* 
     * 3) A method for getting the path (in form of String) of the current File
     */

    public final String getPath() {
        return this.currentFile.getPath();
    }

    /* 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     */ 

    public final void save(final String text) throws IOException {
        try (PrintStream out = new PrintStream(currentFile)) {
            out.println(text);
        }
    }

     /* 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

}
