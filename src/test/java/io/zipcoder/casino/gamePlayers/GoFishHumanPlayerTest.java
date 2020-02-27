package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Wallet;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;
import static org.junit.Assert.assertEquals;

public class GoFishHumanPlayerTest
{
    @Test
    public void getScore()
    {
        // GIVEN

        GoFishHumanPlayer testPlayer = new GoFishHumanPlayer("Fishy Fisherson", new Wallet(500));
        Integer expected = 0;

        // WHEN

        Integer actual = testPlayer.getScore();

        // THEN

        assertEquals(expected, actual);
    }
    // TODO: fishing

    @Test
    public void fishedMyKings()
    {
        GoFishHumanPlayer testPlayer = new GoFishHumanPlayer("Testy McTest", new Wallet(0));
        Card kingOfHearts = new Card(KING, HEARTS);
        Card kingOfSpades = new Card(KING, SPADES);
        Card jackOfSpades = new Card(JACK, SPADES);
        ArrayList<Card> expected = new ArrayList<>();
        expected.add(kingOfHearts);
        expected.add(kingOfSpades);
        ArrayList<Card> expectedAfter = new ArrayList<>();
        expectedAfter.add(jackOfSpades);

        testPlayer.receiveCard(kingOfHearts);
        testPlayer.receiveCard(kingOfSpades);
        testPlayer.receiveCard(jackOfSpades);

        ArrayList<Card> actual = testPlayer.fishedFrom(KING);
        ArrayList<Card> handAfter = testPlayer.getHand();

        assertEquals(expected.toArray(), actual.toArray());
        assertEquals(expectedAfter.toArray(), handAfter.toArray());
    }

    // TODO: takeSet
}