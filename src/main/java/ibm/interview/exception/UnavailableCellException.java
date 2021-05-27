package ibm.interview.exception;

// There is only one value per cell that is not available for overwriting
public class UnavailableCellException extends RuntimeException {

    public UnavailableCellException(String message) {
        super(message);
    }
}
