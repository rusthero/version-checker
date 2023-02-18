package dev.rusthero.versionchecker;

import com.google.gson.JsonParseException;

/**
 * An exception that is thrown when the GitHub API returns a response with an invalid format that
 * cannot be parsed as JSON.
 */
public class InvalidFormatException extends Exception {
    /**
     * Constructs a new InvalidFormatException with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause   The cause of the exception.
     */
    public InvalidFormatException(String message, JsonParseException cause) {
        super(message, cause);
    }
}
