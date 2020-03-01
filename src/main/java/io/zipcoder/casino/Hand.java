package io.zipcoder.casino;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    ArrayList<Card> currentHand;

    public Hand()
    {
        currentHand = new ArrayList<>();
    }

    public Hand(Card... startingCards)
    {
        currentHand = new ArrayList<>();
        for(Card card : startingCards)
        {
            currentHand.add(card);
        }
    }

    public ArrayList<Card> getHand()
    {
        return currentHand;
    }

    public Boolean addCard(Card cardToBeAdded)
    {
        currentHand.add(cardToBeAdded);
        return currentHand.contains(cardToBeAdded);
    }

    public Boolean removeCard(Card cardToRemove)
    {
        if(currentHand.contains(cardToRemove))
        {
            currentHand.remove(cardToRemove);
            return true;
        }
        else
        {
            return false;
        }
    }
}