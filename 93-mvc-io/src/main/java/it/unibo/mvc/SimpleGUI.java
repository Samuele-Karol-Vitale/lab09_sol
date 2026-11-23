package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 *
 */

public final class SimpleGUI {
    private static final int PROPORTION = 3;
    private static final String PRINT_BUTTON_TEXT = "Print";
    private static final String HISTORY_BUTTON_TEXT = "show history";
    private final JFrame frame = new JFrame();
    private final Controller applicationController = new SimpleController();
    /**
     * This constructor sets up the view of the application.
     */

    public SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        final JPanel buttonPanel = new JPanel();
        final JTextArea printArea = new JTextArea();
        final JTextField inputTextField = new JTextField();
        final JButton printButton = new JButton(PRINT_BUTTON_TEXT);
        final JButton historyButton = new JButton(HISTORY_BUTTON_TEXT);
        mainPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new BorderLayout());
        mainPanel.add(inputTextField, BorderLayout.NORTH);
        mainPanel.add(printArea, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(printButton, BorderLayout.LINE_END);
        buttonPanel.add(historyButton, BorderLayout.LINE_START);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printButton.addActionListener(e -> {
                applicationController.setNextStringToPrint(inputTextField.getText());
                applicationController.printCurrentString();
            }
        );
        historyButton.addActionListener(e -> {
                for (final var msg:applicationController.getHistory()) {
                    printArea.append(msg + "\n");
                }
            }
        );
    }
    /**
     * This method calculates and then displays the application's GUI on the screen.
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
     * This method starts the application.
     */

    public void main() {
        new SimpleGUI().display();
    }
}
