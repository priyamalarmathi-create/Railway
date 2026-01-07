package exception;

public class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException() {
        super("No seats available in this train!");
    }
}