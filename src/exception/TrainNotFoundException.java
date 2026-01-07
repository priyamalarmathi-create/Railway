package exception;

public class TrainNotFoundException extends Exception {
    public TrainNotFoundException() {
        super("Train not found!");
    }
}