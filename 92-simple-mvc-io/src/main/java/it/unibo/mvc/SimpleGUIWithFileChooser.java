package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
/**
 * A very simple program using a graphical interface.
 * {@javadoc}
 * This class implements a GUI for managing an application that allows the user to save a string (entered by the user) 
 * into a text file chosen by the user.
 * 
 * @see Controller
 */

public final class SimpleGUIWithFileChooser {
    private static final String BROWSING_BUTTON_TEXT = "Browse...";
    private final SimpleGUI baseGUI = new SimpleGUI();
    /**
     * This constructor instantiates the application view so that it contains a text area and a button that allows you to save 
     * whatever is typed into it.
     */

    public SimpleGUIWithFileChooser() {
        final JPanel browsingPanel = new JPanel();
        final JTextField browseText = new JTextField(baseGUI.getPath());
        final JButton browseButton = new JButton();
        browseButton.setText(BROWSING_BUTTON_TEXT);
        browsingPanel.setLayout(new BorderLayout());
        browsingPanel.add(browseText, BorderLayout.CENTER);
        browsingPanel.add(browseButton, BorderLayout.LINE_END);
        browseText.setEditable(false);
        baseGUI.addToContentPane(browsingPanel, BorderLayout.NORTH);
        /*
        I'm creating an ActionListener that allows the user to select a new file to be used as the output file 
        when they click the save button.
        */
        browseButton.addActionListener(
            e -> {
                final JFileChooser chooseFile = new JFileChooser();
                final int choiceMade = chooseFile.showSaveDialog(browseButton);
                if (choiceMade == JFileChooser.APPROVE_OPTION) {
                    baseGUI.setFile(chooseFile.getSelectedFile());
                    browseText.setText(chooseFile.getSelectedFile().getPath());
                } else if (choiceMade == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(browseButton, "Error Occurred");
                }
            }
        );
    }
    /**
     * Calculate and display the application's graphical user interface on the screen.
     */

    public void display() {
        baseGUI.display();
    }
    /**
     * Starts the application.
     */

    public void main() {
        new SimpleGUIWithFileChooser().display();
    }
}
