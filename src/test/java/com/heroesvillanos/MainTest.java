package com.heroesvillanos;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {

    @Test
    public void assertTrue() {
        Assert.assertTrue(true);
    }

    @Test
    @Ignore
    public void assertFalse() {
        Assert.fail();
    }
}
