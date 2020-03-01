package io.zipcoder.casino;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;
import static org.junit.Assert.assertEquals;

public class BlackjackHandTest {
    BlackjackHand myHand;
    BlackjackHand opponentHand;

    @Before
    public void initialize()
    {
        myHand = new BlackjackHand();
        myHand.addCard(new Card(ACE, DIAMONDS));
        myHand.addCard(new Card(TEN, DIAMONDS));

        opponentHand = new BlackjackHand();
        opponentHand.addCard(new Card(ACE, SPADES));
        opponentHand.addCard(new Card(ACE, CLUBS));

    }

    @Test
    public void handValueTest()
    {
        Integer expected = 21;

        Integer actual = myHand.sumOfHand();

        assertEquals(expected, actual);
    }

    @Test
    public void aceReeval()
    {
        Integer expected = 12;

        Integer actual = opponentHand.sumOfHand();

        assertEquals(expected, actual);
    }
}
