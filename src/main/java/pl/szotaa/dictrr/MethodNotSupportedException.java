package pl.szotaa.dictrr;

public class MethodNotSupportedException extends RuntimeException {

    private static final String MESSAGE = "Method not supported";

    public MethodNotSupportedException() {
        super(MESSAGE);
    }
}
