package io.zipcoder.casino;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> deckOfCards;

    public Deck()
    {
        deckOfCards = new Stack<Card>();

        for(Card.Suit suit : Card.Suit.values())
        {
            for(Card.Rank rank : Card.Rank.values())
            {
                Card cardForDeck = new Card(rank, suit);
                deckOfCards.push(cardForDeck);
            }
        }

        Collections.shuffle(deckOfCards);
    }

    public Card deal()
    {
        if (deckOfCards.isEmpty()) {
            for (Card.Suit suit : Card.Suit.values())
            {
                for (Card.Rank rank : Card.Rank.values())
                {
                    Card cardForDeck = new Card(rank, suit);
                    deckOfCards.push(cardForDeck);
                }
            }
            Collections.shuffle(deckOfCards);
        }

        return deckOfCards.pop();
    }
}
