package io.zipcoder.casino.games;

import io.zipcoder.casino.Wallet;
import io.zipcoder.casino.gamePlayers.BlackJackHumanPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class BlackJackGameTest {

    private static final Logger LOGGER = Logger.getLogger(BlackJackGameTest.class.getName());

    @Test
    public void testBjGame() {

        Integer testPot = 20;
        Wallet testWallet = new Wallet(20);
        BlackJackHumanPlayer testPlayer = new BlackJackHumanPlayer("Bob", 20);
        BlackJackGame testBjGame = new BlackJackGame(testPlayer, testPot);
        Integer expected = 20;

        Integer actual = testBjGame.pot;
        LOGGER.log(Level.INFO, "" + actual + expected);

        Assert.assertEquals(expected, actual);
    }


}