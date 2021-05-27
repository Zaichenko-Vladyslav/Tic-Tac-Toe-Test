package ibm.interview.exception;

// The gameplay must take place in a clearly designated place
public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException(String message) {
        super(message);
    }
}
