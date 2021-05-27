package ibm.interview.exception;

// The minimum grid allowed to start the game is size 3x3
public class InvalidBoardSizeException extends RuntimeException {

    public InvalidBoardSizeException(String message) {
    }
}
