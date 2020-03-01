package io.zipcoder.casino;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;
import static org.junit.Assert.assertEquals;

public class HandTest {
    Hand myHand;
    Hand handOfTwos;
    ArrayList<Card> allDeuces;

    @Before
    public void initialize()
    {
        allDeuces = new ArrayList<>();
        handOfTwos = new Hand(new Card(DEUCE, SPADES), new Card(DEUCE, CLUBS), new Card(DEUCE, DIAMONDS), new Card(DEUCE, HEARTS));
        myHand = new Hand(new Card(SIX, CLUBS));
    }

    @Test
    public void getHandTest()
    {

        Object[] expected = { new Card(DEUCE, SPADES), new Card(DEUCE, CLUBS), new Card(DEUCE, DIAMONDS), new Card(DEUCE, HEARTS) };

        Object[] actual = handOfTwos.getHand().toArray();

        assertEquals(expected, actual);
    }

    @Test
    public void addCardTest()
    {
        Object[] expected = { new Card(DEUCE, SPADES), new Card(DEUCE, CLUBS), new Card(DEUCE, DIAMONDS), new Card(DEUCE, HEARTS), new Card(EIGHT, SPADES) };

        handOfTwos.addCard(new Card(EIGHT, SPADES));

        Object[] actual = handOfTwos.getHand().toArray();

        assertEquals(expected, actual);
    }

    @Test
    public void removeCardTest()
    {
        Object[] expected = { };
        Boolean expectedSuccess = true;

        Boolean actualSuccess = myHand.removeCard(new Card(SIX, CLUBS));
        Object[] actual = myHand.getHand().toArray();

        assertEquals(expected, actual);
        assertEquals(expectedSuccess, actualSuccess);
    }

    @Test
    public void removeCardFailTest()
    {
        Object[] expected = { new Card(SIX, CLUBS) };
        Boolean expectedSuccess = false;

        Boolean actualSuccess = myHand.removeCard(new Card(SIX, DIAMONDS));
        Object[] actual = myHand.getHand().toArray();

        assertEquals(expected, actual);
        assertEquals(expectedSuccess, actualSuccess);
    }
}
