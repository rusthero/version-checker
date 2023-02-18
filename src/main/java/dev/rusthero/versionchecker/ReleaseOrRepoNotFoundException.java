package dev.rusthero.versionchecker;

/**
 * Thrown when the latest release or the user/repository cannot be found on GitHub.
 */
public class ReleaseOrRepoNotFoundException extends Exception {

    /**
     * Constructs a new ReleaseOrRepoNotFoundException with the specified detail message.
     *
     * @param message The detail message for the exception.
     */
    public ReleaseOrRepoNotFoundException(String message) {
        super(message);
    }
}
