package it.unibo.mvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {
    private final Queue<String> history = new LinkedList<>();
    private String stringToPrint;

    @Override 
    public void setNextStringToPrint(final String msg) {
        stringToPrint = String.valueOf(msg);
    }

    @Override
    public String getNextStringToPrint() {
        return String.valueOf(stringToPrint);
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public void printCurrentString() {
        if (stringToPrint == null) {
            throw new IllegalStateException();
        }
        IO.println(stringToPrint);
        history.add(stringToPrint);
        stringToPrint = null;
    }

}
