package it.unibo.mvc;

import java.util.Objects;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 * {@javadoc}
 */

public class Controller {
    /**
     * This constant rappresents a file in the user's home directory that the controller with no argument can manage by deafult.
     */
    public static final String DEFAULT_FILE_NAME = "output.txt";
    private File file;
    /**
     * Creates a {@code Controller} that saves strings in {@code DEFAULT_FILE_NAME}. This file is in the user's home directory.
     */

    public Controller() {
        this(System.getProperty("user.home") 
        + System.getProperty("file.separator") 
        + DEFAULT_FILE_NAME);
    }
    /**
     * Creates a {@code Controller} that sets a specified file as current file.
     * 
     * @param filePath Is the absolute file path to the file
     * 
     * @throws NullPointerException if the argument is null
     */

    public Controller(final String filePath) {
        file = new File(
            Objects.requireNonNull(filePath, "you can't set null as current file")
        );
    }
    /**
     * This method set file as the current file.
     * 
     * @param newOutPutFile This will be the new output file for the Controller
     * 
     * @throws NullPointerException if the argument is null
     */

    public void setFile(final File newOutPutFile) {
        file = Objects.requireNonNull(newOutPutFile, "you can't set null as current file");
    }
    /**
     * This method get the current output file.
     * 
     * @return A defensive copy of the current file
     */

    public File getFile() {
        return new File(file.getPath());
    }
    /**
     * This method get the absolute path of the current output file.
     * 
     * @return The file absolute path to the current file
     */

    public String getPath() {
        return file.getPath();
    }
    /**
     * This method takes a String and saves in the current file.
     * 
     * @param newContent this string will be saved on the current output file
     * 
     * @throws IOException if the output on the file fails
     */

    public void saveStringOnfile(final String newContent) throws IOException {
        try (
            PrintStream writeInFile = new PrintStream(file, StandardCharsets.UTF_8);
        ) {
            writeInFile.println(newContent);
        }
    }
}
