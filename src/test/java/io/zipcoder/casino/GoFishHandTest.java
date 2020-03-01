package io.zipcoder.casino;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;
import static org.junit.Assert.assertEquals;

public class GoFishHandTest {
    GoFishHand myHand;
    GoFishHand opponentHand;

    @Before
    public void initialize()
    {
        myHand = new GoFishHand();
        myHand.addCard(new Card(DEUCE, DIAMONDS));
        opponentHand = new GoFishHand();
        opponentHand.addCard(new Card(KING, DIAMONDS));
        opponentHand.addCard(new Card(KING, SPADES));
        opponentHand.addCard(new Card(KING, HEARTS));
        opponentHand.addCard(new Card(KING, CLUBS));
        opponentHand.addCard(new Card(SEVEN, HEARTS));
    }

    @Test
    public void getRankInfoTest()
    {
        HashMap<Card.Rank, Integer> expected = new HashMap<>();
        expected.put(DEUCE, 1);

        HashMap<Card.Rank, Integer> actual = myHand.getRankInfo();

        assertEquals(expected, actual);
    }

    @Test
    public void getRankInfoTestTwo()
    {
        HashMap<Card.Rank, Integer> expected = new HashMap<>();
        expected.put(KING, 4);
        expected.put(SEVEN, 1);

        HashMap<Card.Rank, Integer> actual = opponentHand.getRankInfo();

        assertEquals(expected, actual);
    }
}