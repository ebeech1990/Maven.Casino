package io.zipcoder.casino;

        import io.zipcoder.casino.gamePlayers.KlondikeHumanPlayer;
        import org.junit.Assert;
        import org.junit.Test;

        import java.util.ArrayList;

public class KlondikePlayerTest
{
    private Object ArrayList;
    private Object Integer;

    @Test
    public void rollDiceHand()
    {
        KlondikeHumanPlayer makeHand = new KlondikeHumanPlayer("Bill", new Wallet());
        ArrayList<Integer> newHand = makeHand.humanHand();
        Assert.assertEquals(makeHand, newHand);

    }

    @Test
    public void findPairTest()
    {

        //Integer findPair = 1;
        KlondikeHumanPlayer findPair = new KlondikeHumanPlayer("Jeff", new Wallet());
        Integer pairScore = findPair.pairHuman();
        Assert.assertEquals(findPair, pairScore);
    }
}

