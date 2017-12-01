package com.genericrest.util;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class CriptographyTest {

    private static final String PASS_ONE = "senha10";
    private static final String PASS_TWO = "senha100";

    @Test
    public void criptographyTest() {
        String passOne = Criptography.encrypt(PASS_ONE);
        Assert.assertNotEquals(passOne, PASS_ONE);

        String passTwo = Criptography.encrypt(PASS_TWO);
        Assert.assertNotEquals(passTwo, PASS_TWO);
        
        Assert.assertNotEquals(passOne, passTwo);
    }
}
