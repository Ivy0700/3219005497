package exception;

public class FileWrongFormatException extends FileException{

    public FileWrongFormatException() {
    }

    public FileWrongFormatException(String message) {
        super(message);
    }
}
