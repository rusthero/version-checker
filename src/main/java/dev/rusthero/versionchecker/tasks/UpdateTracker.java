package dev.rusthero.versionchecker.tasks;

import dev.rusthero.versionchecker.RateLimitExceededException;
import dev.rusthero.versionchecker.ReleaseOrRepoNotFoundException;
import dev.rusthero.versionchecker.Version;
import dev.rusthero.versionchecker.VersionChecker;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * A task that checks for updates using a version checker and notifies a consumer when a new version is available or an
 * exception occurs. This class implements the Runnable interface, it allows instances of it to be run asynchronously.
 */
public class UpdateTracker implements Runnable {
    /**
     * The version checker to use to check for updates.
     */
    private final VersionChecker versionChecker;
    
    /**
     * The version to check for updates.
     */
    private final Version version;

    /**
     * The consumer to call when version is outdated.
     */
    private final Consumer<Version> whenOutdated;

    /**
     * The consumer to call when an exception is encountered during the update check.
     */
    private final Consumer<Exception> whenException;

    /**
     * Constructs a new UpdateTracker object with the given parameters.
     *
     * @param versionChecker The version checker used to get the latest version
     * @param version        The current version of the software
     * @param whenOutdated   The consumer function called when the current version is outdated
     * @param whenException  The consumer function called when an exception occurs
     */
    public UpdateTracker(VersionChecker versionChecker, Version version, Consumer<Version> whenOutdated,
                         Consumer<Exception> whenException) {
        this.version = version;
        this.versionChecker = versionChecker;
        this.whenOutdated = whenOutdated;
        this.whenException = whenException;
    }

    /**
     * The run method that is called when the UpdateTracker object is started. The version checker is used to check
     * for the latest version, and if it is outdated, the whenOutdated consumer function is called to handle the
     * latest version. If an exception occurs while trying to get the latest version, the whenException consumer
     * function is called.
     */
    @Override
    public void run() {
        try {
            versionChecker.ifOutdatedVersion(version, whenOutdated);
        } catch (RateLimitExceededException | ReleaseOrRepoNotFoundException | IOException e) {
            whenException.accept(e);
        }
    }
}
