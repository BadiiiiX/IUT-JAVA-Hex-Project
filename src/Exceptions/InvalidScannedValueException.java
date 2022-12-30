package Exceptions;

public class InvalidScannedValueException extends Exception {

    public InvalidScannedValueException(String message) {
        super(message);
    }

    public InvalidScannedValueException() {
        super();
    }

}
