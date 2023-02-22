package dev.rusthero.versionchecker.tasks;

import dev.rusthero.versionchecker.GitHubVersionChecker;
import dev.rusthero.versionchecker.Version;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.fail;

class UpdateTrackerTest {
    @Test
    void runWhenOutdated() throws MalformedURLException {
        // This repository has a version with v0.1.0 tag name.
        GitHubVersionChecker versionChecker = new GitHubVersionChecker("rusthero", "rusthero");
        Version version = new Version("0.0.0");

        AtomicBoolean isOutdated = new AtomicBoolean(false);
        AtomicBoolean isException = new AtomicBoolean(false);
        UpdateTracker updateTracker = new UpdateTracker(versionChecker, version,
                                                        latestVersion -> isOutdated.set(true),
                                                        exception -> isException.set(true));
        updateTracker.run();
        if (!isOutdated.get() || isException.get()) fail();
    }

    @Test
    void runWhenUpToDate() throws MalformedURLException {
        // This repository has a version with v0.1.0 tag name.
        GitHubVersionChecker versionChecker = new GitHubVersionChecker("rusthero", "rusthero");
        Version version = new Version("0.1.0");

        AtomicBoolean isOutdated = new AtomicBoolean(false);
        AtomicBoolean isException = new AtomicBoolean(false);
        UpdateTracker updateTracker = new UpdateTracker(versionChecker, version,
                                                        latestVersion -> isOutdated.set(true),
                                                        exception -> isException.set(true));
        updateTracker.run();
        if (isOutdated.get() || isException.get()) fail();
    }
}
