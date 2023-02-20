package dev.rusthero.versionchecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VersionTest {
    @Test
    public void equals() {
        assertEquals((new Version("1.0.0")), new Version("1.0.0"));
        assertEquals((new Version("1.0.0")), new Version("v1.0.0"));
        assertEquals((new Version("1.0.0-Alpha")), new Version("1.0.0-ALPHA"));
        assertEquals((new Version("1.0.0-alpha")), new Version("v1.0.0-ALPHA"));
        assertEquals((new Version("1.0.0-alpha")), new Version("1.0.0-alpha"));
        assertEquals((new Version("1.0.0-alpha")), new Version("v1.0.0-alpha"));

        assertNotEquals(new Version("1.0.0"), new Version("0.9.0"));
        assertNotEquals(new Version("1.0.0"), new Version("v0.9.0"));
        assertNotEquals(new Version("1.0.0"), new Version("v0.9.0-ALPHA"));
        
        assertNotEquals("1.0.0", new Version("1.0.0"));
        assertNotEquals("1.0.0", new Version("v1.0.0"));
        assertNotEquals(100, new Version("1.0.0"));
    }

    @Test
    public void hash() {
        assertEquals((new Version("1.0.0")).hashCode(), new Version("1.0.0").hashCode());
        assertEquals((new Version("1.0.0")).hashCode(), new Version("v1.0.0").hashCode());
        assertEquals((new Version("1.0.0-Alpha")).hashCode(), new Version("1.0.0-ALPHA").hashCode());
        assertEquals((new Version("1.0.0-alpha")).hashCode(), new Version("v1.0.0-ALPHA").hashCode());
        assertEquals((new Version("1.0.0-alpha")).hashCode(), new Version("1.0.0-alpha").hashCode());
        assertEquals((new Version("1.0.0-alpha")).hashCode(), new Version("v1.0.0-alpha").hashCode());

        assertNotEquals(new Version("1.0.0").hashCode(), new Version("0.9.0").hashCode());
        assertNotEquals(new Version("1.0.0").hashCode(), new Version("v0.9.0").hashCode());
        assertNotEquals(new Version("1.0.0").hashCode(), new Version("v0.9.0-ALPHA").hashCode());
    }
}
