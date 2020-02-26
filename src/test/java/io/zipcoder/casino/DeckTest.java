package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    @Test

    public void getACard()
    {
        Deck testDeck = new Deck();

        Object actual = testDeck.deal();

        Assert.assertTrue(actual instanceof Card);
    }
}
