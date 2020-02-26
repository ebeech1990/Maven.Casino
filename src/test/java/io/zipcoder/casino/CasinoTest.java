package io.zipcoder.casino;


import org.junit.Assert;
import org.junit.Test;

public class CasinoTest {
    @Test
    public void displayMenuTest() {
        Casino myCasino = new Casino();
        myCasino.displayMenu();
    }
}
