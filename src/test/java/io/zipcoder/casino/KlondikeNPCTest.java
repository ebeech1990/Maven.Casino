package io.zipcoder.casino;

import io.zipcoder.casino.gamePlayers.KlondikeHumanPlayer;
import io.zipcoder.casino.gamePlayers.KlondikeNPC;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class KlondikeNPCTest
{
    @Test
    public void rollDiceHand()
    {
        KlondikeNPC makeHand = new KlondikeNPC("Hal", new Wallet());
        ArrayList<Integer> newHand = makeHand.npcHand();
        Assert.assertEquals(makeHand, newHand);

    }
}
