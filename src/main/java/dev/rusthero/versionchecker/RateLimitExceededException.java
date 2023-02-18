package dev.rusthero.versionchecker;

/**
 * Exception indicating that the rate limit for a GitHub API endpoint has been exceeded.
 */
public class RateLimitExceededException extends Exception {
    /**
     * Constructs a new RateLimitException with the specified detail message.
     *
     * @param message The detail message for the exception.
     */
    public RateLimitExceededException(String message) {
        super(message);
    }
}
