package io.zipcoder.casino;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;


import java.util.Scanner;


public class CasinoTest{
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }


//    @Test
//    public void displayMenuTest() throws IOException  {
//
//        final String testString = "1";
//        provideInput(testString);
//                Casino myCasino = new Casino();
//        myCasino.displayMenu();
//
//
//        Assert.assertEquals(testString, getOutput());
//    }


}
