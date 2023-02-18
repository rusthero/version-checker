# VersionChecker
VersionChecker is a library which utilizes the GitHub API to check if software is up-to-date. It reads the tag name for the latest release for comparing or other purposes. For detailed information on GitHub API, see the [documentations](https://docs.github.com/en/rest/releases/releases?apiVersion=2022-11-28#get-the-latest-release).

 <a href="https://github.com/rusthero/version-checker/releases">
    <img src="https://img.shields.io/github/release/rusthero/version-checker?height=30&color=D0A384&logo=GitHub&logoColor=white">
 </a>
<a href="https://github.com/rusthero/version-checker/actions?query=workflow%3A%22Gradle Build%22">
    <img src="https://img.shields.io/github/actions/workflow/status/rusthero/version-checker/ci.yml?branch=main&color=BEC5C9&logo=GitHub%20Actions&logoColor=BEC5C9"/>
</a>
<a href="https://codecov.io/gh/rusthero/version-checker" >
    <img src="https://codecov.io/gh/rusthero/version-checker/branch/main/graph/badge.svg?token=QJY7QSO3GC"/>
</a>
<a href="https://www.codefactor.io/repository/github/rusthero/version-checker">
    <img src="https://www.codefactor.io/repository/github/rusthero/version-checker/badge" alt="CodeFactor"/>
</a>
<a href ="https://rusthero.dev/javadocs/version-checker">
  <img src="https://img.shields.io/badge/javadoc-1.0.0-green"/>
</a>
<a href="https://discord.gg/5C6JgvmwUe">
    <img src="https://img.shields.io/discord/1051165269709557813.svg?style=flat&color=7289DA&logo=Discord" alt="Discord"/>
</a>

## Example
We can easily get the version for latest release of this repository `version-checker` owned by me, `rusthero`.
```Java
public static void main(String[] args) throws RateLimitExceededException, ReleaseNotFoundException, IOException {
    GitHubVersionChecker versionChecker = new GitHubVersionChecker("rusthero", "version-checker");
    String version = versionChecker.getLatestVersion();
}
```
There is also a method to compare versions: [GitHubVersionChecker#isLatestVersion(String)](https://rusthero.dev/javadocs/version-checker/dev/rusthero/versionchecker/GitHubVersionChecker.html#isLatestVersion(java.lang.String))

## Artifacts
To use VersionChecker, add my repository and the dependency.
### Gradle
```Gradle
repositories {
    maven {
        url "https://rusthero.dev"
    }
}

dependencies {
    implementation 'dev.rusthero:version-checker:1.0.0'   
}
```
### Maven
```XML
<repositories>
    <repository>
        <id>rusthero</id>
        <url>https://rusthero.dev</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>dev.rusthero</groupId>
        <artifactId>version-checker</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```
#### Manual installation
You can also install VersionChecker manually by downloading it from [releases](https://github.com/rusthero/version-checker/releases) and adding it to your project as a library.

## License
[The MIT License](https://github.com/rusthero/version-checker/blob/main/LICENSE)
