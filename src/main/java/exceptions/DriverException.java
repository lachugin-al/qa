package exceptions;

public class DriverException extends Error {

    public DriverException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverException(String message) {
        super(message);
    }

    public DriverException(Throwable cause) {
        super(cause);
    }

}
