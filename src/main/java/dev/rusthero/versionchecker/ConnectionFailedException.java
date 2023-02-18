package dev.rusthero.versionchecker;

/**
 * This exception is thrown when there is an error establishing a connection to the specified URL. This exception
 * can occur due to a variety of issues, including network errors or problems with the specified URL. The cause of
 * this exception should be inspected to determine the exact cause of the connection failure.
 */
public class ConnectionFailedException extends Exception {
    /**
     * Constructs a new instance of the ConnectionFailedException class with the specified cause.
     *
     * @param cause The cause of the connection failure.
     */
    public ConnectionFailedException(Throwable cause) {
        super(cause);
    }
}
