package io.zipcoder.casino.games;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackGameTest {

    @Test
    public void testBjGame() {

        BlackJackGame testBjGame = new BlackJackGame();
        Integer expected = 0;

        Integer actual = testBjGame.pot;

        Assert.assertEquals(expected, actual);
    }


}