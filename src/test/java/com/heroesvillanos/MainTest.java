package com.heroesvillanos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void assertTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    @Disabled
    public void assertFalse() {
        Assertions.fail();
    }
}
