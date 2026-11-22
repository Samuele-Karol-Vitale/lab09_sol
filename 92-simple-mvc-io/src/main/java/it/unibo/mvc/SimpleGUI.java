package it.unibo.mvc;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * A very simple program using a graphical interface.
 * {@javadoc}
 * This class implements a GUI for managing an application that allows the user to save a string (entered by the user) into a text file
 * The String is saved into the default file specified into {@code Controller} documentation
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
    private final Controller deafultController = new Controller();
    /**
     * This constructor instantiates the application view so that it contains a text area and a button that allows you to save whatever is typed into it.
     */
    public SimpleGUI() {
        final JPanel simplePanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton saveButton = new JButton();
        saveButton.setText(SAVE_BUTTON_TEXT);
        simplePanel.setLayout(new BorderLayout());
        simplePanel.add(textArea, BorderLayout.CENTER);
        simplePanel.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(simplePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //i create a lambda function to create an ActionListener
        saveButton.addActionListener(
            e -> {
                try {
                    deafultController.appendString(textArea.getText());
                } catch (IOException e1) {
                    IO.println(e1.getMessage());
                }
            }
        );
    }
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public void main() {
        new SimpleGUI().display();
    }
}
