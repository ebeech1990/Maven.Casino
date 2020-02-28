package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Wallet;

import java.util.ArrayList;

public abstract class CardPlayer extends Player
{
    // TODO: Fix after MVP -- I dislike package privacy level
    protected ArrayList<Card> hand;

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