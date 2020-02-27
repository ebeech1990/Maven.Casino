package io.zipcoder.casino.gamePlayers;

import com.sun.org.apache.xpath.internal.operations.Bool;
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

        assertEquals(expected, actual);
        assertEquals(expectedAfter, handAfter);
    }

    @Test
    public void takeThrees()
    {
        GoFishHumanPlayer testPlayer = new GoFishHumanPlayer("Three Taker", new Wallet(0));
        Card threeOfSpades = new Card(THREE, SPADES);
        Card threeOfDiamonds = new Card(THREE, DIAMONDS);
        Card threeOfClubs = new Card(THREE, CLUBS);
        Card threeOfHearts = new Card(THREE, HEARTS);
        Boolean expected = true;
        Integer expectedScore = 1;
        Boolean expectedFailure = false;
        Integer expectedScoreAfterFailure = 1;

        testPlayer.receiveCard(threeOfSpades);
        testPlayer.receiveCard(threeOfDiamonds);
        testPlayer.receiveCard(threeOfClubs);
        testPlayer.receiveCard(threeOfHearts);

        Boolean actual = testPlayer.takeSet(THREE);
        Integer actualScore = testPlayer.getScore();
        Boolean actualFailure = testPlayer.takeSet(QUEEN);
        Integer actualScoreAfterFailure = testPlayer.getScore();

        assertEquals(expected, actual);
        assertEquals(expectedScore, actualScore);
        assertEquals(expectedFailure, actualFailure);
        assertEquals(expectedScoreAfterFailure, actualScoreAfterFailure);
    }
}