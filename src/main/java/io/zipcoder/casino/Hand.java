package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

public class Hand {
    ArrayList<Card> currentHand;
    HashMap<Card.Suit, Integer> handSuitInfo;

    public ArrayList<Card> getCurrentHand()
    {
        return currentHand;
    }

    public HashMap<Card.Suit, Integer> getHandSuitInfo()
    {
        return handSuitInfo;
    }

    public Boolean addCard(Card cardToBeAdded)
    {
        Card.Suit addedCardSuit = cardToBeAdded.suit();
        currentHand.add(cardToBeAdded);

        if(handSuitInfo.containsKey(addedCardSuit))
        {
            Integer currentSuitCount = handSuitInfo.get(addedCardSuit);
            currentSuitCount++;
            handSuitInfo.put(addedCardSuit, currentSuitCount);
        }
        else
        {
            handSuitInfo.put(addedCardSuit, 1);
        }

        return currentHand.contains(cardToBeAdded);
    }

    public Boolean removeCard(Card cardToRemove)
    {
        Card.Suit removedCardSuit = cardToRemove.suit();
        currentHand.remove(cardToRemove);

        if(handSuitInfo.containsKey(cardToRemove))
        {
            Integer currentSuitCount = handSuitInfo.get(cardToRemove);
            currentSuitCount--;
            if(currentSuitCount > 1)
            {
                handSuitInfo.remove(removedCardSuit);
            }
            else
            {
                handSuitInfo.remove(removedCardSuit);
            }
        }
        else
        {
            handSuitInfo.remove(removedCardSuit);
        }

        return (!currentHand.contains(cardToRemove));
    }
}