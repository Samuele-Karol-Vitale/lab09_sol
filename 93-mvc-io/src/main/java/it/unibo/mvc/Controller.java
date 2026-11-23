package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */

public interface Controller {
    /**
     * This method set the next string to print on the standard output.
     * 
     * @param msg string to print
     * 
     * @throws NullPointerException if msg is null
     */

    void setNextStringToPrint(String msg);

    /**
     * This method get the next string to print on the standard output.
     * 
     * @return get the next string to print
     */

    String getNextStringToPrint();
    /**
     * This method get the history of the printed strings on the standard output.
     * 
     * @return the history in a form of List<String>
     */

    List<String> getHistory();
    /**
     * This method prints on the standard output the current string.
     * 
     * @throws IllegalStateException the current string is unset
     */

    void printCurrentString();
}
