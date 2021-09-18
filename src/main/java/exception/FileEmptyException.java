package exception;

public class FileEmptyException extends FileException{

    public FileEmptyException() {
    }

    public FileEmptyException(String message) {
        super(message);
    }
}
