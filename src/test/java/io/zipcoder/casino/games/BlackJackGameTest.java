package io.zipcoder.casino.games;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackGameTest {

    @Test
    public void testBjGame() {

        Integer testPot = 20;
        BlackJackGame testBjGame = new BlackJackGame(testPot);
        Integer expected = 20;

        Integer actual = testBjGame.pot;

        Assert.assertEquals(expected, actual);
    }


}