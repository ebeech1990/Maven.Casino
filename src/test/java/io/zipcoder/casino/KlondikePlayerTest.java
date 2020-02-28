package io.zipcoder.casino;

import io.zipcoder.casino.gamePlayers.KlondikeHumanPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class KlondikePlayerTest
{
    @Test
    public void rollDiceHand()
    {
        KlondikeHumanPlayer makeHand = new KlondikeHumanPlayer("Bill", new Wallet());
        ArrayList<Integer> newHand = makeHand.humanHand();
        Assert.assertEquals(makeHand, newHand);

    }
}
