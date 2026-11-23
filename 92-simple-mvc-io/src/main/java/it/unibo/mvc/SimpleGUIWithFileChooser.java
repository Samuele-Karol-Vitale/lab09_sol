package it.unibo.mvc;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 * A very simple program using a graphical interface.
 * {@javadoc}
 * This class implements a GUI for managing an application that allows the user to save a string (entered by the user) into a text file chosen by the user
 * @see Controller
 */
public final class SimpleGUIWithFileChooser {
    //This variable manage the frame's proportion
    private static final int PROPORTION = 3;
    //Default text value for the application frame and button
    private static final String SAVE_BUTTON_TEXT = "Save";
    private static final String BROWSING_BUTTON_TEXT = "Browse...";
    private static final String TITLE = "My first java graphical interface";
    //When the constructor is called we instance a frame for this instance of the application
    private final JFrame frame = new JFrame(TITLE);
    //This is controller saves the strings into its default output file
    private final Controller applicationController = new Controller();
    /**
     * This constructor instantiates the application view so that it contains a text area and a button that allows you to save whatever is typed into it.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel mainPanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton saveButton = new JButton();
        final JPanel browsingPanel = new JPanel();
        final JTextField browseText = new JTextField(applicationController.getPath());
        final JButton browseButton = new JButton();
        browseButton.setText(BROWSING_BUTTON_TEXT);
        saveButton.setText(SAVE_BUTTON_TEXT);
        browsingPanel.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(saveButton, BorderLayout.SOUTH);
        browsingPanel.add(browseText, BorderLayout.CENTER);
        browsingPanel.add(browseButton, BorderLayout.LINE_END);
        browseText.setEditable(false);
        mainPanel.add(browsingPanel, BorderLayout.NORTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //I create an ActionListener to save the string entered in the text field to the file selected by the user
        saveButton.addActionListener(
            e -> {
                try {
                    applicationController.saveStringOnfile(textArea.getText());
                } catch (IOException e1) {
                    IO.println(e1.getMessage());
                }
            }
        );
        //I'm creating an ActionListener that allows the user to select a new file to be used as the output file when they click the save button.
        browseButton.addActionListener(
            e -> {
                JFileChooser chooseFile = new JFileChooser();
                int choiceMade = chooseFile.showSaveDialog(browseButton);
                if(choiceMade == JFileChooser.APPROVE_OPTION) {
                    File newOutputFile = chooseFile.getSelectedFile();
                    applicationController.setFile(newOutputFile);
                    browseText.setText(newOutputFile.getPath());
                } else if(choiceMade == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(browseButton, "Error Occurred");
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
        new SimpleGUIWithFileChooser().display();
    }
}
