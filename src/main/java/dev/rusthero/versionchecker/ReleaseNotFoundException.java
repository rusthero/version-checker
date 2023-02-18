package dev.rusthero.versionchecker;

/**
 * Thrown when the latest release or the user/repository cannot be found on GitHub.
 */
public class ReleaseNotFoundException extends Exception {

    /**
     * Constructs a new ReleaseNotFoundException with the specified detail message.
     *
     * @param message The detail message for the exception.
     */
    public ReleaseNotFoundException(String message) {
        super(message);
    }
}
