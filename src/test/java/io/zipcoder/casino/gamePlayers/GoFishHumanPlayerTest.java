package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Wallet;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;
import static org.junit.Assert.*;

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

    @Test
    public void scoreWithJacks()
    {
        // GIVEN

        Integer expectedScore = 1;
        GoFishHumanPlayer testPlayer = new GoFishHumanPlayer("Jackie Chan", new Wallet());
        Card jackOfSpades = new Card(JACK, SPADES);
        Card jackOfDiamonds = new Card(JACK, DIAMONDS);
        Card jackOfClubs = new Card(JACK, CLUBS);
        Card jackOfHearts = new Card(JACK, HEARTS);

        testPlayer.receiveCard(jackOfSpades);
        testPlayer.receiveCard(jackOfDiamonds);
        testPlayer.receiveCard(jackOfClubs);
        testPlayer.receiveCard(jackOfHearts);

        // WHEN

        testPlayer.takeSet(JACK);
        Integer actualScore = testPlayer.getScore();

        // THEN

        assertEquals(expectedScore, actualScore);
        assertTrue(testPlayer.getHand().isEmpty());

    }

    @Test
    public void failToTakeFours()
    {
        // GIVEN

        Integer expectedScore = 0;
        GoFishHumanPlayer testPlayer = new GoFishHumanPlayer("Overly Eager", new Wallet());
        Card fourOfSpades = new Card(FOUR, SPADES);
        Card fourOfDiamonds = new Card(FOUR, DIAMONDS);
        Card fourOfClubs = new Card(FOUR, CLUBS);


        testPlayer.receiveCard(fourOfSpades);
        testPlayer.receiveCard(fourOfDiamonds);
        testPlayer.receiveCard(fourOfClubs);


        // WHEN

        testPlayer.takeSet(JACK);
        testPlayer.takeSet(FOUR);
        Integer actualScore = testPlayer.getScore();

        // THEN

        assertEquals(expectedScore, actualScore);
        assertFalse(testPlayer.getHand().isEmpty());
    }
}