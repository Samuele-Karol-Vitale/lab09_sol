package it.unibo.mvc;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * A very simple program using a graphical interface.
 * {@javadoc}
 * This class implements a GUI for managing an application that allows the user to save a string (entered by the user) 
 * into a text file.
 * The String is saved into the default file specified into {@code Controller} documentation.
 * 
 * @see Controller
 */

public final class SimpleGUI {
    //This variable manage the frame's proportion
    private static final int PROPORTION = 3;
    //Default text value for the application frame and button
    private static final String SAVE_BUTTON_TEXT = "Save";
    private static final String TITLE = "My first java graphical interface";
    //When the constructor is called we instance a frame for this instance of the application
    private final JFrame frame = new JFrame(TITLE);
    //This is controller saves the strings into its default output file
    private final Controller applicationController = new Controller();
    /**
     * This constructor instantiates the application view so that it contains a text area and a button that allows you 
     * to save whatever is typed into it.
     */

    public SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton saveButton = new JButton();
        saveButton.setText(SAVE_BUTTON_TEXT);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //i create a lambda function to create an ActionListener
        saveButton.addActionListener(
            e -> {
                try {
                    applicationController.saveStringOnfile(textArea.getText());
                } catch (final IOException ex) {
                    IO.println(ex.getMessage());
                }
            }
        );
    }
    /**
     * This method allows to change the output file, but by default this application doesn't use it.
     * 
     * @param newOutputFile is the output file to use
     */

    public void setFile(final File newOutputFile) {
        applicationController.setFile(newOutputFile);
    }
    /**
     * This method gets the absolute path to the output file.
     * 
     * @return  the absolute path to the output file
     */

    public String getPath() {
        return applicationController.getPath();
    }
    /**
     * This method allows to add a Jcomponent with a constrain to the content pane.
     * 
     * @param comp JComponent to add in the content pane
     * 
     * @param constrain layout constraintsfor this component
     */

    public void addToContentPane(final JComponent comp, final Object constrain) {
        frame.getContentPane().add(frame, constrain);
    }
    /**
     * Calculate and display the application's graphical user interface on the screen.
     */

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    /**
     * Starts the application.
     */

    public void main() {
        new SimpleGUI().display();
    }
}
