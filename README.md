<h1 align="center">
    <img src="https://user-images.githubusercontent.com/120267985/220111469-ba5b7bcb-6791-4f2e-b25f-f5523d6512f3.png" width=50%/>
    <br>
    Version Checker   
</h1>

<h4 align="center">
    Java library to check if software is up-to-date or outdated via GitHub API.          
</h2>

<p align="center">
    <a href="https://github.com/rusthero/version-checker/releases">
        <img src="https://img.shields.io/github/release/rusthero/version-checker?height=30&color=B0A384&logo=GitHub&logoColor=white">
    </a>
    <a href="https://opensource.org/licenses/MIT)">
        <img src="https://img.shields.io/badge/License-MIT-yellow.svg"/>
    </a>     
    <a href="https://rusthero.dev/javadocs/version-checker/1.1.0">
        <img src="https://img.shields.io/badge/javadoc-v1.1.0-green"/>
    </a>
    <a href="https://codecov.io/gh/rusthero/version-checker">
        <img src="https://codecov.io/gh/rusthero/version-checker/branch/main/graph/badge.svg?token=QJY7QSO3GC"/>
    </a>
    <a href="https://sonarcloud.io/summary/new_code?id=rusthero_version-checker">
        <img src="https://sonarcloud.io/api/project_badges/measure?project=rusthero_version-checker&metric=reliability_rating"/>
    </a>
    <a href="https://sonarcloud.io/summary/new_code?id=rusthero_version-checker">
        <img src="https://sonarcloud.io/api/project_badges/measure?project=rusthero_version-checker&metric=security_rating"/>
    </a>
    <a href="https://sonarcloud.io/summary/new_code?id=rusthero_version-checker">
        <img src="https://sonarcloud.io/api/project_badges/measure?project=rusthero_version-checker&metric=sqale_rating"/>
    </a>
    <a href="https://sonarcloud.io/summary/new_code?id=rusthero_version-checker">
        <img src="https://sonarcloud.io/api/project_badges/measure?project=rusthero_version-checker&metric=bugs"/>
    </a>
        <a href="https://sonarcloud.io/summary/new_code?id=rusthero_version-checker">
        <img src="https://sonarcloud.io/api/project_badges/measure?project=rusthero_version-checker&metric=vulnerabilities"/>
    </a>
    </a>
        <a href="https://sonarcloud.io/summary/new_code?id=rusthero_version-checker">
        <img src="https://sonarcloud.io/api/project_badges/measure?project=rusthero_version-checker&metric=code_smells"/>
    </a>
    </a>
        <a href="https://sonarcloud.io/summary/new_code?id=rusthero_version-checker">
        <img src="https://sonarcloud.io/api/project_badges/measure?project=rusthero_version-checker&metric=duplicated_lines_density"/>
    </a>
    <a href="https://discord.gg/5C6JgvmwUe">
        <img src="https://img.shields.io/discord/1051165269709557813.svg?style=flat&color=7289DA&logo=Discord" alt="Discord"/>
    </a>
</p>  

<br>

## Example
We can easily get the version for latest release of this repository `version-checker` owned by me, `rusthero`.
```Java
public static void main(String[] args) throws IOException, ReleaseOrRepoNotFoundException, RateLimitExceededException {
    GitHubVersionChecker versionChecker = new GitHubVersionChecker("rusthero", "version-checker");
    Version currentVersion = new Version("1.1.0");    
    
    versionChecker.ifOutdatedVersion(currentVersion, version -> System.out.println("README file is outdated!"));
}
```
Check [tests](https://github.com/rusthero/version-checker/tree/main/src/test/java/dev/rusthero/versionchecker) or [JavaDoc](https://rusthero.dev/javadocs/version-checker/1.1.0) for more information on how to use Version Checker.

## Artifacts
To use Version Checker, add my repository and the dependency.
### Gradle
```Gradle
repositories {
    mavenCentral()
    maven {
        url "https://rusthero.dev"
    }
}

dependencies {
    implementation 'dev.rusthero:version-checker:1.1.0'   
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
        <version>1.1.0</version>
    </dependency>
</dependencies>
```
#### Manual installation
You can also install VersionChecker manually by downloading it from [releases](https://github.com/rusthero/version-checker/releases) and adding it to your project.
