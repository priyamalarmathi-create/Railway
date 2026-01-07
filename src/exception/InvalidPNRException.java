package exception;

public class InvalidPNRException extends Exception {
    public InvalidPNRException() {
        super("Invalid PNR number!");
    }
}