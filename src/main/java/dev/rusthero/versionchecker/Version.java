package dev.rusthero.versionchecker;

/**
 * A class representing a version of a software product, which is typically represented as a string. Instances of this
 * class are created with a string argument that represents a version number. The version string is normalized to
 * remove any prefix 'v' in order to make comparisons between different versions consistent.
 */
public final class Version {
    /**
     * The string that represents the version number of this instance of the Version class. This string is normalized
     * by removing any 'v' prefix and lowered case.
     */
    private final String tagName;

    /**
     * Constructs a new instance of the Version class with a version string argument. The version string is normalized
     * by removing any prefix 'v'.
     *
     * @param tagName The version string that this instance of the Version class represents.
     */
    public Version(final String tagName) {
        // Prefix `v` is used on a lot of repos as a version tag prefix. It must be removed to prevent confusions
        // when comparing versions. Also lowered case for consistency.
        this.tagName = (tagName.startsWith("v") ? tagName.substring(1) : tagName).toLowerCase();
    }

    /**
     * Returns a string representation of the Version instance, which is the normalized version string that it was
     * created with.
     *
     * @return A string representation of the Version instance, which is the normalized version string that it was
     * created with.
     */
    @Override
    public String toString() {
        return tagName;
    }

    /**
     * Determines whether the specified object is equal to this instance of the Version class. Two instances of the
     * Version class are considered equal if they have the same version string after normalization.
     *
     * @param obj The object to compare to this instance of the Version class.
     * @return True if the specified object is equal to this instance of the Version class, false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Version)) return false;

        String inputTagName = ((Version) obj).tagName;
        return tagName.equals(inputTagName);
    }


    /**
     * Returns a hash code value for the Version object, based on the hash code of its tag name.
     *
     * @return A hash code value for this Version object.
     */
    @Override
    public int hashCode() {
        return tagName.hashCode();
    }
}
