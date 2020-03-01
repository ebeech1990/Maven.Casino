package io.zipcoder.casino;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    ArrayList<Card> currentHand;

    public Hand()
    {
        this(new ArrayList<Card>());
    }

    public Hand(List<Card> cardsForHand)
    {
        currentHand = new ArrayList<>();
        currentHand.addAll(cardsForHand);
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