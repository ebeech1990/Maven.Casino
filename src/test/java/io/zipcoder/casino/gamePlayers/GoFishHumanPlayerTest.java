package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Wallet;
import org.junit.Test;
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

        assertEquals(expected, actual);
        assertEquals(expectedAfter, handAfter);
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
    public void failToTakeFours() {
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

    @Test
    public void fishForSixes()
    {
        Boolean expected = true;
        ArrayList<Card> expectedDefenderHand = new ArrayList<Card>();
        Card cardA = new Card(KING, CLUBS);
        Card cardB = new Card(ACE, DIAMONDS);
        Card cardC = new Card(SIX, HEARTS);
        expectedDefenderHand.add(cardA);
        expectedDefenderHand.add(cardB);

        GoFishHumanPlayer attacker = new GoFishHumanPlayer("Taking Cards", new Wallet());
        GoFishNPC defender = new GoFishNPC();


        defender.receiveCard(cardA);
        defender.receiveCard(cardB);
        defender.receiveCard(cardC);

        attacker.receiveCard(new Card(SIX, DIAMONDS));
        attacker.receiveCard(new Card(SIX, CLUBS));
        attacker.receiveCard(new Card(SIX, SPADES));

        Boolean actual = attacker.fishing(defender, SIX);
        Boolean actualTakeResult = attacker.takeSet(SIX);
        ArrayList<Card> actualDefenderHand = defender.getHand();

        assertFalse(defender.getHand().isEmpty());
        assertEquals(expected, actual);
        assertTrue(actualTakeResult);
        assertTrue(attacker.getHand().isEmpty());
        assertEquals(expectedDefenderHand, actualDefenderHand);
    }
}