package it.unibo.mvc;
import java.util.Objects;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 * {@javadoc}
 * This class implements a simple controller responsible of I/O access.
 */
public class Controller {
    //this constant rappresents the file that the controller can manage by deafult
    static public String DEFAULT_FILE_NAME = "output.txt";
    File file;
    /**
     * this constructor create a {@code Controller} that by deafult set as current file {@value DEFAULT_FILE_NAME}
     * @throws NullPointerException
     */
    public Controller() {
        this(System.getProperty("user.home") + 
            System.getProperty("file.separator") + DEFAULT_FILE_NAME);
    }
    /**
     * this constructor create a {@code Controller} that set a specified file as current file
     * @throws NullPointerException
     */
    public Controller(String filePath) {
        file = new File(
            Objects.requireNonNull(filePath, "you can't set null as current file"));
    }
    /**
     * this method set file as the current file
     * @param file
     */
    public void setFile(File file) {
        file = Objects.requireNonNull(file, "you can't set null as current file");
    }
    /**
     * @return a defensive copy of the current file
     */
    public File getFile() {
        return new File(file.getPath());
    }
    /**
     * @return the file path to the current file
     */
    public String getPath() {
        return file.getPath();
    }
    /**
     * this method takes a String and it appends at the current file
     * @param newContent
     * @throws IOException
     */
    public void appendString(String newContent) throws IOException {
        try (
            final DataOutputStream writeInFile = new DataOutputStream(
                new FileOutputStream(file,true)
            )
        ) {
            writeInFile.writeUTF(newContent);
        }
    }
}
