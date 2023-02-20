package dev.rusthero.versionchecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {
    @Test
    void testToString() {
        assertEquals("1.0.0", new Version("1.0.0").toString());
        assertEquals("1.0.0", new Version("v1.0.0").toString());
        assertEquals("1.0.0-alpha", new Version("1.0.0-ALPHA").toString());
    }

    @Test
    void testEquals() {
        assertEquals((new Version("1.0.0")), new Version("1.0.0"));
        assertEquals((new Version("1.0.0")), new Version("v1.0.0"));
        assertEquals((new Version("1.0.0-Alpha")), new Version("1.0.0-ALPHA"));
        assertEquals((new Version("1.0.0-alpha")), new Version("v1.0.0-ALPHA"));
        assertEquals((new Version("1.0.0-alpha")), new Version("1.0.0-alpha"));
        assertEquals((new Version("1.0.0-alpha")), new Version("v1.0.0-alpha"));

        assertNotEquals(new Version("1.0.0"), new Version("0.9.0"));
        assertNotEquals(new Version("1.0.0"), new Version("v0.9.0"));
        assertNotEquals(new Version("1.0.0"), new Version("v0.9.0-ALPHA"));

        // They shall not be equal because not same type.
        if (new Version("1.0.0").equals(100)) fail();
    }

    @Test
    void testHashCode() {
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
