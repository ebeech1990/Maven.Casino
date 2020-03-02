package io.zipcoder.casino.gamePlayers;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Wallet;

import java.util.ArrayList;

public abstract class CardPlayer extends Player
{
    // TODO: Fix after MVP -- I dislike package privacy level
    protected Hand playerHand;

    public CardPlayer(String name, Wallet gamblingWallet)
    {
        super(name, gamblingWallet);
    }

    public ArrayList<Card> getHand()
    {
        return this.playerHand.getHand();
    }

    public Boolean receiveCard(Card newCard)
    {
        playerHand.addCard(newCard);

        if(playerHand.getHand().contains(newCard))
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
        if(playerHand.getHand().contains(unwantedCard))
        {
            playerHand.removeCard(unwantedCard);
            return unwantedCard;
        }
        else
        {
            return null;
        }
    }
}