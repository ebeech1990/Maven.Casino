package io.zipcoder.casino;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiceTest {

    @Test
    public void rollTest()
    {
        // GIVEN

        Dice testDie = new Dice();
        Double expected = 3.5;

        // WHEN

        Integer actual = testDie.roll();

        // THEN

        assertEquals(expected, actual, 2.5);
    }
}
