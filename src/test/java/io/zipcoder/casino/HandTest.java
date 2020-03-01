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
    Hand handOfTwos;
    ArrayList<Card> allDeuces;

    @Before
    public void setup()
    {
        allDeuces = new ArrayList<>();
        allDeuces.add(new Card(DEUCE, SPADES));
        allDeuces.add(new Card(DEUCE, CLUBS));
        allDeuces.add(new Card(DEUCE, DIAMONDS));
        allDeuces.add(new Card(DEUCE, HEARTS));
        Hand handOfTwos = new Hand(allDeuces);
    }

    @Test
    public void constructorTest()
    {
        Hand testNullHand = new Hand();
        List<Card> listOfCards = new ArrayList<>();
        listOfCards.add(new Card(ACE, SPADES));
        Hand testHand = new Hand();
        Hand testHandFromList = new Hand(listOfCards);
    }
}
