package dev.rusthero.versionchecker;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * A generic interface for version checkers, which can be used to check whether the latest version of a software is
 * being used or not. The interface provides methods to get the latest version, check if a given version is the latest
 * version, and run an action if the current version is outdated.
 */
public interface VersionChecker {
    /**
     * Gets the latest version of the software.
     *
     * @return The latest version of the software.
     * @throws RateLimitExceededException     If the REST/API rate limit has been exceeded.
     * @throws ReleaseOrRepoNotFoundException If the repository or release is not found.
     * @throws IOException                    If an I/O error occurs while getting the latest version.
     */
    Version getLatestVersion() throws RateLimitExceededException, ReleaseOrRepoNotFoundException, IOException;

    /**
     * Checks whether a given version is the latest version of the software.
     *
     * @param version The version to check.
     * @return True if the version is the latest version, false otherwise.
     * @throws RateLimitExceededException     If the REST/API rate limit has been exceeded.
     * @throws ReleaseOrRepoNotFoundException If the repository or release is not found.
     * @throws IOException                    If an I/O error occurs while getting the latest version.
     */
    boolean isLatestVersion(Version version) throws RateLimitExceededException, ReleaseOrRepoNotFoundException,
            IOException;

    /**
     * Runs an action if the current version of the software is outdated.
     *
     * @param version               The current version of the software.
     * @param latestVersionConsumer The action to run if the current version is outdated.
     * @throws RateLimitExceededException     If the REST/API rate limit has been exceeded.
     * @throws ReleaseOrRepoNotFoundException If the repository or release is not found.
     * @throws IOException                    If an I/O error occurs while getting the latest version.
     */
    void ifOutdatedVersion(final Version version, final Consumer<Version> latestVersionConsumer)
            throws RateLimitExceededException, ReleaseOrRepoNotFoundException, IOException;
}