import dev.rusthero.versionchecker.GitHubVersionChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GitHubVersionCheckerTest {
    @Test
    public void testGetLatestVersion() throws Exception {
        GitHubVersionChecker checker = new GitHubVersionChecker("rusthero", "rusthero");

        assertEquals("0.1.0", checker.getLatestVersion());
    }

    @Test
    public void testIsLatestVersion() throws Exception {
        GitHubVersionChecker checker = new GitHubVersionChecker("rusthero", "rusthero");

        assertTrue(checker.isLatestVersion("v0.1.0"));
        assertTrue(checker.isLatestVersion("0.1.0"));
    }
}