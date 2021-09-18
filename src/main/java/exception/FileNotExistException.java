package exception;

public class FileNotExistException extends FileException{

    public FileNotExistException(){

    }

    public FileNotExistException(String message) {
        super(message);
    }
}
