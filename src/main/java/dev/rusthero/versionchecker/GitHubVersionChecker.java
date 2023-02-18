package dev.rusthero.versionchecker;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

/**
 * A class that uses the GitHub API to check for the latest version of a specified repository. This class can be used
 * to determine whether a program is running on the latest version of the repository, and to retrieve information about
 * the latest version.
 */
public class GitHubVersionChecker {
    /**
     * The URL endpoint used by the GitHubVersionChecker instance to retrieve the latest version information from the
     * GitHub API. This URL is constructed using the owner and repo values provided in the constructor.
     */
    private final URL endpoint;

    /**
     * Constructs a new instance of the GitHubVersionChecker class, which uses the GitHub API to check
     * for the latest version of a specified repository. The constructor constructs the endpoint URL
     * using the provided owner and repo values.
     *
     * @param owner The name of the owner of the repository to check.
     * @param repo  The name of the repository to check.
     * @throws MalformedURLException If the constructed endpoint URL is not a valid URL.
     */
    public GitHubVersionChecker(String owner, String repo) throws MalformedURLException {
        endpoint = new URL(format("https://api.github.com/repos/%s/%s/releases/latest", owner, repo));
    }

    /**
     * Returns the latest version of the repository according to the GitHub API. This method sends an HTTP
     * request to the GitHub API endpoint and retrieves the latest version information, which is returned
     * as a string. Removes the prefix `v` if the tag name starts with one.
     *
     * @return The latest version of the repository as a string.
     * @throws RuntimeException If there is an error retrieving the latest version from the GitHub API.
     */
    public String getLatestVersion() throws ConnectionFailedException, ReleaseNotFoundException,
            InvalidFormatException {
        try {
            HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
            int responseCode = conn.getResponseCode();

            if (responseCode == 404) {
                throw new ReleaseNotFoundException(
                        format("The specified repository is not found at %s", endpoint)
                );
            }

            // This try-with-resources closes the AutoCloseable reader.
            try (BufferedReader buf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                JsonElement json = JsonParser.parseReader(buf);

                String tagName = json.getAsJsonObject().get("tag_name").getAsString();
                // Prefix `v` is used on a lot of repos as a version tag prefix. It must be removed to prevent
                // confusions when comparing versions.
                return tagName.startsWith("v") ? tagName.substring(1) : tagName;
            }
        } catch (IOException e) {
            throw new ConnectionFailedException(e);
        } catch (JsonParseException e) {
            throw new InvalidFormatException("Error parsing JSON response from GitHub API", e);
        }
    }

    /**
     * Determines whether the specified version string matches the latest version of the repository
     * according to the GitHub API. Returns true if the specified version matches the latest version,
     * and false otherwise.
     *
     * @param version The version string to compare with the latest version. It is `v` prefix-insensitive.
     * @return true if the specified version matches the latest version, and false otherwise.
     * @throws RuntimeException If there is an error retrieving the latest version from the GitHub API.
     */
    public boolean isLatestVersion(String version)
            throws ConnectionFailedException, ReleaseNotFoundException, InvalidFormatException {
        // Some may put `v` prefix so remove it just in case.
        return (version.startsWith("v") ? version.substring(1) : version).equals(getLatestVersion());
    }
}