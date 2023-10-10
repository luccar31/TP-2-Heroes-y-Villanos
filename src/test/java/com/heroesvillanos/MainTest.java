package com.heroesvillanos;


import org.junit.Ignore;
import org.junit.Test;

import org.junit.Assert;

public class MainTest {

    @Test
    public void assertTrue(){
        Assert.assertTrue(true);
    }

    @Test
    @Ignore
    public void assertFalse(){
        Assert.fail();
    }
}
