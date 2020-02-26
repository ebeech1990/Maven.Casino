package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardPlayer extends Player
{
    private ArrayList<Card> hand;

    public CardPlayer(String name, Wallet gamblingWallet)
    {
        super(name, gamblingWallet);
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand()
    {
        return this.hand;
    }

    public Boolean receiveCard(Card newCard)
    {
        hand.add(newCard);

        if(hand.contains(newCard))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Card discard(Card unwantedCard)
    {
        if(hand.contains(unwantedCard))
        {
            hand.remove(unwantedCard);
            return unwantedCard;
        }
        else
        {
            return null;
        }
    }
}
