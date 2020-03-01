package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;
import static org.junit.Assert.assertEquals;

public class HandTest {
    Hand myHand;
    Card myCard;
    Hand handOfTwos;
    ArrayList<Card> allDeuces;

    @Before
    public void initialize()
    {
        allDeuces = new ArrayList<>();
        allDeuces.add(new Card(DEUCE, SPADES));
        allDeuces.add(new Card(DEUCE, CLUBS));
        allDeuces.add(new Card(DEUCE, DIAMONDS));
        allDeuces.add(new Card(DEUCE, HEARTS));
        handOfTwos = new Hand(allDeuces);
        myCard = new Card(QUEEN, HEARTS);
        myHand = new Hand();
        myHand.addCard(myCard);
    }

    @Test
    public void getHandTest()
    {

        ArrayList<Card> expected = allDeuces;

        ArrayList<Card> actual = handOfTwos.getHand();

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

        Boolean actualSuccess = myHand.removeCard(myCard);
        Object[] actual = myHand.getHand().toArray();

        assertEquals(expected, actual);
        assertEquals(expectedSuccess, actualSuccess);
    }

    @Test
    public void removeCardFailTest()
    {
        Object[] expected = { myCard };
        Boolean expectedSuccess = false;

        Boolean actualSuccess = myHand.removeCard(new Card(SIX, DIAMONDS));
        Object[] actual = myHand.getHand().toArray();

        assertEquals(expected, actual);
        assertEquals(expectedSuccess, actualSuccess);
    }
}
