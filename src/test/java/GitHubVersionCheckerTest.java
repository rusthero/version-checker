import dev.rusthero.versionchecker.GitHubVersionChecker;
import dev.rusthero.versionchecker.RateLimitExceededException;
import dev.rusthero.versionchecker.ReleaseOrRepoNotFoundException;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GitHubVersionCheckerTest {
    @Test
    public void getLatestVersionFromValidEndpoint() throws Exception {
        // This repository has a version with v1.0.0 tag
        GitHubVersionChecker checker = new GitHubVersionChecker("rusthero", "version-with-v-prefix");
        assertEquals("1.0.0", checker.getLatestVersion());

        // This repository has a version with 1.0.0 tag
        checker = new GitHubVersionChecker("rusthero", "version-without-v-prefix");
        assertEquals("1.0.0", checker.getLatestVersion());
    }

    @Test
    public void getLatestVersionFromInvalidEndpoint() throws Exception {
        GitHubVersionChecker checker = new GitHubVersionChecker("rusthero", "this-repo-does-not-exist");
        assertThrows(ReleaseOrRepoNotFoundException.class, checker::getLatestVersion);

        // Usernames on GitHub cannot be longer than 39 characters so this username cannot exist
        String impossibleUsername = "a".repeat(48);
        checker = new GitHubVersionChecker(impossibleUsername, "this-repo-does-not-exist");
        assertThrows(ReleaseOrRepoNotFoundException.class, checker::getLatestVersion);
    }

    @Test
    public void getLatestVersionWith403StatusCode() throws Exception {
        HttpURLConnection mockConn = mock(HttpURLConnection.class);
        when(mockConn.getResponseCode()).thenReturn(403);

        URL mockUrl = mock(URL.class);
        when(mockUrl.openConnection()).thenReturn(mockConn);

        GitHubVersionChecker checker = new GitHubVersionChecker(mockUrl);

        assertThrows(RateLimitExceededException.class, checker::getLatestVersion);
    }

    @Test
    public void testIsLatestVersion() throws Exception {
        GitHubVersionChecker checker = new GitHubVersionChecker("rusthero", "version-with-v-prefix");

        assertTrue(checker.isLatestVersion("v1.0.0"));
        assertTrue(checker.isLatestVersion("1.0.0"));
    }
}