package io.zipcoder.casino;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;

public class HandTest {
    @Test
    public void constructorTest()
    {
        Hand testNullHand = new Hand();
        List<Card> listOfCards = new ArrayList<>();
        listOfCards.add(new Card(ACE, SPADES));
        Hand testHand = new Hand();
        Hand testHandFromList = new Hand(listOfCards);
        Hand testHandWithNewCards = new Hand(new Card(JACK, DIAMONDS));
    }

//    @Test
//    public void
}
