package exception;

public class FileException extends RuntimeException{
    public FileException() {
        super();
    }

    public FileException(String message) {
        super(message);
    }
}
