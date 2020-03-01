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
    Card aceOfSpaces;
    Card queenOfHearts;

    @Before
    public void initialize()
    {
        aceOfSpaces = new Card(ACE, SPADES);
        queenOfHearts = new Card(QUEEN, HEARTS);
        myHand = new BlackjackHand();
        myHand.addCard(aceOfSpaces);
        myHand.addCard(queenOfHearts);
    }

    @Test
    public void handValueTest()
    {
        Integer expected = 21;

        myHand.getCurrentHand();

      //  assertEquals(expected, actual);
    }
}
