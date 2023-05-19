package it.unibo.oop.lab.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class ControllerImpl implements Controller {

    private final List<String> history = new LinkedList<>();
    private String nextString;

    @Override
    public void setNextStringToPrint(final String string) {
        this.nextString = Objects.requireNonNull(string, "This method doesn't accept null values");
    }

    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }

    @Override
    public List<String> getHistoryOfPrintedStrings() {
        return history;
    }

    @Override
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("The next string is null");
        }
        System.out.println(nextString);
        history.add(nextString);
    }

}
